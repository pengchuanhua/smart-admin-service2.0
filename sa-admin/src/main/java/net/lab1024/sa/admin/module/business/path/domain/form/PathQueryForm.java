package net.lab1024.sa.admin.module.business.path.domain.form;

import net.lab1024.sa.admin.module.business.path.constant.PathStatusEnum;
import net.lab1024.sa.admin.module.business.quipment.constant.QuipmentStatusEnum;
import net.lab1024.sa.common.common.domain.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.common.common.swagger.ApiModelPropertyEnum;
import net.lab1024.sa.common.common.validator.enumeration.CheckEnum;

/**
 * 设备路线 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-27 17:39:58
 * @Copyright pengch
 */

@Data
public class PathQueryForm extends PageParam{

    @ApiModelProperty(value = "路线编码/名称")
    private String code;

    @ApiModelProperty(value = "路线编码/名称")
    private String name;

    @ApiModelProperty(value = "负责人")
    private String chargePerson;

    @ApiModelPropertyEnum(value = PathStatusEnum.class, desc = "有效标记（0：有效，1：无效）")
    @CheckEnum(value = PathStatusEnum.class, message = "有效标记（0：有效，1：无效） 错误")
    private Integer isDisabled;
}