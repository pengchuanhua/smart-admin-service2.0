package net.lab1024.sa.admin.module.business.settlement.domain.vo;

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
public class PaymentVO {

    @ApiModelProperty(value = "id")
    private Long paymentId;

    @ApiModelProperty(value = "付款方式编码")
    private String paymentCode;

    @ApiModelProperty(value = "付款方式名称")
    private String paymentName;
}