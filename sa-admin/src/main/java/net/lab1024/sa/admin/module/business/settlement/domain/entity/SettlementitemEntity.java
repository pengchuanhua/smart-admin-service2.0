package net.lab1024.sa.admin.module.business.settlement.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 结算明细表 实体类
 *
 * @Author cs
 * @Date 2023-05-04 18:19:44
 * @Copyright cs
 */

@Data
@TableName("t_settlementitem")
public class SettlementitemEntity {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 组织ID
     */
    private String orgId;

    /**
     * 结算单id
     */
    private Long settlementId;

    /**
     * 销售单id
     */
    private Long salesId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 销售数量
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
     * 结算金额(分成)
     */
    private BigDecimal shareAmount;

    /**
     * 描述
     */
    private String description;

    /**
     * 时间戳
     */
    private Long ts01;

}