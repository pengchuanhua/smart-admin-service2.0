package net.lab1024.sa.admin.module.business.location.domain.form;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 位置信息 新建表单
 *
 * @Author pengch
 * @Date 2023-05-06 12:04:10
 * @Copyright v1.0
 */

@Data
public class LocationAddForm {

    @ApiModelProperty(value = "编码", required = true)
    @NotBlank(message = "编码 不能为空")
    private String code;

    @ApiModelProperty(value = "上级位置编码")
    private Long parentCode;

    @ApiModelProperty(value = "位置名称", required = true)
    @NotBlank(message = "位置名称 不能为空")
    private String name;

    @ApiModelProperty(value = "位置级别", required = true)
    @NotNull(message = "位置级别 不能为空")
    private Integer Level;

    @ApiModelProperty(value = "末级标记", required = true)
    @NotNull(message = "末级标记 不能为空")
    private Integer endLevelFlag;

    @ApiModelProperty(value = "有效标记(0:有效,1:无效)", required = true)
    @NotNull(message = "有效标记(0:有效,1:无效) 不能为空")
    private Integer isDisabled;

}