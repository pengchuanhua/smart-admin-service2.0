package net.lab1024.sa.admin.module.business.depot.domain.form;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 仓库信息 更新表单
 *
 * @Author pengch
 * @Date 2023-04-27 17:13:39
 * @Copyright v1.0
 */

@Data
public class DepotUpdateForm {

    @ApiModelProperty(value = "id", required = true)
    @NotNull(message = "id 不能为空")
    private Long id;

    @ApiModelProperty(value = "仓库编码", required = true)
    @NotBlank(message = "仓库编码 不能为空")
    private String code;

    @ApiModelProperty(value = "仓库名称", required = true)
    @NotBlank(message = "仓库名称 不能为空")
    private String name;

    @ApiModelProperty(value = "仓库级别", required = true)
    @NotNull(message = "仓库级别 不能为空")
    private Integer Level;

    @ApiModelProperty(value = "末级标记", required = true)
    @NotNull(message = "末级标记 不能为空")
    private Integer endLevelFlag;

    @ApiModelProperty(value = "有效标记", required = true)
    @NotNull(message = "有效标记 不能为空")
    private Integer isDisabled;

}