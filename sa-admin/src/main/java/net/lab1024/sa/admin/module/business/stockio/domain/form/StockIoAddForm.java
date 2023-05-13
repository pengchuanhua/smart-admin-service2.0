package net.lab1024.sa.admin.module.business.stockio.domain.form;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 商品出入库 新建表单
 *
 * @Author pengch
 * @Date 2023-04-28 18:27:48
 * @Copyright v1.0
 */

@Data
public class StockIoAddForm {

    @ApiModelProperty(value = "商品id", required = true)
    @NotNull(message = "商品id 不能为空")
    private Long goodsId;

    @ApiModelProperty(value = "供应商id", required = true)
    @NotNull(message = "供应商id 不能为空")
    private Long supplieId;

    @ApiModelProperty(value = "仓库id", required = true)
    @NotNull(message = "仓库id 不能为空")
    private Long depotId;

    @ApiModelProperty(value = "类型(0:入库,1:出库)", required = true)
    @NotNull(message = "类型(0:入库,1:出库) 不能为空")
    private int type;

    @ApiModelProperty(value = "数量", required = true)
    @NotNull(message = "数量 不能为空")
    private int operNum;

    @ApiModelProperty(value = "描述", required = true)
    private String description;

}