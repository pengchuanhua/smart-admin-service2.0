package net.lab1024.sa.admin.module.business.quipment.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.admin.module.business.quipment.constant.QuipmentStatusEnum;
import net.lab1024.sa.common.common.swagger.ApiModelPropertyEnum;
import net.lab1024.sa.common.common.validator.enumeration.CheckEnum;

/**
 * 设备信息 状态表单
 *
 * @Author pengch
 * @Date 2023-04-28 18:56:09
 * @Copyright v1.0
 */

@Data
public class QuipmentSoaQueryForm {

    @ApiModelProperty(value = "设备编码/名称")
    private String quipmentSn;

    @ApiModelProperty(value = "设备编码/名称")
    private String name;

    @ApiModelProperty(value ="设备状态")
    private Integer type;

}