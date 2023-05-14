package net.lab1024.sa.admin.module.business.sales.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 设备销售表 列表VO
 *
 * @Author pengch
 * @Date 2023-04-29 19:56:46
 * @Copyright v1.0
 */

@Data
public class SalesQueryVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "销售单号")
    private String salesNo;

    @ApiModelProperty(value = "组织id")
    private String orgId;

    @ApiModelProperty(value = "设备ID")
    private Long quipmentId;

    @ApiModelProperty(value = "设备编码")
    private String quipmentSn;

    @ApiModelProperty(value = "设备名称")
    private String quipmentName;

    @ApiModelProperty(value = "设备格子编号")
    private Integer quipmentLatt;

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "商品编码")
    private Long goodsCode;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "仓库编码")
    private Long depotCode;

    @ApiModelProperty(value = "仓库名称")
    private String depotName;

    @ApiModelProperty(value = "数量")
    private int salesNum;

    @ApiModelProperty(value = "销售单价")
    private BigDecimal price;

    @ApiModelProperty(value = "销售金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "退款标记")
    private Integer refundFlag;

    @ApiModelProperty(value = "代理商id")
    private Long agentId;

    @ApiModelProperty(value = "代理商编码")
    private Long agentCode;

    @ApiModelProperty(value = "代理商名称")
    private String agentName;

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

    @ApiModelProperty(value = "创建人")
    private String cName;

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