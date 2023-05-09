package net.lab1024.sa.admin.module.business.region.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import lombok.Data;

/**
 * 地区信息 实体类
 *
 * @Author pengch
 * @Date 2023-04-27 17:11:14
 * @Copyright v1.0
 */

@Data
@TableName("t_region")
public class RegionEntity {

    /**
     * 地区编码
     */
    private Long code;

    /**
     * 上级地区编码
     */
    private Long parentCode;

    /**
     * 地区名称
     */
    private String name;

    /**
     * 地区级别
     */
    private int regionLevel;

    /**
     * 末级标记
     */
    private Integer endLevelFlag;

    /**
     * 地区全称
     */
    private String fullName;

    /**
     * 有效标记(0:有效,1:无效)
     */
    private Integer isDisabled;

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
     * 时间戳
     */
    private Long ts01;

    private Long new_ts01;

}