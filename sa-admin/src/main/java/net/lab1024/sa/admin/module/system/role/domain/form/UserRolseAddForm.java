package net.lab1024.sa.admin.module.system.role.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.admin.module.business.depot.domain.entity.DepotEntity;
import net.lab1024.sa.admin.module.business.depot.domain.vo.DepotVO;
import net.lab1024.sa.admin.module.business.quipment.domain.entity.QuipmentEntity;
import net.lab1024.sa.admin.module.business.quipment.domain.vo.QuipmentVO;
import net.lab1024.sa.admin.module.system.department.domain.entity.DepartmentEntity;
import net.lab1024.sa.admin.module.system.department.domain.vo.DepartmentVO;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleDepartmentEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleDepotEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleQuipmentEntity;
import net.lab1024.sa.common.common.domain.PageParam;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 商品库存 分页查询表单
 *
 * @Author pengch
 * @Date 2023-04-28 18:42:05
 * @Copyright v1.0
 */

@Data
public class UserRolseAddForm{


    @ApiModelProperty(value = "人员编码")
    @NotNull(message = "人员编码不能为空")
    private Long employeeId;

    @ApiModelProperty(value = "仓库权限明细")
    List<RoleDepotEntity> userDepotEntities;

    @ApiModelProperty(value = "设备权限明细")
    List<RoleQuipmentEntity> userQuipmentEntities;

    @ApiModelProperty(value = "部门权限明细")
    List<RoleDepartmentEntity> userDepartmentEntities;


}