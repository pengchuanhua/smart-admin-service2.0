package net.lab1024.sa.admin.module.business.sales.service;

import java.util.List;
import java.util.Optional;

import net.lab1024.sa.admin.module.business.sales.dao.SalesDao;
import net.lab1024.sa.admin.module.business.sales.domain.entity.SalesEntity;
import net.lab1024.sa.admin.module.business.sales.domain.form.*;
import net.lab1024.sa.admin.module.business.sales.domain.vo.*;
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
    public PageResult<SalesQueryVO> queryPage(SalesQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<SalesQueryVO> list = salesDao.queryPage1(page, queryForm);
        PageResult<SalesQueryVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    public PageResult<SalesQueryAgentVO> queryPage(SalesQueryAgentForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<SalesQueryAgentVO> list = salesDao.queryPage2(page, queryForm);
        PageResult<SalesQueryAgentVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    public PageResult<SalesQueryBrandAndCategoryVO> queryPage(SalesQueryBrandAndCategoryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<SalesQueryBrandAndCategoryVO> list = salesDao.queryPage3(page, queryForm);
        PageResult<SalesQueryBrandAndCategoryVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    public PageResult<SalesQueryGoodsVO> queryPage(SalesQueryGoodsForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<SalesQueryGoodsVO> list = salesDao.queryPage4(page, queryForm);
        PageResult<SalesQueryGoodsVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    public PageResult<SalesQueryLocationVO> queryPage(SalesQueryLocationForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<SalesQueryLocationVO> list = salesDao.queryPage5(page, queryForm);
        PageResult<SalesQueryLocationVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    public PageResult<SalesQueryQuipmentVO> queryPage(SalesQueryQuipmentForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<SalesQueryQuipmentVO> list = salesDao.queryPage6(page, queryForm);
        PageResult<SalesQueryQuipmentVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    public PageResult<SalesRefQueryVO> queryPage(SalesRefQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<SalesRefQueryVO> list = salesDao.queryPage7(page, queryForm);
        PageResult<SalesRefQueryVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
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
