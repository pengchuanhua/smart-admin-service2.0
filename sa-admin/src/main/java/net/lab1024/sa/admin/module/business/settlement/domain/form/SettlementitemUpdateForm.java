package net.lab1024.sa.admin.module.business.settlement.domain.form;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 结算明细表 更新表单
 *
 * @Author cs
 * @Date 2023-05-04 18:19:44
 * @Copyright cs
 */

@Data
public class SettlementitemUpdateForm {

    @ApiModelProperty(value = "主键ID", required = true)
    @NotNull(message = "主键ID 不能为空")
    private Long id;

}