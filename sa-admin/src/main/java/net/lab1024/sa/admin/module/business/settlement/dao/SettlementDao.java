package net.lab1024.sa.admin.module.business.settlement.dao;

import java.util.List;
import net.lab1024.sa.admin.module.business.settlement.domain.entity.SettlementEntity;
import net.lab1024.sa.admin.module.business.settlement.domain.entity.SettlementitemEntity;
import net.lab1024.sa.admin.module.business.settlement.domain.form.SettlementQueryForm;
import net.lab1024.sa.admin.module.business.settlement.domain.form.SettlementitemQueryForm;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.SettlementVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 结算主表 Dao
 *
 * @Author pengch
 * @Date 2023-05-04 18:16:11
 * @Copyright v1.0
 */

@Mapper
@Component
public interface SettlementDao extends BaseMapper<SettlementEntity> {

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<SettlementVO> queryPage(Page page, @Param("queryForm") SettlementQueryForm queryForm);

    SettlementitemEntity querySettlementitem(@Param("queryForm") SettlementitemQueryForm queryForm);


}
