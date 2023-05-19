package net.lab1024.sa.admin.module.business.settlement.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 结算明细表 列表VO
 *
 * @Author cs
 * @Date 2023-05-04 18:19:44
 * @Copyright cs
 */

@Data
public class SettlementitemVO {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "组织ID")
    private String orgId;

    @ApiModelProperty(value = "结算单号")
    private String settlementNo;

    @ApiModelProperty(value = "销售单号")
    private String salesNo;

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "销售数量")
    private BigDecimal salesNum;

    @ApiModelProperty(value = "销售单价")
    private BigDecimal price;

    @ApiModelProperty(value = "销售金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "结算金额(分成)")
    private BigDecimal shareAmount;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "时间戳")
    private Long ts01;

}