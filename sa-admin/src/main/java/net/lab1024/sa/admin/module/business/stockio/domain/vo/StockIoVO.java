package net.lab1024.sa.admin.module.business.stockio.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * 商品出入库 列表VO
 *
 * @Author pengch
 * @Date 2023-04-28 18:27:48
 * @Copyright v1.0
 */

@Data
public class StockIoVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "出入库单号")
    private String stockNo;

    @ApiModelProperty(value = "组织id")
    private String orgId;

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "供应商id")
    private Long supplieId;

    @ApiModelProperty(value = "仓库id")
    private Long depotId;

    @ApiModelProperty(value = "类型(0:入库,1:出库)")
    private int type;

    @ApiModelProperty(value = "数量")
    private int operNum;

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