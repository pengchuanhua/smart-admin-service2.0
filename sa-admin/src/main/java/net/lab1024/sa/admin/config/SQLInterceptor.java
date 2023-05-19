/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.lab1024.sa.admin.config;
/*
 *
 * @author pengch
 * @date  2023/5/11
 * @desription 权限相关 SQL拦截器
 *
 **/

import lombok.extern.slf4j.Slf4j;
import net.lab1024.sa.admin.module.system.employee.domain.entity.EmployeeEntity;
import net.lab1024.sa.admin.module.system.employee.service.EmployeeService;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleDepartmentEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleDepotEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleQuipmentEntity;
import net.lab1024.sa.admin.module.system.role.service.RoleDataScopeService;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class,Integer.class}) })
@Repository
@Slf4j
public class SQLInterceptor implements Interceptor {

    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    private  static final ReflectorFactory DEFAULT_REFLECTOR_FACTORY = new DefaultReflectorFactory();

    @Lazy
    @Autowired
    private EmployeeService employeeService;

    @Lazy
    @Autowired
    private RoleDataScopeService roleDataScopeService;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = MetaObject.forObject(
                statementHandler, DEFAULT_OBJECT_FACTORY,
                DEFAULT_OBJECT_WRAPPER_FACTORY,DEFAULT_REFLECTOR_FACTORY);

        // 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环可以分离出最原始的的目标类)
        while (metaStatementHandler.hasGetter("h")) {
            Object object = metaStatementHandler.getValue("h");
            metaStatementHandler = MetaObject.forObject(object,
                    DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY,DEFAULT_REFLECTOR_FACTORY);
        }
        // 分离最后一个代理对象的目标类
        while (metaStatementHandler.hasGetter("target")) {
            Object object = metaStatementHandler.getValue("target");
            metaStatementHandler = MetaObject.forObject(object,
                    DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY,DEFAULT_REFLECTOR_FACTORY);
        }
        // property在mybatis settings文件内配置
        Configuration configuration = (Configuration) metaStatementHandler
                .getValue("delegate.configuration");
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
        Object parameterObject = null;
        String sql = null;
        if (boundSql != null) {
            parameterObject = boundSql.getParameterObject();
            sql = boundSql.getSql();
        }
        if (sql == null) {
            sql = "";
        } else {
            sql = sql.trim();
        }
        if (true) {
            Authentication authenticationInfo=SecurityContextHolder.getContext().getAuthentication();
            if(authenticationInfo != null&&authenticationInfo.getName()!=null){
                String name = authenticationInfo.getName();
                sql = extendPlaceHolders(sql, name);
            }
        }
        if (sql.length() > 0) {
            // 清除 SQL 中的没有正常替换的占位符（如果存在）
            sql = clearPlaceHolders(sql);
        }
        // ================================================================================
        //log.info(sql);
        metaStatementHandler.setValue("delegate.boundSql.sql", sql);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }
    @Override
    public void setProperties(Properties properties) {
    }

    public String extendPlaceHolders(String sql,String auth) {
        // Pattern 匹配形如 "JL{something}JL" 的占位符
        Set<String> holders = new HashSet<String>();
        Pattern p = Pattern.compile("JL\\{.*?\\}JL");
        Matcher m = p.matcher(sql);
        while (m.find()) {
            holders.add(m.group());
        }
        for (String holder : holders) {
            String[] items = holder.substring(3, holder.length() - 3).replaceAll("\\s*","").split("\\|");
            // items 必须至少包含一个元素 (IAccess 接口的实现类类名)
            if (items.length < 1) {
                continue;
            }
            // 调用 IAccess.extend 方法填充扩展权限 SQL 并将返回结果赋予 tmp 变量
            String tmp = extend(auth, items);
            if (tmp == null || tmp.equals("")) {
                continue;
            }
            // 用扩充后的有效 SQL 字符串替换 sql 变量的值，再进入下一次循环
            sql = sql.replace(holder, tmp);
        }
        return sql;
    }

    public String clearPlaceHolders(String sql) {
        if (sql == null) {
            return null;
        }
        if (sql.equals("")) {
            return sql;
        }
        return sql.replaceAll("JL\\{.*?\\}JL", " ");
    }

    public String extend(String auth, String[] items){
        StringBuilder stringBuilder = new StringBuilder();
        if(!"admin".equals(auth) && !"anonymousUser".equals(auth)){
            if(items == null || items.length != 2){
                return "";
            }

            EmployeeEntity employeeEntity = employeeService.getByLoginName(auth);
            if("QUIPMENT".equals(items[1])){
                //设备
                List<RoleQuipmentEntity> roleQuipmentEntityList =  roleDataScopeService.queryQuipmentItem(employeeEntity);
                if(roleQuipmentEntityList.size() != 0){
                    stringBuilder.append(String.format(" AND ( ",items[0]));
                    for (int i = 0; i < roleQuipmentEntityList.size(); i++) {
                        RoleQuipmentEntity roleQuipmentEntity = roleQuipmentEntityList.get(i);
                        if(i == 0){
                            stringBuilder.append("  '"+roleQuipmentEntity.getQuipmentId()+"' = "+items[0]+"");
                        }else{
                            stringBuilder.append(" OR '"+roleQuipmentEntity.getQuipmentId()+"' = "+items[0] +"");
                        }
                    }
                    stringBuilder.append(" ) ");
                }
            }
            else if("DEPARTMENT".equals(items[1])){
                ////部门
                List<RoleDepartmentEntity> departmentEntityList =  roleDataScopeService.queryDepartmentItem(employeeEntity);
                if(departmentEntityList.size() != 0){
                    stringBuilder.append(String.format(" AND ( ",items[0]));
                    for (int i = 0; i < departmentEntityList.size(); i++) {
                        RoleDepartmentEntity departmentEntity = departmentEntityList.get(i);
                        if(i == 0){
                            stringBuilder.append(" ( "+items[0]+" LIKE CONCAT('"+departmentEntity.getDeptCode()+"','%')) ");
                        }else{
                            stringBuilder.append(" OR ( "+items[0]+" LIKE CONCAT('"+departmentEntity.getDeptCode()+"','%')) ");
                        }
                    }
                    stringBuilder.append(" ) ");
                }
            }else if("DEPOT".equals(items[1])){
                //仓库
                List<RoleDepotEntity> depotEntityList =  roleDataScopeService.queryWareHouseItem(employeeEntity);
                if(depotEntityList.size() != 0){
                    stringBuilder.append(String.format(" AND ( ",items[0]));
                    for (int i = 0; i < depotEntityList.size(); i++) {
                        RoleDepotEntity roleDepotEntity = depotEntityList.get(i);
                        if(i == 0){
                            stringBuilder.append("  '"+roleDepotEntity.getDepotId()+"' = "+items[0]+"");
                        }else{
                            stringBuilder.append(" OR '"+roleDepotEntity.getDepotId()+"' = "+items[0] +"");
                        }
                    }
                    stringBuilder.append(" ) ");
                }
            }else{
                stringBuilder.append(" '' ");
            }
        }
        return stringBuilder.toString();
    }
}
