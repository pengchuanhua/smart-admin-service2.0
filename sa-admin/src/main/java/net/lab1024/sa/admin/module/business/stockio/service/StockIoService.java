package net.lab1024.sa.admin.module.business.stockio.service;

import java.util.List;

import net.lab1024.sa.admin.module.business.stockinfo.dao.StockInfoDao;
import net.lab1024.sa.admin.module.business.stockinfo.domain.entity.StockInfoEntity;
import net.lab1024.sa.admin.module.business.stockio.dao.StockIoDao;
import net.lab1024.sa.admin.module.business.stockio.domain.entity.StockIoEntity;
import net.lab1024.sa.admin.module.business.stockio.domain.form.StockIoAddForm;
import net.lab1024.sa.admin.module.business.stockio.domain.form.StockIoQueryForm;
import net.lab1024.sa.admin.module.business.stockio.domain.form.StockIoUpdateForm;
import net.lab1024.sa.admin.module.business.stockio.domain.vo.StockIoVO;
import net.lab1024.sa.common.common.util.SmartBeanUtil;
import net.lab1024.sa.common.common.util.SmartPageUtil;
import net.lab1024.sa.common.common.domain.ResponseDTO;
import net.lab1024.sa.common.common.domain.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品出入库 Service
 *
 * @Author pengch
 * @Date 2023-04-28 18:27:48
 * @Copyright v1.0
 */

@Service
public class StockIoService {

    @Autowired
    private StockIoDao stockIoDao;

    @Autowired
    private StockInfoDao stockInfoDao;

    /**
     * 分页查询
     *
     * @param queryForm
     * @return
     */
    public PageResult<StockIoVO> queryPage(StockIoQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<StockIoVO> list = stockIoDao.queryPage(page, queryForm);
        PageResult<StockIoVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    /**
     * 添加
     */
    public ResponseDTO<String> add(StockIoAddForm addForm) {
        StockIoEntity stockIoEntity = SmartBeanUtil.copy(addForm, StockIoEntity.class);
        StockInfoEntity stockInfoEntity = SmartBeanUtil.copy(addForm, StockInfoEntity.class);

        int count = stockInfoDao.updateStock(stockInfoEntity);
        if(count==0){
            stockInfoDao.insertStock(stockInfoEntity);
        }
        stockIoDao.insert(stockIoEntity);
        return ResponseDTO.ok();
    }


}
