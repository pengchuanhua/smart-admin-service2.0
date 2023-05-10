package net.lab1024.sa.admin.module.business.brand.domain.form;

import net.lab1024.sa.common.common.domain.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 品牌 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-27 17:16:42
 * @Copyright v1.0
 */

@Data
public class BrandQueryForm extends PageParam{

    @ApiModelProperty(value = "品牌信息")
    private String code;

    @ApiModelProperty(value = "品牌信息")
    private String name;

}