package net.lab1024.sa.admin.module.business.brand.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import lombok.Data;

/**
 * 品牌 列表VO
 *
 * @Author pengch
 * @Date 2023-04-27 17:16:42
 * @Copyright v1.0
 */

@Data
public class BrandVO {
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "品牌编码")
    private String code;

    @ApiModelProperty(value = "品牌名称")
    private String name;

    @ApiModelProperty(value = "有效标记")
    private Integer isDisabled;

    @ApiModelProperty(value = "创建时间")
    private Date ctime;

    @ApiModelProperty(value = "创建员工")
    private String cempName;

    @ApiModelProperty(value = "更新时间")
    private Date utime;

    @ApiModelProperty(value = "更新员工")
    private String uempName;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "时间戳")
    private Long ts01;

}