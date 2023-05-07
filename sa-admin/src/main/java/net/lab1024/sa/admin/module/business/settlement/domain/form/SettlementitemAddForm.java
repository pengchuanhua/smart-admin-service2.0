package net.lab1024.sa.admin.module.business.settlement.domain.form;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 结算明细表 新建表单
 *
 * @Author cs
 * @Date 2023-05-04 18:19:44
 * @Copyright cs
 */

@Data
public class SettlementitemAddForm {

    @ApiModelProperty(value = "组织ID", required = true)
    @NotBlank(message = "组织ID 不能为空")
    private String orgId;

    @ApiModelProperty(value = "结算单id", required = true)
    @NotNull(message = "结算单id 不能为空")
    private Long settlementId;

    @ApiModelProperty(value = "销售单id", required = true)
    @NotNull(message = "销售单id 不能为空")
    private Long salesId;

    @ApiModelProperty(value = "商品id", required = true)
    @NotNull(message = "商品id 不能为空")
    private Long goodsId;

    @ApiModelProperty(value = "结算金额(分成)", required = true)
    @NotNull(message = "结算金额(分成) 不能为空")
    private BigDecimal shareAmount;


}