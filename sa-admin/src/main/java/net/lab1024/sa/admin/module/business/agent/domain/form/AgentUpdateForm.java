package net.lab1024.sa.admin.module.business.agent.domain.form;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 代理商 更新表单
 *
 * @Author pengch
 * @Date 2023-04-27 17:11:22
 * @Copyright v1.0
 */

@Data
public class AgentUpdateForm {

    @ApiModelProperty(value = "主键ID", required = true)
    @NotNull(message = "主键ID 不能为空")
    private Long id;

    @ApiModelProperty(value = "代理商编码", required = true)
    @NotBlank(message = "代理商编码 不能为空")
    private String code;

    @ApiModelProperty(value = "代理商名称", required = true)
    @NotBlank(message = "代理商名称 不能为空")
    private String name;

    @ApiModelProperty(value = "代理商类型(0:医院、1:企业、2:个人)", required = true)
    @NotNull(message = "代理商类型(0:医院、1:企业、2:个人) 不能为空")
    private Integer type;

    @ApiModelProperty(value = "联系人", required = true)
    @NotBlank(message = "联系人 不能为空")
    private String contacts;

    @ApiModelProperty(value = "代理商电话", required = true)
    @NotBlank(message = "代理商电话 不能为空")
    private String phone;

    @ApiModelProperty(value = "开户银行", required = true)
    @NotBlank(message = "开户银行 不能为空")
    private String bank;

    @ApiModelProperty(value = "银行账号", required = true)
    @NotBlank(message = "银行账号 不能为空")
    private String accountNum;

    @ApiModelProperty(value = "有效标记(0:有效,1:无效)", required = true)
    @NotNull(message = "有效标记(0:有效,1:无效) 不能为空")
    private Integer isDisabled;

    @ApiModelProperty(value = "时间戳", required = true)
    private Long ts01;

}