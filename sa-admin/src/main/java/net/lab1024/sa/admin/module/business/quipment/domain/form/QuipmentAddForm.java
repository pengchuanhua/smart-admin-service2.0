package net.lab1024.sa.admin.module.business.quipment.domain.form;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 设备信息 新建表单
 *
 * @Author pengch
 * @Date 2023-04-28 18:56:09
 * @Copyright v1.0
 */

@Data
public class QuipmentAddForm {

    @ApiModelProperty(value = "设备编码", required = true)
    @NotBlank(message = "设备编码 不能为空")
    private String quipmentSn;

    @ApiModelProperty(value = "设备名称", required = true)
    @NotBlank(message = "设备名称 不能为空")
    private String quipmentName;

    @ApiModelProperty(value = "设备型号", required = true)
    @NotBlank(message = "设备型号 不能为空")
    private String quipmentModel;

    @ApiModelProperty(value = "设备详细地址", required = true)
    @NotBlank(message = "设备详细地址 不能为空")
    private String address;

    @ApiModelProperty(value = "设备区域code", required = true)
    @NotBlank(message = "设备区域code 不能为空")
    private String regionCode;

    @ApiModelProperty(value = "设备存放位置id")
    private Long locationId;

    @ApiModelProperty(value = "仓库id")
    private Long depotId;

    @ApiModelProperty(value = "代理商id")
    private Long agentId;

    @ApiModelProperty(value = "路线id")
    private Long pathId;

    @ApiModelProperty(value = "设备状态（0：停用，1：正常）", required = true)
    @NotNull(message = "设备状态（0：停用，1：正常） 不能为空")
    private Integer isDisabled;

    @ApiModelProperty(value = "最大库存量", required = true)
    @NotNull(message = "最大库存量 不能为空")
    private BigDecimal maxInventory;

    @ApiModelProperty(value = "分成比率", required = true)
    @NotNull(message = "分成比率 不能为空")
    private BigDecimal shareRatio;

    @ApiModelProperty(value = "投放时间")
    private LocalDateTime placementtime;

    @ApiModelProperty(value = "经度", required = true)
    @NotBlank(message = "经度 不能为空")
    private String longitude;

    @ApiModelProperty(value = "纬度", required = true)
    @NotBlank(message = "纬度 不能为空")
    private String latitude;

}