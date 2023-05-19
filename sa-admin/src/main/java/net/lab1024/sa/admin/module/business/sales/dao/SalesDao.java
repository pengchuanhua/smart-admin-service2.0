package net.lab1024.sa.admin.module.business.sales.dao;

import java.util.List;
import net.lab1024.sa.admin.module.business.sales.domain.entity.SalesEntity;
import net.lab1024.sa.admin.module.business.sales.domain.form.*;
import net.lab1024.sa.admin.module.business.sales.domain.vo.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 设备销售表 Dao
 *
 * @Author pengch
 * @Date 2023-04-29 19:56:46
 * @Copyright v1.0
 */

@Mapper
@Component
public interface SalesDao extends BaseMapper<SalesEntity> {

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<SalesQueryVO> queryPage1(Page page, @Param("queryForm") SalesQueryForm queryForm);

    List<SalesQueryAgentVO> queryPage2(Page page, @Param("queryForm") SalesQueryAgentForm queryForm);

    List<SalesQueryBrandAndCategoryVO> queryPage3(Page page, @Param("queryForm") SalesQueryBrandAndCategoryForm queryForm);

    List<SalesQueryGoodsVO> queryPage4(Page page, @Param("queryForm") SalesQueryGoodsForm queryForm);

    List<SalesQueryLocationVO> queryPage5(Page page, @Param("queryForm") SalesQueryLocationForm queryForm);

    List<SalesQueryQuipmentVO> queryPage6(Page page, @Param("queryForm") SalesQueryQuipmentForm queryForm);

    List<SalesRefQueryVO> queryPage7(Page page, @Param("queryForm") SalesRefQueryForm queryForm);

    SalesEntity querySalesById(@Param ("id") long id);

    List<SalesQueryVO>querySales(@Param("queryForm")SalesQueryForm queryForm);

    List<SalesQueryVO> querySettmentitem(Page page, @Param("queryForm") SalesQueryForm queryForm);


}
