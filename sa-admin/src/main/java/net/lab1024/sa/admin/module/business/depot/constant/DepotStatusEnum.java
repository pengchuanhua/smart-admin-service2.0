package net.lab1024.sa.admin.module.business.depot.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.lab1024.sa.common.common.enumeration.BaseEnum;

/**
 * 有效标记(0:有效,1:无效)
 *
 * @Author pengch
 * @Date 2023-04-27T17:39:58
 * @Copyright pengch
 */

@AllArgsConstructor
@Getter
public enum DepotStatusEnum implements BaseEnum {
    /**
     * 1 无效
     */
    FAILURE(1, "无效"),

    /**
     * 0 有效
     */
    EFFECTIVE(0, "有效"),
    ;

    private final Integer value;

    private final String desc;
}
