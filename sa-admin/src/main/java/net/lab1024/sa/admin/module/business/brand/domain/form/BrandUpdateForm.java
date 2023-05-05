package net.lab1024.sa.admin.module.business.brand.domain.form;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 品牌 更新表单
 *
 * @Author pengch
 * @Date 2023-04-27 17:16:42
 * @Copyright v1.0
 */

@Data
public class BrandUpdateForm {

    @ApiModelProperty(value = "主键ID", required = true)
    @NotNull(message = "主键ID 不能为空")
    private Long id;

    @ApiModelProperty(value = "品牌编码", required = true)
    @NotBlank(message = "品牌编码 不能为空")
    private String code;

    @ApiModelProperty(value = "品牌名称", required = true)
    @NotBlank(message = "品牌名称 不能为空")
    private String name;

    @ApiModelProperty(value = "有效标记", required = true)
    @NotNull(message = "有效标记 不能为空")
    private Integer isDisabled;

}