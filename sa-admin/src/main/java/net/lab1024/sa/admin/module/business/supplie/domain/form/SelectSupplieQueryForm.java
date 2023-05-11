package net.lab1024.sa.admin.module.business.supplie.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.admin.module.business.supplie.constant.SupplieStatusEnum;
import net.lab1024.sa.common.common.domain.PageParam;
import net.lab1024.sa.common.common.swagger.ApiModelPropertyEnum;
import net.lab1024.sa.common.common.validator.enumeration.CheckEnum;

/**
 * 供应商 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-27 17:15:30
 * @Copyright v1.0
 */

@Data
public class SelectSupplieQueryForm{

    @ApiModelProperty(value = "供应商信息")
    private String supplie;

    @ApiModelProperty(value = "联系人")
    private String contacts;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelPropertyEnum(value = SupplieStatusEnum.class, desc = "有效标记(0:有效,1:无效)")
    @CheckEnum(value = SupplieStatusEnum.class, message = "有效标记(0:有效,1:无效) 错误")
    private Integer isDisabled;

}