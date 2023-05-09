package net.lab1024.sa.admin.module.business.stockinfo.dao;

import java.util.List;
import net.lab1024.sa.admin.module.business.stockinfo.domain.entity.StockInfoEntity;
import net.lab1024.sa.admin.module.business.stockinfo.domain.form.StockInfoQueryForm;
import net.lab1024.sa.admin.module.business.stockinfo.domain.vo.StockInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 商品库存 Dao
 *
 * @Author pengch
 * @Date 2023-04-28 18:42:05
 * @Copyright v1.0
 */

@Mapper
@Component
public interface StockInfoDao extends BaseMapper<StockInfoEntity> {

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<StockInfoVO> queryPage(Page page, @Param("queryForm") StockInfoQueryForm queryForm);

    int insertStock(StockInfoEntity stockInfoEntity);

    int updateStock(StockInfoEntity stockInfoEntity);

}
