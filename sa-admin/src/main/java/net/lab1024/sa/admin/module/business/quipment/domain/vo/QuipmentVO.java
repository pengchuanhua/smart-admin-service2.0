package net.lab1024.sa.admin.module.business.quipment.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 设备信息 列表VO
 *
 * @Author pengch
 * @Date 2023-04-28 18:56:09
 * @Copyright v1.0
 */

@Data
public class QuipmentVO {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "quipmentId")
    private Long quipmentId;

    @ApiModelProperty(value = "设备编码")
    private String quipmentSn;

    @ApiModelProperty(value = "设备名称")
    private String quipmentName;

    @ApiModelProperty(value = "设备型号")
    private String quipmentModel;

    @ApiModelProperty(value = "设备详细地址")
    private String address;

    @ApiModelProperty(value = "设备区域code")
    private String regionCode;

    @ApiModelProperty(value = "设备存放位置id")
    private Long locationId;

    @ApiModelProperty(value = "部门id")
    private String departmentId;

    @ApiModelProperty(value = "仓库id")
    private Long depotId;

    @ApiModelProperty(value = "代理商id")
    private Long agentId;

    @ApiModelProperty(value = "路线id")
    private Long pathId;

    @ApiModelProperty(value = "设备状态（0：停用，1：正常）")
    private Integer isDisabled;

    @ApiModelProperty(value = "最大库存量")
    private BigDecimal maxInventory;

    @ApiModelProperty(value = "分成比率")
    private BigDecimal shareRatio;

    @ApiModelProperty(value = "投放时间")
    private Date placementtime;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "创建人")
    private String createUser;

    @ApiModelProperty(value = "修改人")
    private String updateUser;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "时间戳")
    private Long ts01;

}