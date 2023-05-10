package net.lab1024.sa.admin.module.business.category.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.admin.module.business.category.constant.CategoryTypeEnum;
import net.lab1024.sa.common.common.swagger.ApiModelPropertyEnum;
import net.lab1024.sa.common.common.validator.enumeration.CheckEnum;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 类目 更新
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021/08/05 21:26:58
 * @Wechat zhuoda1024
 * @Email lab1024@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ），2012-2022
 */
@Data
public class CategoryUpdateForm {

    @ApiModelProperty("类目id")
    @NotNull(message = "类目id不能为空")
    private Long categoryId;

    @ApiModelProperty(value = "类目名称", required = true)
    @NotBlank(message = "类目名称不能为空")
    @Length(max = 20, message = "类目名称最多20字符")
    private String categoryName;

    @ApiModelPropertyEnum(desc = "分类类型", value = CategoryTypeEnum.class)
    @CheckEnum(value = CategoryTypeEnum.class, required = true, message = "分类错误")
    private Integer categoryType;

    @ApiModelProperty(value ="备注|可选", required = true)
    @Length(max = 200, message = "备注最多200字符")
    private String remark;

    @ApiModelProperty(value = "有效标记", required = true)
    @NotNull(message = "有效标记不能为空")
    private Integer disabledFlag;

    @ApiModelProperty(value = "末级标记", required = true)
    @NotNull(message = "末级标记 不能为空")
    private Integer endLevelFlag;

    @ApiModelProperty(value = "级别", required = true)
    @NotNull(message = "级别 不能为空")
    private Integer categoryLevel;
}
