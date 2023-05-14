package net.lab1024.sa.admin.module.business.stockinfo.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 商品库存 列表VO
 *
 * @Author pengch
 * @Date 2023-04-28 18:42:05
 * @Copyright v1.0
 */

@Data
public class StockInfoVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "组织id")
    private String orgId;

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "商品id")
    private Long goodsCode;

    @ApiModelProperty(value = "商品id")
    private String goodsName;

    @ApiModelProperty(value = "仓库id")
    private Long depotCode;

    @ApiModelProperty(value = "仓库id")
    private String depotName;

    @ApiModelProperty(value = "数量")
    private int stockNum;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime ctime;

    @ApiModelProperty(value = "创建员工")
    private String cempName;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime utime;

    @ApiModelProperty(value = "更新员工")
    private String uempName;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "时间戳")
    private Long ts01;

}