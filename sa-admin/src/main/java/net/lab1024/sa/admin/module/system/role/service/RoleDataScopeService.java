package net.lab1024.sa.admin.module.system.role.service;

import com.google.common.collect.Lists;
import net.lab1024.sa.admin.config.AuthenticationInfo;
import net.lab1024.sa.admin.module.business.depot.domain.entity.DepotEntity;
import net.lab1024.sa.admin.module.business.depot.domain.vo.DepotVO;
import net.lab1024.sa.admin.module.business.quipment.domain.entity.QuipmentEntity;
import net.lab1024.sa.admin.module.business.quipment.domain.form.QuipmentAddForm;
import net.lab1024.sa.admin.module.business.quipment.domain.vo.QuipmentVO;
import net.lab1024.sa.admin.module.system.department.domain.entity.DepartmentEntity;
import net.lab1024.sa.admin.module.system.department.domain.vo.DepartmentVO;
import net.lab1024.sa.admin.module.system.employee.domain.entity.EmployeeEntity;
import net.lab1024.sa.admin.module.system.role.dao.RoleDao;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleDepartmentEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleDepotEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleQuipmentEntity;
import net.lab1024.sa.admin.module.system.role.domain.form.RoleDataScopeUpdateForm;
import net.lab1024.sa.admin.module.system.role.domain.form.UserRolseAddForm;
import net.lab1024.sa.admin.module.system.role.domain.form.UserRolseUpdateForm;
import net.lab1024.sa.admin.module.system.role.domain.vo.RoleDataScopeVO;
import net.lab1024.sa.common.common.code.UserErrorCode;
import net.lab1024.sa.common.common.domain.ResponseDTO;
import net.lab1024.sa.common.common.util.SmartBeanUtil;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleDataScopeEntity;
import net.lab1024.sa.admin.module.system.role.manager.RoleDataScopeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 角色-数据范围
 *
 * @Author 1024创新实验室: 善逸
 * @Date 2021-10-22 23:17:47
 * @Wechat zhuoda1024
 * @Email lab1024@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Service
public class RoleDataScopeService {

    @Autowired
    private RoleDataScopeManager roleDataScopeManager;

    @Autowired
    private RoleDao roleDao;

    @Resource
    private AuthenticationInfo authenticationInfo;


    /**
     * 获取某个角色的数据范围设置信息
     *
     * @param roleId
     * @return
     */
    public ResponseDTO<List<RoleDataScopeVO>> getRoleDataScopeList(Long roleId) {
        List<RoleDataScopeEntity> roleDataScopeEntityList = roleDataScopeManager.getBaseMapper().listByRoleId(roleId);
        if (CollectionUtils.isEmpty(roleDataScopeEntityList)) {
            return ResponseDTO.ok(Lists.newArrayList());
        }
        List<RoleDataScopeVO> roleDataScopeList = SmartBeanUtil.copyList(roleDataScopeEntityList, RoleDataScopeVO.class);
        return ResponseDTO.ok(roleDataScopeList);
    }

    /**
     * 批量设置某个角色的数据范围设置信息
     *
     * @param roleDataScopeUpdateForm
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> updateRoleDataScopeList(RoleDataScopeUpdateForm roleDataScopeUpdateForm) {
        List<RoleDataScopeUpdateForm.RoleUpdateDataScopeListFormItem> batchSetList = roleDataScopeUpdateForm.getDataScopeItemList();
        if (CollectionUtils.isEmpty(batchSetList)) {
            return ResponseDTO.error(UserErrorCode.PARAM_ERROR, "缺少配置信息");
        }
        List<RoleDataScopeEntity> roleDataScopeEntityList = SmartBeanUtil.copyList(batchSetList, RoleDataScopeEntity.class);
        roleDataScopeEntityList.forEach(e -> e.setRoleId(roleDataScopeUpdateForm.getRoleId()));
        roleDataScopeManager.getBaseMapper().deleteByRoleId(roleDataScopeUpdateForm.getRoleId());
        roleDataScopeManager.saveBatch(roleDataScopeEntityList);
        return ResponseDTO.ok();
    }


    public List<RoleDepotEntity> queryWareHouseItem(EmployeeEntity employeeEntity){
        return  roleDao.queryWareHouseItem(employeeEntity);
    }

    public List<RoleQuipmentEntity> queryQuipmentItem(EmployeeEntity employeeEntity){
        return  roleDao.queryQuipmentItem(employeeEntity);
    }

    public List<RoleDepartmentEntity> queryDepartmentItem(EmployeeEntity employeeEntity){
        return  roleDao.queryDepartmentItem(employeeEntity);
    }

    public ResponseDTO<String> add(UserRolseAddForm addForm) {
        List<RoleDepartmentEntity>departmentEntityList= addForm.getUserDepartmentEntities();
        List<RoleQuipmentEntity>quipmentEntityList= addForm.getUserQuipmentEntities();
        List<RoleDepotEntity>depotEntityList= addForm.getUserDepotEntities();
        if(departmentEntityList.size()==0&&quipmentEntityList.size()==0
        &&depotEntityList.size()==0){
            throw new RuntimeException("请选择绑定权限后操作");
        }

//        部门权限
        if(departmentEntityList.size()>0){
            for(int i=0;i<departmentEntityList.size();i++){
                departmentEntityList.get(i).setEmployeeId(addForm.getEmployeeId());
                roleDao.insertDepartmentScope(departmentEntityList.get(i));
            }
        }

//        设备权限
        if(quipmentEntityList.size()>0){
            for(int j=0;j<quipmentEntityList.size();j++){
                quipmentEntityList.get(j).setEmployeeId(addForm.getEmployeeId());
                roleDao.insertQuipmentScope(quipmentEntityList.get(j));
            }
        }

//      仓库权限
        if(depotEntityList.size()>0){
            for(int k=0;k<depotEntityList.size();k++){
                depotEntityList.get(k).setEmployeeId(addForm.getEmployeeId());
                roleDao.insertDepotScope(depotEntityList.get(k));
            }
        }

        return ResponseDTO.ok();
    }

    public ResponseDTO<String> update(UserRolseUpdateForm updateForm) {
        List<RoleDepartmentEntity>departmentEntityList= updateForm.getUserDepartmentEntities();
        List<RoleQuipmentEntity>quipmentEntityList= updateForm.getUserQuipmentEntities();
        List<RoleDepotEntity>depotEntityList= updateForm.getUserDepotEntities();
        if( (departmentEntityList==null||departmentEntityList.size()==0)&&
                (quipmentEntityList==null||quipmentEntityList.size()==0)
                &&(quipmentEntityList==null||depotEntityList.size()==0)){
            throw new RuntimeException("请选择绑定权限后操作");
        }
        //删除部门权限
        roleDao.deleteDepartmentScope(updateForm.getEmployeeId());
        //删除设备权限
        roleDao.deleteQuipmentScope(updateForm.getEmployeeId());
        //删除仓库权限
        roleDao.deleteDepotScope(updateForm.getEmployeeId());

        //        部门权限
        if(departmentEntityList!=null&&departmentEntityList.size()>0){
            for(int i=0;i<departmentEntityList.size();i++){
                departmentEntityList.get(i).setEmployeeId(updateForm.getEmployeeId());
                departmentEntityList.get(i).setCreateName(authenticationInfo.getAuthentication().getName());
                roleDao.insertDepartmentScope(departmentEntityList.get(i));
            }
        }

//        设备权限
        if(quipmentEntityList!=null&&quipmentEntityList.size()>0){
            for(int j=0;j<quipmentEntityList.size();j++){
                quipmentEntityList.get(j).setEmployeeId(updateForm.getEmployeeId());
                quipmentEntityList.get(j).setCreateName(authenticationInfo.getAuthentication().getName());
                roleDao.insertQuipmentScope(quipmentEntityList.get(j));
            }
        }

//      仓库权限
        if(depotEntityList!=null&&depotEntityList.size()>0){
            for(int k=0;k<depotEntityList.size();k++){
                depotEntityList.get(k).setEmployeeId(updateForm.getEmployeeId());
                depotEntityList.get(k).setCreateName(authenticationInfo.getAuthentication().getName());
                roleDao.insertDepotScope(depotEntityList.get(k));
            }
        }

        return ResponseDTO.ok();
    }

    public ResponseDTO<String> delete(Long employeeId) {

        if (null == employeeId){
            return ResponseDTO.ok();
        }

        //删除部门权限
        roleDao.deleteDepartmentScope(employeeId);
        //删除设备权限
        roleDao.deleteQuipmentScope(employeeId);
        //删除仓库权限
        roleDao.deleteDepotScope(employeeId);
        return ResponseDTO.ok();
    }
}
