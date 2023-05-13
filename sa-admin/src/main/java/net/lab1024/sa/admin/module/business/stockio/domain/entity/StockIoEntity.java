package net.lab1024.sa.admin.module.business.stockio.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * 商品出入库 实体类
 *
 * @Author pengch
 * @Date 2023-04-28 18:27:48
 * @Copyright v1.0
 */

@Data
@TableName("t_stock_io")
public class StockIoEntity {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 组织id
     */
    private String orgId;

    /**
     * 出入库单号
     */

    private String stockNo;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 供应商id
     */
    private Long supplieId;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 类型(0:入库,1:出库)
     */
    private int type;

    /**
     * 数量
     */
    private int operNum;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 创建员工
     */
    private String cempName;

    /**
     * 更新时间
     */
    private Date utime;

    /**
     * 更新员工
     */
    private String uempName;

    /**
     * 描述
     */
    private String description;

    /**
     * 时间戳
     */
    private Long ts01;

}