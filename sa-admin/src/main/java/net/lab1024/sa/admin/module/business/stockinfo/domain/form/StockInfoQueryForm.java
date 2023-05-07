package net.lab1024.sa.admin.module.business.stockinfo.domain.form;

import net.lab1024.sa.common.common.domain.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商品库存 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-28 18:42:05
 * @Copyright v1.0
 */

@Data
public class StockInfoQueryForm extends PageParam{

    @ApiModelProperty(value = "商品编码/名称")
    private String goodsId;

    @ApiModelProperty(value = "仓库编码/名称")
    private String depotId;

}