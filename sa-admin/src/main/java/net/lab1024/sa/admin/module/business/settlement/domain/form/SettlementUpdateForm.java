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

    @ApiModelProperty(value = "主键ID", required = true)
    @NotNull(message = "主键ID 不能为空")
    private Long id;

}