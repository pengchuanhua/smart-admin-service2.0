package net.lab1024.sa.admin.module.business.supplie.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 供应商 列表VO
 *
 * @Author pengch
 * @Date 2023-04-27 17:15:30
 * @Copyright v1.0
 */

@Data
public class SupplieVO {


    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "组织ID")
    private String orgId;

    @ApiModelProperty(value = "供应商编码")
    private String code;

    @ApiModelProperty(value = "供应商名称")
    private String name;

    @ApiModelProperty(value = "联系人")
    private String contacts;

    @ApiModelProperty(value = "联系人电话")
    private String phone;

    @ApiModelProperty(value = "开户银行")
    private String bank;

    @ApiModelProperty(value = "银行账号")
    private String accountNum;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime ctime;

    @ApiModelProperty(value = "创建员工")
    private String cempName;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime utime;

    @ApiModelProperty(value = "更新员工")
    private String uempName;

    @ApiModelProperty(value = "有效标记(0:有效,1:无效)")
    private Integer isDisabled;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "时间戳")
    private Long ts01;

}