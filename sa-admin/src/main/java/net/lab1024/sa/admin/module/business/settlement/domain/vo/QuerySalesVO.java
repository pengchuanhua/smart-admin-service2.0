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
public class QuerySalesVO {


    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "组织id")
    private String orgId;

    @ApiModelProperty(value = "设备ID")
    private Long quipmentId;

    @ApiModelProperty(value = "设备格子编号")
    private Integer quipmentLatt;

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "仓库id")
    private Long depotId;

    @ApiModelProperty(value = "数量")
    private BigDecimal salesNum;

    @ApiModelProperty(value = "销售单价")
    private BigDecimal price;

    @ApiModelProperty(value = "销售金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "退款标记")
    private Integer refundFlag;

    @ApiModelProperty(value = "原销售ID")
    private Long oldSalesId;

    @ApiModelProperty(value = "代理商id")
    private Long agentId;

    @ApiModelProperty(value = "分成比率")
    private BigDecimal shareRatio;

    @ApiModelProperty(value = "分成金额")
    private BigDecimal shareAmount;

    @ApiModelProperty(value = "结算单id")
    private Long settlementId;

    @ApiModelProperty(value = "结算标记")
    private Integer settlementFlag;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime ctime;

    @ApiModelProperty(value = "收款时间")
    private LocalDateTime rptime;

    @ApiModelProperty(value = "收款员工")
    private String rpempName;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "支付类型(0:支付宝,1:微信)")
    private String paymentType;

    @ApiModelProperty(value = "支付网官号")
    private String paymentNo;

    @ApiModelProperty(value = "时间戳")
    private Long ts01;

}