package net.lab1024.sa.admin.module.system.role.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.lab1024.sa.admin.common.AdminBaseController;
import net.lab1024.sa.admin.constant.AdminSwaggerTagConst;
import net.lab1024.sa.admin.module.business.depot.domain.vo.DepotVO;
import net.lab1024.sa.admin.module.business.quipment.domain.vo.QuipmentVO;
import net.lab1024.sa.admin.module.system.department.domain.vo.DepartmentVO;
import net.lab1024.sa.admin.module.system.employee.domain.entity.EmployeeEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleDepartmentEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleDepotEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleQuipmentEntity;
import net.lab1024.sa.admin.module.system.role.domain.form.QueryUserRolseForm;
import net.lab1024.sa.admin.module.system.role.domain.form.RoleDataScopeUpdateForm;
import net.lab1024.sa.admin.module.system.role.domain.form.UserRolseAddForm;
import net.lab1024.sa.admin.module.system.role.domain.form.UserRolseUpdateForm;
import net.lab1024.sa.admin.module.system.role.domain.vo.QueryUserRolseVO;
import net.lab1024.sa.admin.module.system.role.domain.vo.RoleDataScopeVO;
import net.lab1024.sa.admin.module.system.role.service.RoleDataScopeService;
import net.lab1024.sa.common.common.domain.ResponseDTO;
import net.lab1024.sa.common.module.support.operatelog.annoation.OperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 角色的数据权限配置
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-02-26 22:09:59
 * @Wechat zhuoda1024
 * @Email lab1024@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@OperateLog
@RestController
@Api(tags = {AdminSwaggerTagConst.System.SYSTEM_ROLE_DATA_SCOPE})
public class RoleDataScopeController extends AdminBaseController {

    @Autowired
    private RoleDataScopeService roleDataScopeService;



    @ApiOperation(value = "获取某角色所设置的数据范围 @author 卓大")
    @GetMapping("/role/dataScope/getRoleDataScopeList/{roleId}")
    public ResponseDTO<List<RoleDataScopeVO>> dataScopeListByRole(@PathVariable Long roleId) {
        return roleDataScopeService.getRoleDataScopeList(roleId);
    }

    @ApiOperation(value = "批量设置某角色数据范围 @author 卓大")
    @PostMapping("/role/dataScope/updateRoleDataScopeList")
    @PreAuthorize("@saAuth.checkPermission('system:role:dataScope:update')")
    public ResponseDTO<String> updateRoleDataScopeList(@RequestBody @Valid RoleDataScopeUpdateForm roleDataScopeUpdateForm) {
        return roleDataScopeService.updateRoleDataScopeList(roleDataScopeUpdateForm);
    }


    @ApiOperation(value = "查询人员数据权限")
    @PostMapping("/role/dataScope/queryUserRole")
    public ResponseDTO<QueryUserRolseVO> queryUserRole(@RequestBody @Valid QueryUserRolseForm queryUserRolseForm) {
        EmployeeEntity employeeEntity=new EmployeeEntity();
        QueryUserRolseVO queryUserRolseVO=new QueryUserRolseVO();
        employeeEntity.setEmployeeId(queryUserRolseForm.getEmployeeId());
        //定义人员-仓库权限-查询
        List<RoleDepotEntity> userWareHouses = roleDataScopeService.queryWareHouseItem(employeeEntity);
        queryUserRolseVO.setUserWareHouses(userWareHouses);
        //定义人员-设备权限-查询
        List<RoleQuipmentEntity> quipmentVOS = roleDataScopeService.queryQuipmentItem(employeeEntity);
        queryUserRolseVO.setUserQuipmentVOS(quipmentVOS);
        //定义人员-部门权限-查询
        List<RoleDepartmentEntity> userDeparts = roleDataScopeService.queryDepartmentItem(employeeEntity);
        queryUserRolseVO.setUserDeparts(userDeparts);
        return ResponseDTO.ok(queryUserRolseVO);
    }


    @ApiOperation(value = "新增人员数据权限 @author pengch")
    @PostMapping("/role/dataScope/add")
    public ResponseDTO<String> add(@RequestBody @Valid UserRolseAddForm addForm) {
        return roleDataScopeService.add(addForm);
    }

    @ApiOperation("更新人员数据权限 @author pengch")
    @PostMapping("/role/dataScope/update")
    public ResponseDTO<String> update(@RequestBody @Valid UserRolseUpdateForm updateForm) {
        return roleDataScopeService.update(updateForm);
    }


    @ApiOperation("删除人员数据权限 @author pengch")
    @GetMapping("/role/dataScope/delete/{employeeId}")
    public ResponseDTO<String> delete(@PathVariable Long employeeId) {
        return roleDataScopeService.delete(employeeId);
    }


}
