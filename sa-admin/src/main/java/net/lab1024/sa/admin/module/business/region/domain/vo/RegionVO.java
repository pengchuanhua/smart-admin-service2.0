package net.lab1024.sa.admin.module.business.region.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import lombok.Data;

/**
 * 地区信息 列表VO
 *
 * @Author pengch
 * @Date 2023-04-27 17:11:14
 * @Copyright v1.0
 */

@Data
public class RegionVO {


    @ApiModelProperty(value = "地区编码")
    private Long code;

    @ApiModelProperty(value = "上级地区编码")
    private Long parentCode;

    @ApiModelProperty(value = "地区名称")
    private String name;

    @ApiModelProperty(value = "地区级别")
    private int regionLevel;

    @ApiModelProperty(value = "末级标记")
    private Integer endLevelFlag;

    @ApiModelProperty(value = "地区全称")
    private String fullName;

    @ApiModelProperty(value = "有效标记(0:有效,1:无效)")
    private Integer isDisabled;

    @ApiModelProperty(value = "创建时间")
    private Date ctime;

    @ApiModelProperty(value = "创建员工")
    private String cempName;

    @ApiModelProperty(value = "更新时间")
    private Date utime;

    @ApiModelProperty(value = "更新员工")
    private String uempName;

}