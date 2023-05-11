package net.lab1024.sa.admin.module.system.role.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RoleQuipmentEntity {
    @ApiModelProperty("员工id")
    private Long employeeId;

    @ApiModelProperty("设备id")
    @NotNull(message = "设备id不能为空")
    private Long quipmentId;

    @ApiModelProperty("设备名称")
    @NotNull(message = "设备名称不能为空")
    private Long name;


}
