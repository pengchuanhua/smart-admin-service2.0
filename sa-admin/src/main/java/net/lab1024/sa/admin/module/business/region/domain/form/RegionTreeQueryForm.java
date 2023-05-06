package net.lab1024.sa.admin.module.business.region.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 地区信息 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-27 17:11:14
 * @Copyright v1.0
 */

@Data
public class RegionTreeQueryForm{

    @ApiModelProperty("父级类目id|可选")
    private Long parentId;

}