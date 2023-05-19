package net.lab1024.sa.admin.module.business.settlement.dao;

import java.util.List;
import net.lab1024.sa.admin.module.business.settlement.domain.entity.SettlementEntity;
import net.lab1024.sa.admin.module.business.settlement.domain.entity.SettlementitemEntity;
import net.lab1024.sa.admin.module.business.settlement.domain.form.SalesQueryForm;
import net.lab1024.sa.admin.module.business.settlement.domain.form.SettlementQueryForm;
import net.lab1024.sa.admin.module.business.settlement.domain.form.SettlementitemQueryForm;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.PaymentVO;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.QuerySalesVO;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.SettlementVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.SettlementitemVO;
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

    List<SettlementitemVO> querySettlementitem(@Param("queryForm") SettlementitemQueryForm queryForm);


    List<QuerySalesVO> querySales(Page page,@Param("queryForm") SalesQueryForm queryForm);

    List<PaymentVO>queryPayment();

    int updateSales(SettlementitemVO settlementitemVO);

    int delete(String settlementNo);

    int update(SettlementEntity settlementEntity);

}
