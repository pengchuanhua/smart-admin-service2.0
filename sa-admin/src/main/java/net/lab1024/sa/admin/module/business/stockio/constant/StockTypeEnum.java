package net.lab1024.sa.admin.module.business.stockio.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.lab1024.sa.common.common.enumeration.BaseEnum;

/**
 * 出入库类型(0:入库,1:出库)
 *
 * @Author pengch
 * @Date 2023-05-09T17:39:58
 * @Copyright pengch
 */

@AllArgsConstructor
@Getter
public enum StockTypeEnum implements BaseEnum {
    /**
     * 1 出库
     */
    stock_out(1, "出库"),

    /**
     * 0 入库
     */
    stock_in(0, "入库"),
    ;

    private final Integer value;

    private final String desc;
}
