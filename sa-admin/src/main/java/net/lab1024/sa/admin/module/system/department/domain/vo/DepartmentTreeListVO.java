package net.lab1024.sa.admin.module.system.department.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.admin.module.business.location.domain.vo.LocationTreeVO;

import java.util.List;

/**
 * 部门
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-01-12 20:37:48
 * @Wechat zhuoda1024
 * @Email lab1024@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Data
public class DepartmentTreeListVO{

    @ApiModelProperty("部门id")
    private Long departmentId;

    @ApiModelProperty("部门code")
    private String code;

    @ApiModelProperty("部门名称")
    private String name;


    @ApiModelProperty("父级id")
    private Long parentId;

    @ApiModelProperty("部门id")
    private Long value;

    @ApiModelProperty("部门名称")
    private String label;

    @ApiModelProperty("部门级别")
    private int deptLevel;

    @ApiModelProperty("末级标记")
    private Integer endLevelFlag;

    @ApiModelProperty("子类")
    private List<DepartmentTreeListVO> children;

}
