package net.lab1024.sa.admin.module.system.role.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RoleDepartmentEntity {
    @ApiModelProperty("员工id")
    private Long employeeId;

    @ApiModelProperty("部门id")
    @NotNull(message = "部门id不能为空")
    private Long departmentId;

    @ApiModelProperty("部门名称")
    @NotNull(message = "部门名称不能为空")
    private Long name;
}
