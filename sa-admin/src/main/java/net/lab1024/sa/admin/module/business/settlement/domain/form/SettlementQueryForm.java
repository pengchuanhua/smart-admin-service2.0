package net.lab1024.sa.admin.module.business.settlement.domain.form;

import net.lab1024.sa.common.common.domain.PageParam;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import lombok.Data;

/**
 * 结算主表 分页查询表单
 *
 * @Author pengch
 * @Date 2023-05-04 18:16:11
 * @Copyright v1.0
 */

@Data
public class SettlementQueryForm extends PageParam{

    @ApiModelProperty(value = "代理商")
    private String agentId;

    @ApiModelProperty(value = "开始日期")
    private LocalDate startDateBegin;

    @ApiModelProperty(value = "结束日期")
    private LocalDate endDateEnd;

}