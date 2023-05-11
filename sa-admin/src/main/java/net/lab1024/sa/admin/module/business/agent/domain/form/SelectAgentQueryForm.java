package net.lab1024.sa.admin.module.business.agent.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.admin.module.business.agent.constant.AgentStatusEnum;
import net.lab1024.sa.common.common.domain.PageParam;
import net.lab1024.sa.common.common.swagger.ApiModelPropertyEnum;
import net.lab1024.sa.common.common.validator.enumeration.CheckEnum;

/**
 * 代理商 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-27 17:11:22
 * @Copyright v1.0
 */

@Data
public class SelectAgentQueryForm{

    @ApiModelProperty(value = "代理商")
    private String code;

    @ApiModelProperty(value = "代理商名称")
    private String name;

    @ApiModelProperty(value = "联系人")
    private String contacts;

    @ApiModelPropertyEnum(value = AgentStatusEnum.class, desc = "有效标记(0:有效,1:无效)")
    @CheckEnum(value = AgentStatusEnum.class, message = "有效标记(0:有效,1:无效) 错误")
    private Integer isDisabled;

}