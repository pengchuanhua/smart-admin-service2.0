package net.lab1024.sa.admin.module.business.settlement.domain.form;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 结算主表 更新表单
 *
 * @Author pengch
 * @Date 2023-05-04 18:16:11
 * @Copyright v1.0
 */

@Data
public class SettlementUpdateForm {

    @ApiModelProperty(value = "结算单号", required = true)
    @NotNull(message = "结算单号 不能为空")
    private String settlementNo;

    @ApiModelProperty(value = "时间戳", required = true)
    @NotNull(message = "时间戳 不能为空")
    private Long ts01;

}