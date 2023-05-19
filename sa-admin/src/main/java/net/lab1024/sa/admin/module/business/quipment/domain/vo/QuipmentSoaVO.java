package net.lab1024.sa.admin.module.business.quipment.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 设备信息 状态
 *
 * @Author pengch
 * @Date 2023-04-28 18:56:09
 * @Copyright v1.0
 */

@Data
public class QuipmentSoaVO {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "设备编码")
    private String quipmentSn;

    @ApiModelProperty(value = "设备名称")
    private String quipmentName;

    @ApiModelProperty(value = "用电量")
    private BigDecimal sumElectricity;

    @ApiModelProperty(value = "设备状态")
    private int type;

    @ApiModelProperty(value = "更新时间")
    private Date createTime;

}