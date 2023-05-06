package net.lab1024.sa.admin.module.business.supplie.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * 供应商 实体类
 *
 * @Author pengch
 * @Date 2023-04-27 17:15:30
 * @Copyright v1.0
 */

@Data
@TableName("t_supplie")
public class SupplieEntity {

    private long id;

    /**
     * 组织ID
     */
    private String orgId;

    /**
     * 供应商编码
     */
    private String code;

    /**
     * 供应商名称
     */
    private String name;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系人电话
     */
    private String phone;

    /**
     * 开户银行
     */
    private String bank;

    /**
     * 银行账号
     */
    private String accountNum;

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
     * 有效标记(0:有效,1:无效)
     */
    private Integer isDisabled;

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