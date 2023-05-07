package net.lab1024.sa.admin.module.business.stockinfo.service;

import java.util.List;
import net.lab1024.sa.admin.module.business.stockinfo.dao.StockInfoDao;
import net.lab1024.sa.admin.module.business.stockinfo.domain.form.StockInfoQueryForm;
import net.lab1024.sa.admin.module.business.stockinfo.domain.vo.StockInfoVO;
import net.lab1024.sa.common.common.util.SmartPageUtil;
import net.lab1024.sa.common.common.domain.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品库存 Service
 *
 * @Author pengch
 * @Date 2023-04-28 18:42:05
 * @Copyright v1.0
 */

@Service
public class StockInfoService {

    @Autowired
    private StockInfoDao stockInfoDao;

    /**
     * 分页查询
     *
     * @param queryForm
     * @return
     */
    public PageResult<StockInfoVO> queryPage(StockInfoQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<StockInfoVO> list = stockInfoDao.queryPage(page, queryForm);
        PageResult<StockInfoVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }


}
