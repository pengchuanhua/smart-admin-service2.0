package net.lab1024.sa.admin.module.business.location.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
*  *  列表树VO
*  *
*  * @Author pengch
*  * @Date 2023-04-27 17:11:14
*  * @Copyright v1.0
*  */
@Data
public class LocationTreeVO {

   @ApiModelProperty("类目id")
   private Long code;

   @ApiModelProperty("类目名称")
   private String name;

   @ApiModelProperty("类目层级全称")
   private String FullName;

   @ApiModelProperty("父级id")
   private Long parentCode;

   @ApiModelProperty("类目id")
   private Long value;

   @ApiModelProperty("类目名称")
   private String label;

   @ApiModelProperty("子类")
   private List<LocationTreeVO> children;
}
