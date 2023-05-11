package net.lab1024.sa.admin.module.system.role.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.common.common.domain.PageParam;

import javax.validation.constraints.NotNull;

/**
 * 商品库存 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-28 18:42:05
 * @Copyright v1.0
 */

@Data
public class QueryUserRolseForm{

    @ApiModelProperty(value = "人员编码")
    @NotNull(message = "人员编码不能为空")
    private Long employeeId;


}