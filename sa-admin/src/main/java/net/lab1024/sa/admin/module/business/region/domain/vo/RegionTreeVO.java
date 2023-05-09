package net.lab1024.sa.admin.module.business.region.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


 /**
 *  * 地区信息 列表树VO
 *  *
 *  * @Author pengch
 *  * @Date 2023-04-27 17:11:14
 *  * @Copyright v1.0
 *  */
 @Data
public class RegionTreeVO {

    @ApiModelProperty("地区code")
    private Long code;

    @ApiModelProperty("地区名称")
    private String name;

    @ApiModelProperty("地区全称")
    private String FullName;

    @ApiModelProperty("父级id")
    private Long parentCode;

    @ApiModelProperty("地区code")
    private Long value;

    @ApiModelProperty("地区名称")
    private String label;

     @ApiModelProperty("地区级别")
     private int Level;

     @ApiModelProperty("末级标记")
     private Integer endLevelFlag;

     @ApiModelProperty("有效标记")
     private Integer isDisabled;

     @ApiModelProperty("时间戳")
     private Long ts01;

    @ApiModelProperty("子类")
    private List<RegionTreeVO> children;
}
