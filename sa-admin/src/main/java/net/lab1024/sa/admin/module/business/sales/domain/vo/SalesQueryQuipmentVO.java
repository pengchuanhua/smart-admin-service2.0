package net.lab1024.sa.admin.module.business.sales.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 设备销售表 列表VO
 *
 * @Author pengch
 * @Date 2023-04-29 19:56:46
 * @Copyright v1.0
 */

@Data
public class SalesQueryQuipmentVO {

//sum(a.sales_num),a.price,sum(a.amount),  b.id,b.quipment_sn,b.quipment_name
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "组织编码")
    private String quipmentSn;

    @ApiModelProperty(value = "设备名称")
    private String quipmentName;

    @ApiModelProperty(value = "数量")
    private int salesNum;

    @ApiModelProperty(value = "销售单价")
    private BigDecimal price;

    @ApiModelProperty(value = "销售金额")
    private BigDecimal amount;


}