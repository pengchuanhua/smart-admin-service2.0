package net.lab1024.sa.admin.module.business.path.domain.form;

import net.lab1024.sa.common.common.domain.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 设备路线 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-27 17:39:58
 * @Copyright pengch
 */

@Data
public class PathQueryForm extends PageParam{

    @ApiModelProperty(value = "路线编码/名称")
    private String path;

}