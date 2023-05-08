package net.lab1024.sa.admin.module.business.location.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * 位置信息 实体类
 *
 * @Author pengch
 * @Date 2023-05-06 12:04:10
 * @Copyright v1.0
 */

@Data
@TableName("t_location")
public class LocationEntity {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 编码
     */
    private String code;

    /**
     * 上级位置编码
     */
    private Long parentCode;

    /**
     * 位置名称
     */
    private String name;

    /**
     * 位置级别
     */
    private int Level;

    /**
     * 末级标记
     */
    private Integer endLevelFlag;

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
    private long ts01;

    private long new_ts01;
}