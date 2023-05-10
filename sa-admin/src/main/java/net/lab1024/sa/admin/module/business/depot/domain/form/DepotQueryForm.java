package net.lab1024.sa.admin.module.business.depot.domain.form;

import net.lab1024.sa.common.common.domain.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.admin.module.business.depot.constant.DepotStatusEnum;
import net.lab1024.sa.common.common.swagger.ApiModelPropertyEnum;
import net.lab1024.sa.common.common.validator.enumeration.CheckEnum;

/**
 * 仓库信息 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-27 17:13:39
 * @Copyright v1.0
 */

@Data
public class DepotQueryForm extends PageParam{

    @ApiModelProperty(value = "仓库编码/名称")
    private String code;

    @ApiModelProperty(value = "仓库编码/名称")
    private String name;

    @ApiModelPropertyEnum(value = DepotStatusEnum.class, desc = "有效标记")
    @CheckEnum(value = DepotStatusEnum.class, message = "有效标记 错误")
    private Integer isDisabled;

}