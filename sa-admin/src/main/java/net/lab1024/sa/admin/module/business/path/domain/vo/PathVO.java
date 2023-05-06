package net.lab1024.sa.admin.module.business.path.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * 设备路线 列表VO
 *
 * @Author pengch
 * @Date 2023-04-27 17:39:58
 * @Copyright pengch
 */

@Data
public class PathVO {

    @ApiModelProperty(value = "id")
    private long id;

    @ApiModelProperty(value = "路线编码")
    private String code;

    @ApiModelProperty(value = "路线名称")
    private String name;

    @ApiModelProperty(value = "状态")
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
    private String ts01;

}