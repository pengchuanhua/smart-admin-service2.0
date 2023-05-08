package net.lab1024.sa.admin.module.business.region.domain.form;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 地区信息 新建表单
 *
 * @Author pengch
 * @Date 2023-04-27 17:11:14
 * @Copyright v1.0
 */

@Data
public class RegionAddForm {

    @ApiModelProperty(value = "地区编码", required = true)
    @NotBlank(message = "地区编码 不能为空")
    private Long code;

    @ApiModelProperty(value = "上级地区编码")
    private Long parentCode;

    @ApiModelProperty(value = "地区名称", required = true)
    @NotBlank(message = "地区名称 不能为空")
    private String name;

    @ApiModelProperty(value = "地区级别", required = true)
    @NotNull(message = "地区级别 不能为空")
    private int Level;

    @ApiModelProperty(value = "末级标记", required = true)
    @NotNull(message = "末级标记 不能为空")
    private Integer endLevelFlag;

    @ApiModelProperty(value = "地区全称")
    private String fullName;

    @ApiModelProperty(value = "有效标记(0:有效,1:无效)")
    private Integer isDisabled;

}