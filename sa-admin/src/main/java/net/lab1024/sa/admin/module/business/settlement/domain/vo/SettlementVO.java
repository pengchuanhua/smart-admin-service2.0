package net.lab1024.sa.admin.module.business.settlement.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import lombok.Data;
import net.lab1024.sa.admin.module.business.settlement.domain.form.SettlementitemAddForm;

import javax.validation.constraints.NotNull;

/**
 * 结算主表 列表VO
 *
 * @Author pengch
 * @Date 2023-05-04 18:16:11
 * @Copyright v1.0
 */

@Data
public class SettlementVO {


    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "组织id")
    private String orgId;

    @ApiModelProperty(value = "代理商id")
    private Long agentId;

    @ApiModelProperty(value = "开始日期")
    private Date startDate;

    @ApiModelProperty(value = "结束日期")
    private Date endDate;

    @ApiModelProperty(value = "结算金额(分成金额)")
    private BigDecimal shareAmount;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime ctime;

    @ApiModelProperty(value = "创建员")
    private String cempName;

    @ApiModelProperty(value = "审核时间")
    private LocalDateTime cktime;

    @ApiModelProperty(value = "审核员")
    private String ckName;

    @ApiModelProperty(value = "时间戳")
    private Long ts01;

    @ApiModelProperty(value = "结算明细", required = true)
    private List<SettlementitemVO> settlementitemVO;

}