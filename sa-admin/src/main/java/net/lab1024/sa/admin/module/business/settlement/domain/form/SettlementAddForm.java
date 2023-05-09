package net.lab1024.sa.admin.module.business.settlement.domain.form;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
/**
 * 结算主表 新建表单
 *
 * @Author pengch
 * @Date 2023-05-04 18:16:11
 * @Copyright v1.0
 */

@Data
public class SettlementAddForm {

    @ApiModelProperty(value = "主键ID", required = true)
    @NotNull(message = "主键ID 不能为空")
    private Long id;

    @ApiModelProperty(value = "组织id", required = true)
    @NotBlank(message = "组织id 不能为空")
    private String orgId;

    @ApiModelProperty(value = "开始日期", required = true)
    @NotNull(message = "开始日期 不能为空")
    private Date startDate;

    @ApiModelProperty(value = "结束日期", required = true)
    @NotNull(message = "结束日期 不能为空")
    private Date endDate;

    @ApiModelProperty(value = "创建时间", required = true)
    @NotNull(message = "创建时间 不能为空")
    private Date ctime;

    @ApiModelProperty(value = "创建员", required = true)
    @NotBlank(message = "创建员 不能为空")
    private String cempName;

    @ApiModelProperty(value = "审核时间", required = true)
    @NotNull(message = "审核时间 不能为空")
    private Date cktime;

    @ApiModelProperty(value = "审核员", required = true)
    @NotBlank(message = "审核员 不能为空")
    private String ckName;

    @ApiModelProperty(value = "时间戳", required = true)
    @NotNull(message = "时间戳 不能为空")
    private Long ts01;

    @ApiModelProperty(value = "结算明细", required = true)
    @NotNull(message = "结算明细 不能为空")
    private List<SettlementitemAddForm> settlementitemAddForms;

}