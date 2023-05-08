package net.lab1024.sa.admin.module.business.path.domain.form;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 设备路线 更新表单
 *
 * @Author pengch
 * @Date 2023-04-27 17:39:58
 * @Copyright pengch
 */

@Data
public class PathUpdateForm {

    @ApiModelProperty(value = "主键ID", required = true)
    @NotNull(message = "主键ID 不能为空")
    private Long id;

    @ApiModelProperty(value = "路线编码", required = true)
    @NotBlank(message = "路线编码 不能为空")
    private String code;

    @ApiModelProperty(value = "路线名称", required = true)
    @NotBlank(message = "路线名称 不能为空")
    private String name;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态 不能为空")
    private Integer isDisabled;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "时间戳", required = true)
    @NotNull(message = "时间戳 不能为空")
    private Long ts01;

}