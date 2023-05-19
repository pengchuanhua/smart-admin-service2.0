package net.lab1024.sa.admin.module.business.settlement.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.common.common.domain.PageParam;


/**
 * 结算主表 分页查询表单
 *
 * @Author pengch
 * @Date 2023-05-04 18:16:11
 * @Copyright v1.0
 */

@Data
public class SettlementitemQueryForm{

    @ApiModelProperty(value = "结算单号")
    private String settlementNo;

    @ApiModelProperty(value = "销售单号")
    private String salesNo;

}