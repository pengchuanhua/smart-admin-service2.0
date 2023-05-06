package net.lab1024.sa.admin.module.business.brand.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * 品牌 实体类
 *
 * @Author pengch
 * @Date 2023-04-27 17:16:42
 * @Copyright v1.0
 */

@Data
@TableName("t_brand")
public class BrandEntity {

    private long id;

    /**
     * 品牌编码
     */
    private String code;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 有效标记
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
     * 描述
     */
    private String description;

    /**
     * 时间戳
     */
    private Long ts01;

    private long new_ts01;

}