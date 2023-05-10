package net.lab1024.sa.admin.module.business.category.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 类目 层级树 vo
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021/08/05 21:26:58
 * @Wechat zhuoda1024
 * @Email lab1024@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ），2012-2022
 */
@Data
public class CategoryTreeVO {

    @ApiModelProperty("类目id")
    private Long categoryId;

    @ApiModelProperty("类目名称")
    private String categoryName;

    @ApiModelProperty("类目类型")
    private Integer categoryType;

    @ApiModelProperty("父级id")
    private Long parentId;

    @ApiModelProperty("类目id")
    private Long value;

    @ApiModelProperty("类目名称")
    private String label;

    @ApiModelProperty("级别")
    private Integer categoryLevel;

    @ApiModelProperty("末级标记")
    private Integer endLevelFlag;

    @ApiModelProperty("有效标记")
    private Integer disabledFlag;

    @ApiModelProperty("时间戳")
    private Long ts01;

    @ApiModelProperty("子类")
    private List<CategoryTreeVO> children;
}
