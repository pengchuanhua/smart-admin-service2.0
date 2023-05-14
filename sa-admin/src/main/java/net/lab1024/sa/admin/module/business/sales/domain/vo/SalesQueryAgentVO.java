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
public class SalesQueryAgentVO {

    @ApiModelProperty(value = "代理商id")
    private String agentName;

    @ApiModelProperty(value = "数量")
    private int salesNum;

    @ApiModelProperty(value = "销售单价")
    private BigDecimal price;

    @ApiModelProperty(value = "销售金额")
    private BigDecimal amount;

}