package net.lab1024.sa.admin.module.system.department.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import net.lab1024.sa.admin.module.business.location.domain.entity.LocationEntity;
import net.lab1024.sa.admin.module.business.location.domain.vo.LocationTreeVO;
import net.lab1024.sa.admin.module.system.department.dao.DepartmentDao;
import net.lab1024.sa.admin.module.system.department.domain.form.DepartmentTreeQueryForm;
import net.lab1024.sa.admin.module.system.department.domain.vo.DepartmentTreeListVO;
import net.lab1024.sa.admin.module.system.department.domain.vo.DepartmentTreeVO;
import net.lab1024.sa.common.common.util.SmartBeanUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.lab1024.sa.admin.module.system.department.domain.entity.DepartmentEntity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 部门
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-01-12 20:37:48
 * @Wechat zhuoda1024
 * @Email lab1024@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Service
public class DepartmentManager extends ServiceImpl<DepartmentDao, DepartmentEntity> {

    @Autowired
    private DepartmentDao departmentDao;
    public List<DepartmentTreeListVO> queryDepartmentTree(DepartmentTreeQueryForm queryForm, Long parentId) {
        List<DepartmentEntity> departmentEntities = departmentDao.queryDepartment(queryForm);
        List<DepartmentEntity> departmentEntityList = departmentEntities.stream().filter(e -> e.getParentId().equals(parentId)).collect(Collectors.toList());
        List<DepartmentTreeListVO> treeList = SmartBeanUtil.copyList(departmentEntityList, DepartmentTreeListVO.class);
        treeList.forEach(e -> {
            e.setLabel(e.getName());
            e.setValue(e.getDepartmentId());
        });
        // 递归设置子类
        this.queryAndSetSubLocation(treeList, departmentEntityList);
        return treeList;
    }

    private void queryAndSetSubLocation(List<DepartmentTreeListVO> treeList, List<DepartmentEntity> departmentEntityList) {
        if (CollectionUtils.isEmpty(treeList)) {
            return;
        }
        List<Long> parentIdList = treeList.stream().map(DepartmentTreeListVO::getValue).collect(Collectors.toList());
        List<DepartmentEntity> departmentEntities = departmentEntityList.stream().filter(e -> parentIdList.contains(e.getParentId())).collect(Collectors.toList());
        Map<Long, List<DepartmentEntity>> LocationSubMap = departmentEntities.stream().collect(Collectors.groupingBy(DepartmentEntity::getParentId));
        treeList.forEach(e -> {
            List<DepartmentEntity> childrenEntityList = LocationSubMap.getOrDefault(e.getValue(), Lists.newArrayList());
            List<DepartmentTreeListVO> childrenVOList = SmartBeanUtil.copyList(childrenEntityList, DepartmentTreeListVO.class);
            childrenVOList.forEach(item -> {
                item.setLabel(item.getName());
                item.setValue(item.getDepartmentId());
            });
            // 递归查询
            this.queryAndSetSubLocation(childrenVOList, departmentEntityList);
            e.setChildren(childrenVOList);
        });
    }
}
