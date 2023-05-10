package net.lab1024.sa.admin.module.business.goods.domain.form;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.admin.module.business.goods.constant.GoodsStatusEnum;
import net.lab1024.sa.common.common.json.deserializer.DictValueVoDeserializer;
import net.lab1024.sa.common.common.swagger.ApiModelPropertyEnum;
import net.lab1024.sa.common.common.validator.enumeration.CheckEnum;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 商品 更新表单
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021-10-25 20:26:54
 * @Wechat zhuoda1024
 * @Email lab1024@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ），2012-2022
 */
@Data
public class GoodsUpdateForm extends GoodsAddForm{

    @ApiModelProperty("商品id")
    @NotNull(message = "商品id不能为空")
    private Long goodsId;

//    @ApiModelProperty("商品分类")
//    @NotNull(message = "商品分类不能为空")
//    private Long categoryId;
//
//    @ApiModelProperty("商品品牌")
//    private Long brandId;
//
//    @ApiModelProperty("商品编码")
//    @NotBlank(message = "商品编码不能为空")
//    private String goodsCode;
//
//    @ApiModelProperty("商品名称")
//    @NotBlank(message = "商品名称不能为空")
//    private String goodsName;
//
//    @ApiModelPropertyEnum(GoodsStatusEnum.class)
//    @CheckEnum(message = "商品状态错误", value = GoodsStatusEnum.class, required = true)
//    private Integer goodsStatus;
//
//    @ApiModelProperty("产地")
//    @NotBlank(message = "产地 不能为空 ")
//    @JsonDeserialize(using = DictValueVoDeserializer.class)
//    private String place;
//
//    @ApiModelProperty("商品价格")
//    @NotNull(message = "商品价格不能为空")
//    @DecimalMin(value = "0", message = "商品价格最低0")
//    private BigDecimal price;
//
//    @ApiModelProperty("商品供价")
//    @NotNull(message = "商品供价不能为空")
//    @DecimalMin(value = "0", message = "商品供价最低0")
//    private BigDecimal supplyPrice;
//
//    @ApiModelProperty("上架状态")
//    @NotNull(message = "上架状态不能为空")
//    private Boolean shelvesFlag;
//
//    @ApiModelProperty("备注|可选")
//    private String remark;
//
//    @ApiModelProperty("图片")
//    private String imageUrl;
//
//    @ApiModelProperty("商品条码")
//    private String bar_code;
//
//    @ApiModelProperty("有效标记")
//    @NotNull(message = "有效标记不能为空")
//    private Integer isDisabled;






}
