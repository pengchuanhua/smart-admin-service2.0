package net.lab1024.sa.admin.module.business.settlement.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.lab1024.sa.admin.config.AuthenticationInfo;
import net.lab1024.sa.admin.module.business.sales.service.SalesService;
import net.lab1024.sa.admin.module.business.settlement.dao.SettlementDao;
import net.lab1024.sa.admin.module.business.settlement.dao.SettlementitemDao;
import net.lab1024.sa.admin.module.business.settlement.domain.entity.SettlementEntity;
import net.lab1024.sa.admin.module.business.settlement.domain.entity.SettlementitemEntity;
import net.lab1024.sa.admin.module.business.settlement.domain.form.*;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.QuerySalesVO;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.SettlementVO;
import net.lab1024.sa.common.common.code.UserErrorCode;
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
 * 结算主表 Service
 *
 * @Author pengch
 * @Date 2023-05-04 18:16:11
 * @Copyright v1.0
 */

@Service
public class SettlementService {

    @Autowired
    private SettlementDao settlementDao;

    @Autowired
    private SettlementitemDao settlementitemDao;

    @Resource
    private AuthenticationInfo authenticationInfo;

    @Autowired
    private SalesService salesService;

    /**
     * 分页查询
     *
     * @param queryForm
     * @return
     */
    public PageResult<SettlementVO> queryPage(SettlementQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<SettlementVO> list = settlementDao.queryPage(page, queryForm);
        PageResult<SettlementVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    public ResponseDTO<List<QuerySalesVO>> querySales(SalesQueryForm queryForm) {
        List<QuerySalesVO> adminVO = settlementDao.querySales(queryForm);
        if (adminVO==null) {
            return ResponseDTO.error(UserErrorCode.DATA_NOT_EXIST);
        }
        return ResponseDTO.ok(adminVO);
    }

    /**
     * 添加
     */
    public ResponseDTO<String> add(SettlementAddForm addForm) {
        SettlementEntity settlementEntity = SmartBeanUtil.copy(addForm, SettlementEntity.class);
       //检查数据完整性
        ResponseDTO<String> res = this.checkData(settlementEntity);
        if (!res.getOk()) {
            return res;
        }
        List<SettlementitemEntity>settlementitemEntities=settlementEntity.getSettlementitemEntities();
        for(int i=0;i<settlementitemEntities.size();i++){
            settlementitemDao.insert(settlementitemEntities.get(i));
        }

        settlementEntity.setCempName(authenticationInfo.getAuthentication().getName());
        settlementEntity.setCtime(new Date());
        settlementEntity.setTs01(System.currentTimeMillis());
        settlementDao.insert(settlementEntity);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     *
     * @param updateForm
     * @return
     */
    public ResponseDTO<String> update(SettlementUpdateForm updateForm) {
        SettlementEntity settlementEntity = SmartBeanUtil.copy(updateForm, SettlementEntity.class);
        settlementDao.updateById(settlementEntity);
        return ResponseDTO.ok();
    }

    /**
     * 批量删除
     *
     * @param idList
     * @return
     */
    public ResponseDTO<String> batchDelete(List<Long> idList) {
        if (CollectionUtils.isEmpty(idList)){
            return ResponseDTO.ok();
        }

        settlementDao.deleteBatchIds(idList);
        return ResponseDTO.ok();
    }

    /**
     * 单个删除
     */
    public ResponseDTO<String> delete(Long id) {
        if (null == id){
            return ResponseDTO.ok();
        }

        settlementDao.deleteById(id);
        return ResponseDTO.ok();
    }

    private ResponseDTO<String> checkData(SettlementEntity settlementEntity) {
    List<SettlementitemEntity> settlementitemEntity=settlementEntity.getSettlementitemEntities();
    if(settlementitemEntity==null){
        return ResponseDTO.error(UserErrorCode.PARAM_ERROR,"结算明细不能为空");
    }
    BigDecimal toltel_amount =BigDecimal.ZERO;
    settlementitemEntity.forEach(e -> {

        SettlementitemQueryForm settlementitemQueryForm =new SettlementitemQueryForm();
        settlementitemQueryForm.setSalesId(e.getSalesId());
        List<SettlementitemEntity> entityList=settlementDao.querySettlementitem(settlementitemQueryForm);
        if(null!=entityList&&entityList.size()>0){
          throw new RuntimeException("销售单号["+e.getSalesId()+"]已存在结算记录");
        }
        toltel_amount.add(e.getShareAmount());
    });
    if(settlementEntity.getShareAmount().compareTo(toltel_amount)!=0){
        throw new RuntimeException("结算总金额："+settlementEntity.getShareAmount()+",与明细合计金额："+toltel_amount+"不一致");
    }

        return ResponseDTO.ok();
    }
}
