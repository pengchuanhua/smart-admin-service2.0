package net.lab1024.sa.admin.module.business.settlement.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 结算主表 实体类
 *
 * @Author pengch
 * @Date 2023-05-04 18:16:11
 * @Copyright v1.0
 */

@Data
@TableName("t_settlement")
public class SettlementEntity {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 组织id
     */
    private String orgId;

    /**
     * 代理商id
     */
    private Long agentId;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 结算金额(分成金额)
     */
    private BigDecimal shareAmount;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 创建员
     */
    private String cempName;

    /**
     * 审核时间
     */
    private Date cktime;

    /**
     * 审核员
     */
    private String ckName;

    /**
     * 时间戳
     */
    private Long ts01;

    /**
     *结算明细
     */

    private List<SettlementitemEntity> settlementitemEntities;

}