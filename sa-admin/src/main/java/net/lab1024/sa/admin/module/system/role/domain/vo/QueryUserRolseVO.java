package net.lab1024.sa.admin.module.system.role.domain.vo;

import lombok.Data;
import net.lab1024.sa.admin.module.business.depot.domain.vo.DepotVO;
import net.lab1024.sa.admin.module.business.quipment.domain.vo.QuipmentVO;
import net.lab1024.sa.admin.module.system.department.domain.vo.DepartmentVO;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleDepartmentEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleDepotEntity;
import net.lab1024.sa.admin.module.system.role.domain.entity.RoleQuipmentEntity;

import java.util.List;

/**
 * 商品库存 列表VO
 *
 * @Author pengch
 * @Date 2023-04-28 18:42:05
 * @Copyright v1.0
 */

@Data
public class QueryUserRolseVO {


    List<RoleDepotEntity> userWareHouses;

    List<RoleQuipmentEntity> userQuipmentVOS;

    List<RoleDepartmentEntity> userDeparts;

    /*总数*/
    Integer total;

}