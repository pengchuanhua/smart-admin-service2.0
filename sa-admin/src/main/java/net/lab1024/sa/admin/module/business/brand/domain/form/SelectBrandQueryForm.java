package net.lab1024.sa.admin.module.business.brand.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.common.common.domain.PageParam;

/**
 * 品牌 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-27 17:16:42
 * @Copyright v1.0
 */

@Data
public class SelectBrandQueryForm{

    @ApiModelProperty(value = "品牌编码/名称")
    private String brand;

    @ApiModelProperty(value = "品牌编码")
    private String code;

    @ApiModelProperty(value = "品牌名称")
    private String name;

}