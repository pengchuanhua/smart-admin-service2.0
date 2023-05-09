package net.lab1024.sa.admin.module.business.category.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.lab1024.sa.admin.module.business.category.constant.CategoryTypeEnum;

import java.util.Date;

/**
 * 类目 实体类
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021/08/05 21:26:58
 * @Wechat zhuoda1024
 * @Email lab1024@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ），2012-2022
 */
@Data
@TableName("t_category")
public class CategoryEntity {

    @TableId(type = IdType.AUTO)
    private Long categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目 类型
     *
     * @see CategoryTypeEnum
     */
//    private Integer categoryType;

    /**
     * 父级类目id
     */
    private Long parentId;

    /**
     * 是否禁用
     */
    private Boolean disabledFlag;

    /**
     * 排序
     */
//    private Integer sort;

    /**
     * 删除状态
     */
//    private Boolean deletedFlag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新员工
     */
    private String uempName;

    /**
     * 末级标记
     */
    private Integer endLevelFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建员工
     */
    private String cempName;

    /**
     * 级别
     */
    private int Level;

    private Long ts01;
}
