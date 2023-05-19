package net.lab1024.sa.admin.module.business.stockio.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import net.lab1024.sa.admin.config.AuthenticationInfo;
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

import javax.annotation.Resource;

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

    @Resource
    private AuthenticationInfo authenticationInfo;

    private static final SimpleDateFormat format4y = new SimpleDateFormat("yyyyMMddHHmmssSSS");

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
        long now = System.currentTimeMillis();
        StockIoEntity stockIoEntity = SmartBeanUtil.copy(addForm, StockIoEntity.class);
        if (stockIoEntity.getType()==0){//入库
            stockIoEntity.setStockNo("RK"+format4y.format(new Date(now)));
        }else {
            stockIoEntity.setStockNo("CK"+format4y.format(new Date(now)));
        }
        stockIoEntity.setOrgId("1");
        stockIoEntity.setCempName(authenticationInfo.getAuthentication().getName());
        stockIoEntity.setCtime(new Date());
        stockIoEntity.setUempName(authenticationInfo.getAuthentication().getName());
        stockIoEntity.setUtime(new Date());
        stockIoEntity.setTs01(System.currentTimeMillis());

        StockInfoEntity stockInfoEntity = SmartBeanUtil.copy(addForm, StockInfoEntity.class);
        stockInfoEntity.setOrgId("1");
        stockInfoEntity.setCempName(authenticationInfo.getAuthentication().getName());
        stockInfoEntity.setCtime(new Date());
        stockInfoEntity.setUempName(authenticationInfo.getAuthentication().getName());
        stockInfoEntity.setUtime(new Date());
        stockInfoEntity.setTs01(System.currentTimeMillis());
        if (stockIoEntity.getType()==1) {//出库
            stockInfoEntity.setStockNum(stockIoEntity.getOperNum()*-1);
        }else {
            stockInfoEntity.setStockNum(stockIoEntity.getOperNum());
        }

        int count = stockInfoDao.updateStock(stockInfoEntity);
        if(count==0){
            stockInfoDao.insertStock(stockInfoEntity);
        }
        stockIoDao.insert(stockIoEntity);
        return ResponseDTO.ok();
    }


}
