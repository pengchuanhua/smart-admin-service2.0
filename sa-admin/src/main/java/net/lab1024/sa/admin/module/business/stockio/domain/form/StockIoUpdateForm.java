package net.lab1024.sa.admin.module.business.stockio.domain.form;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 商品出入库 更新表单
 *
 * @Author pengch
 * @Date 2023-04-28 18:27:48
 * @Copyright v1.0
 */

@Data
public class StockIoUpdateForm {

    @ApiModelProperty(value = "主键ID", required = true)
    @NotNull(message = "主键ID 不能为空")
    private Long id;

}