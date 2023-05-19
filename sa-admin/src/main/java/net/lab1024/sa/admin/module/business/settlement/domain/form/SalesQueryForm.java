package net.lab1024.sa.admin.module.business.settlement.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.common.common.domain.PageParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;


/**
 * 结算主表 分页查询表单
 *
 * @Author pengch
 * @Date 2023-05-04 18:16:11
 * @Copyright v1.0
 */

@Data
public class SalesQueryForm extends PageParam{

    @ApiModelProperty(value = "代理商")
    @NotNull(message = "代理商不能为空")
    private String agentId;

    @ApiModelProperty(value = "开始日期")
    @NotBlank(message = "请选择开始日期")
    private String startDate;

    @ApiModelProperty(value = "结束日期")
    @NotBlank(message = "请选择结束日期")
    private String endDate;

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "仓库id")
    private Long depotId;

    @ApiModelProperty(value = "设备id")
    private Long quipmentId;

}