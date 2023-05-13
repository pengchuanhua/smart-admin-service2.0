package net.lab1024.sa.admin.module.system.role.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RoleDepotEntity {
    @ApiModelProperty("员工id")
    private Long employeeId;

    @ApiModelProperty("仓库id")
    @NotNull(message = "仓库id不能为空")
    private Long depotId;

    @ApiModelProperty("仓库名称")
    @NotNull(message = "仓库名称不能为空")
    private String name;

    @ApiModelProperty("绑定人")
    private String createName;
}
