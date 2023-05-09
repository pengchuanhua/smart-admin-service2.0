package net.lab1024.sa.admin.module.business.stockio.dao;

import java.util.List;
import net.lab1024.sa.admin.module.business.stockio.domain.entity.StockIoEntity;
import net.lab1024.sa.admin.module.business.stockio.domain.form.StockIoQueryForm;
import net.lab1024.sa.admin.module.business.stockio.domain.vo.StockIoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 商品出入库 Dao
 *
 * @Author pengch
 * @Date 2023-04-28 18:27:48
 * @Copyright v1.0
 */

@Mapper
@Component
public interface StockIoDao extends BaseMapper<StockIoEntity> {

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<StockIoVO> queryPage(Page page, @Param("queryForm") StockIoQueryForm queryForm);


}
