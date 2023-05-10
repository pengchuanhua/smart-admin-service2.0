package net.lab1024.sa.admin.module.business.quipment.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 设备信息 实体类
 *
 * @Author pengch
 * @Date 2023-04-28 18:56:09
 * @Copyright v1.0
 */

@Data
public class UpdateQuipmentEntity {

    private Long id;

    private Long quipment_id;

    /**
     * 设备编码
     */

    private String quipmentSn;

    /**
     * 设备名称
     */

    private String quipmentName;

    /**
     * 设备型号
     */

    private String quipmentModel;

    /**
     * 设备详细地址
     */

    private String address;

    /**
     * 设备区域code
     */

    private String regionCode;

    /**
     * 设备存放位置id
     */

    private Long locationId;

    /**
     * 部门id
     */

    private String departmentId;

    /**
     * 仓库id
     */

    private Long depotId;

    /**
     * 代理商id
     */

    private Long agentId;

    /**
     * 路线id
     */

    private Long pathId;

    /**
     * 设备状态（0：停用，1：正常）
     */
    private Integer isDisabled;

    /**
     * 最大库存量
     */

    private BigDecimal maxInventory;

    /**
     * 分成比率
     */

    private BigDecimal shareRatio;

    /**
     * 投放时间
     */
    private Date placementtime;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 时间戳
     */
    private Long ts01;

    private long new_ts01;

}