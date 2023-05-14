package net.lab1024.sa.admin.module.business.sales.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.common.common.domain.PageParam;

import java.time.LocalDate;

/**
 * 设备销售表 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-29 19:56:46
 * @Copyright v1.0
 */

@Data
public class SalesQueryGoodsForm extends PageParam{

    @ApiModelProperty(value = "商品编码/名称")
    private Long goodId;
    @ApiModelProperty(value = "收款时间")
    private LocalDate rptimeBegin;

    @ApiModelProperty(value = "收款时间")
    private LocalDate rptimeEnd;

}