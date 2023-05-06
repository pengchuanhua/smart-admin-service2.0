package net.lab1024.sa.admin.module.business.location.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 位置信息 列表VO
 *
 * @Author pengch
 * @Date 2023-05-06 12:04:10
 * @Copyright v1.0
 */

@Data
public class LocationVO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "上级位置编码")
    private String parentCode;

    @ApiModelProperty(value = "位置名称")
    private String name;

    @ApiModelProperty(value = "位置级别")
    private Integer Level;

    @ApiModelProperty(value = "末级标记")
    private Integer endLevelFlag;

    @ApiModelProperty(value = "有效标记(0:有效,1:无效)")
    private Integer isDisabled;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime ctime;

    @ApiModelProperty(value = "创建员工")
    private String cempName;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime utime;

    @ApiModelProperty(value = "更新员工")
    private String uempName;

    @ApiModelProperty(value = "时间戳")
    private String ts01;

}