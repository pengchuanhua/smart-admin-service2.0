package net.lab1024.sa.admin.module.business.depot.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 仓库信息 实体类
 *
 * @Author pengch
 * @Date 2023-04-27 17:13:39
 * @Copyright v1.0
 */

@Data
@TableName("t_depot")
public class DepotEntity {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 组织ID(部门前两位)
     */
    private String orgId;

    /**
     * 仓库编码
     */
    private String code;

    /**
     * 仓库名称
     */
    private String name;

    /**
     * 上级地区id
     */
    private Long parentId;

    /**
     * 仓库级别
     */
    private Integer Level;

    /**
     * 末级标记
     */
    private Integer endLevelFlag;

    /**
     * 有效标记
     */
    private Integer isDisabled;

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
     * 时间戳
     */
    private String ts01;

}