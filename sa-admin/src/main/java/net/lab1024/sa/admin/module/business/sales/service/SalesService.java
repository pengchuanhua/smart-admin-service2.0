package net.lab1024.sa.admin.module.business.sales.service;

import java.util.List;
import java.util.Optional;

import net.lab1024.sa.admin.module.business.region.domain.entity.RegionEntity;
import net.lab1024.sa.admin.module.business.sales.dao.SalesDao;
import net.lab1024.sa.admin.module.business.sales.domain.entity.SalesEntity;
import net.lab1024.sa.admin.module.business.sales.domain.form.SalesQueryForm;
import net.lab1024.sa.admin.module.business.sales.domain.vo.SalesVO;
import net.lab1024.sa.common.common.util.SmartPageUtil;
import net.lab1024.sa.common.common.domain.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 设备销售表 Service
 *
 * @Author pengch
 * @Date 2023-04-29 19:56:46
 * @Copyright v1.0
 */

@Service
public class SalesService {

    @Autowired
    private SalesDao salesDao;

    /**
     * 分页查询
     *
     * @param queryForm
     * @return
     */
    public PageResult<SalesVO> queryPage(SalesQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<SalesVO> list = salesDao.queryPage(page, queryForm);
        PageResult<SalesVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    public Optional<SalesEntity> querySalesById(Long id) {
        if (null == id) {
            return Optional.empty();
        }
        SalesEntity entity = salesDao.querySalesById(id);
        if (null == entity) {
            return Optional.empty();
        }
        return Optional.of(entity);
    }
}
