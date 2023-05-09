package net.lab1024.sa.admin.module.business.goods.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品 实体类
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021-10-25 20:26:54
 * @Wechat zhuoda1024
 * @Email lab1024@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ），2012-2022
 */
@Data
@TableName("t_goods")
public class GoodsEntity {

    @TableId(type = IdType.AUTO)
    private Long goodsId;

    /**
     *  商品状态:[1:预约中,2:售卖中,3:售罄]
     */
    private Integer goodsStatus;

    /**
     * 商品分类
     */
    private Long categoryId;

    /**
     * 商品品牌
     */
    private Long brandId;

    /**
     * 商品编码
     */
    private String goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 产地
     */
    private String place;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品供价
     */
    private BigDecimal supplyPrice;

    /**
     * 商品条件
     */
    private String barCode;


    /**
     * 上架状态
     */
    private Boolean shelvesFlag;

    /**
     * 删除状态
     */
    private Boolean deletedFlag;

    /**
     * 有效标记(0:有效,1:无效)
     */
    private Integer isDisabled;

    /**
     * 备注
     */
    private String remark;

    private Date updateTime;

    private Date createTime;

    private String cempName;

    private String uempName;

    private Long ts01;

}
