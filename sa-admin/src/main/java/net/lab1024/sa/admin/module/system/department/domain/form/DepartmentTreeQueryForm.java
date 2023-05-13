package net.lab1024.sa.admin.module.system.department.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 位置信息 分页查询表单
 *
 * @Author pengch
 * @Date 2023-05-06 12:04:10
 * @Copyright v1.0
 */

@Data
public class DepartmentTreeQueryForm {

    @ApiModelProperty("父级类目id|可选")
    private Long parentId;

    @ApiModelProperty("父级类目id|可选")
    private String code;


}