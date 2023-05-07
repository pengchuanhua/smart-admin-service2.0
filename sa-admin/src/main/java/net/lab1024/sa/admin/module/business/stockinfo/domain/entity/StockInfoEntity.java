package net.lab1024.sa.admin.module.business.stockinfo.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 商品库存 实体类
 *
 * @Author pengch
 * @Date 2023-04-28 18:42:05
 * @Copyright v1.0
 */

@Data
@TableName("t_stock_info")
public class StockInfoEntity {

    /**
     * 主键ID
     */
    @TableId
    private Long id;

    /**
     * 组织id
     */
    private String orgId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 数量
     */
    private BigDecimal stockNum;

    /**
     * 创建时间
     */
    private LocalDateTime ctime;

    /**
     * 创建员工
     */
    private String cempName;

    /**
     * 更新时间
     */
    private LocalDateTime utime;

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