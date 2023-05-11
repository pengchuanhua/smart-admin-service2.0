package net.lab1024.sa.admin.module.system.role.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.lab1024.sa.admin.module.business.depot.domain.entity.DepotEntity;
import net.lab1024.sa.admin.module.business.depot.domain.vo.DepotVO;
import net.lab1024.sa.admin.module.business.quipment.domain.entity.QuipmentEntity;
import net.lab1024.sa.admin.module.business.quipment.domain.vo.QuipmentVO;
import net.lab1024.sa.admin.module.system.department.domain.entity.DepartmentEntity;
import net.lab1024.sa.admin.module.system.department.domain.vo.DepartmentVO;
import net.lab1024.sa.admin.module.system.employee.domain.entity.EmployeeEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleDepartmentEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleDepotEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleQuipmentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleEntity;

import java.util.List;

/**
 * 角色 dao
 *
 * @Author 1024创新实验室: 罗伊
 * @Date 2022-02-26 21:34:01
 * @Wechat zhuoda1024
 * @Email lab1024@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Mapper
@Component
public interface RoleDao extends BaseMapper<RoleEntity> {

    /**
     * 根据角色名称查询
     * @param roleName
     * @return
     */
    RoleEntity getByRoleName(@Param("roleName") String roleName);

    List<RoleDepotEntity> queryWareHouseItem(EmployeeEntity personnel);

    List<RoleQuipmentEntity> queryQuipmentItem(EmployeeEntity personnel);

    List<RoleDepartmentEntity> queryDepartmentItem(EmployeeEntity personnel);

    int insertDepartmentScope(RoleDepartmentEntity departmentEntity);

    int insertQuipmentScope(RoleQuipmentEntity quipmentEntity);

    int insertDepotScope(RoleDepotEntity depotEntity);

    int deleteDepartmentScope(@Param("employeeId") Long employeeId);

    int deleteQuipmentScope(@Param("employeeId") Long employeeId);

    int deleteDepotScope(@Param("employeeId") Long employeeId);
}
