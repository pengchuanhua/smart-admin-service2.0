package net.lab1024.sa.admin.module.business.settlement.domain.form;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
/**
 * 结算主表 新建表单
 *
 * @Author pengch
 * @Date 2023-05-04 18:16:11
 * @Copyright v1.0
 */

@Data
public class SettlementAddForm {

    @ApiModelProperty(value = "结算单号", required = true)
    private String settlementNo;

    @ApiModelProperty(value = "代理商", required = true)
    @NotNull(message = "代理商不能为空")
    private String agentId;

    @ApiModelProperty(value = "开始日期", required = true)
    @NotNull(message = "开始日期 不能为空")
    private Date startDate;

    @ApiModelProperty(value = "结束日期", required = true)
    @NotNull(message = "结束日期 不能为空")
    private Date endDate;

    @ApiModelProperty(value = "结算金额", required = true)
    @NotNull(message = "结算金额 不能为空")
    private BigDecimal shareAmount;

    @ApiModelProperty(value = "备注", required = true)
    private String description;

    @ApiModelProperty(value = "付款方式", required = true)
    @NotNull(message = "付款方式 不能为空")
    private int paymentId;

    @ApiModelProperty(value = "结算明细", required = true)
    @NotNull(message = "结算明细 不能为空")
    private List<SettlementitemAddForm> settlementitemAddForms;

}