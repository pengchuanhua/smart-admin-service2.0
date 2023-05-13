package net.lab1024.sa.admin.module.business.stockio.domain.form;

import net.lab1024.sa.common.common.domain.PageParam;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import lombok.Data;
import net.lab1024.sa.admin.module.business.stockio.constant.StockTypeEnum;
import net.lab1024.sa.common.common.swagger.ApiModelPropertyEnum;
import net.lab1024.sa.common.common.validator.enumeration.CheckEnum;

/**
 * 商品出入库 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-28 18:27:48
 * @Copyright v1.0
 */

@Data
public class StockIoQueryForm extends PageParam{


    /**
     * 出入库单号
     */
    @ApiModelProperty(value = "出入库单号")
    private String stockNo;

    @ApiModelProperty(value = "商品信息")
    private String goods;

    @ApiModelProperty(value = "供应商")
    private String supplie;

    @ApiModelProperty(value = "仓库信息")
    private String depot;

    @ApiModelPropertyEnum(value = StockTypeEnum.class, desc = "类型(0:入库,1:出库)")
    @CheckEnum(value = StockTypeEnum.class, message = "类型(0:入库,1:出库) 错误")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    private LocalDate ctimeBegin;

    @ApiModelProperty(value = "创建时间")
    private LocalDate ctimeEnd;

}