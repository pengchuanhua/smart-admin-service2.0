package net.lab1024.sa.admin.module.business.depot.dao;

import java.util.List;

import net.lab1024.sa.admin.module.business.depot.domain.entity.DepotEntity;
import net.lab1024.sa.admin.module.business.depot.domain.form.DepotQueryForm;
import net.lab1024.sa.admin.module.business.depot.domain.vo.DepotVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 仓库信息 Dao
 *
 * @Author pengch
 * @Date 2023-04-27 17:13:39
 * @Copyright v1.0
 */

@Mapper
@Component
public interface DepotDao extends BaseMapper<DepotEntity> {

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<DepotVO> queryPage(Page page, @Param("queryForm") DepotQueryForm queryForm);

    int insertDepot(DepotEntity depotEntity);

    int updateDepot(DepotEntity depotEntity);

    List<DepotVO> queryDepot(@Param("queryForm") DepotQueryForm queryForm);


}
