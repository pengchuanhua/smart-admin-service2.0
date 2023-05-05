package net.lab1024.sa.admin.module.business.quipment.domain.form;

import net.lab1024.sa.common.common.domain.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.admin.module.business.quipment.constant.QuipmentStatusEnum;
import net.lab1024.sa.common.common.swagger.ApiModelPropertyEnum;
import net.lab1024.sa.common.common.validator.enumeration.CheckEnum;

/**
 * 设备信息 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-28 18:56:09
 * @Copyright v1.0
 */

@Data
public class QuipmentQueryForm extends PageParam{

    @ApiModelProperty(value = "设备编码/名称")
    private String code;

    @ApiModelProperty(value = "设备型号")
    private String model;

    @ApiModelPropertyEnum(value = QuipmentStatusEnum.class, desc = "设备状态（0：停用，1：正常）")
    @CheckEnum(value = QuipmentStatusEnum.class, message = "设备状态（0：停用，1：正常） 错误")
    private Integer isDisabled;

}