package net.lab1024.sa.admin.module.business.depot.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import lombok.Data;

/**
 * 仓库信息 列表VO
 *
 * @Author pengch
 * @Date 2023-04-27 17:13:39
 * @Copyright v1.0
 */

@Data
public class DepotVO {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "depotId")
    private Long depotId;

    @ApiModelProperty(value = "组织ID(部门前两位)")
    private String orgId;

    @ApiModelProperty(value = "仓库编码")
    private String code;

    @ApiModelProperty(value = "仓库名称")
    private String name;

    @ApiModelProperty(value = "三级地址id")
    private Long regionCode;

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

    @ApiModelProperty(value = "时间戳")
    private String ts01;

}