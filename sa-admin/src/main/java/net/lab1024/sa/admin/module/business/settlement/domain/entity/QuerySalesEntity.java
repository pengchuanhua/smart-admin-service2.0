package net.lab1024.sa.admin.module.business.settlement.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 设备销售表 实体类
 *
 * @Author pengch
 * @Date 2023-04-29 19:56:46
 * @Copyright v1.0
 */

@Data
@TableName("t_sales")
public class QuerySalesEntity {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 组织id
     */
    private String orgId;

    /**
     * 设备ID
     */
    private Long quipmentId;

    /**
     * 设备格子编号
     */
    private Integer quipmentLatt;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 数量
     */
    private BigDecimal salesNum;

    /**
     * 销售单价
     */
    private BigDecimal price;

    /**
     * 销售金额
     */
    private BigDecimal amount;

    /**
     * 退款标记
     */
    private Integer refundFlag;

    /**
     * 原销售ID
     */
    private Long oldSalesId;

    /**
     * 代理商id
     */
    private Long agentId;

    /**
     * 分成比率
     */
    private BigDecimal shareRatio;

    /**
     * 分成金额
     */
    private BigDecimal shareAmount;

    /**
     * 结算单id
     */
    private Long settlementId;

    /**
     * 结算标记
     */
    private Integer settlementFlag;

    /**
     * 创建时间
     */
    private LocalDateTime ctime;

    /**
     * 收款时间
     */
    private LocalDateTime rptime;

    /**
     * 收款员工
     */
    private String rpempName;

    /**
     * 描述
     */
    private String description;

    /**
     * 支付类型(0:支付宝,1:微信)
     */
    private String paymentType;

    /**
     * 支付网官号
     */
    private String paymentNo;

    /**
     * 时间戳
     */
    private Long ts01;

}