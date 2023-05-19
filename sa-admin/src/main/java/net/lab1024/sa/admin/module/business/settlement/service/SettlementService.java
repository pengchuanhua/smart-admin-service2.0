package net.lab1024.sa.admin.module.business.settlement.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.lab1024.sa.admin.config.AuthenticationInfo;
import net.lab1024.sa.admin.module.business.settlement.dao.SettlementDao;
import net.lab1024.sa.admin.module.business.settlement.dao.SettlementitemDao;
import net.lab1024.sa.admin.module.business.settlement.domain.entity.SettlementEntity;
import net.lab1024.sa.admin.module.business.settlement.domain.entity.SettlementitemEntity;
import net.lab1024.sa.admin.module.business.settlement.domain.form.*;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.PaymentVO;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.QuerySalesVO;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.SettlementVO;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.SettlementitemVO;
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

    /**
     * 分页查询-待结算明细
     *
     * @param queryForm
     * @return
     */

    public PageResult<QuerySalesVO> querySales(SalesQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<QuerySalesVO> list = settlementDao.querySales(page, queryForm);
        PageResult<QuerySalesVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    /**
     * 查询-结算明细
     *
     * @param queryForm
     * @return
     */

    public ResponseDTO<List<SettlementitemVO>> querySettlementitem(SettlementitemQueryForm queryForm) {
        List<SettlementitemVO> adminVO = settlementDao.querySettlementitem(queryForm);
        if (adminVO==null) {
            return ResponseDTO.error(UserErrorCode.DATA_NOT_EXIST);
        }
        return ResponseDTO.ok(adminVO);
    }


    /**
     * 添加
     */
    public ResponseDTO<String> add(SettlementAddForm addForm) {
       //检查数据完整性
        ResponseDTO<String> res = this.checkData(addForm);
        if (!res.getOk()) {
            return res;
        }

        SettlementEntity settlementEntity = SmartBeanUtil.copy(addForm, SettlementEntity.class);

        List<SettlementitemAddForm>settlementitemAddForms =addForm.getSettlementitemAddForms();
        for(int i=0;i<settlementitemAddForms.size();i++){
            SettlementitemEntity entity=SmartBeanUtil.copy(settlementitemAddForms.get(i),SettlementitemEntity.class);
            entity.setSettlementNo(addForm.getSettlementNo());
            entity.setTs01(System.currentTimeMillis());
            settlementitemDao.insert(entity);
        }

        settlementEntity.setCempName(authenticationInfo.getAuthentication().getName());
        settlementEntity.setCtime(new Date());
        settlementEntity.setTs01(System.currentTimeMillis());
        settlementDao.insert(settlementEntity);
        return ResponseDTO.ok();
    }

    /**
     * 审核
     *
     * @param updateForm
     * @return
     */
    public ResponseDTO<String> update(SettlementUpdateForm updateForm) {
        SettlementEntity settlementEntity = SmartBeanUtil.copy(updateForm, SettlementEntity.class);
        SettlementitemQueryForm queryForm=new SettlementitemQueryForm();
        queryForm.setSettlementNo(updateForm.getSettlementNo());
        List<SettlementitemVO>settlementitemVOList= settlementDao.querySettlementitem(queryForm);
        if(settlementitemVOList==null||settlementitemVOList.size()==0){
            throw new RuntimeException("审核失败;未查到结算明细数据");
        }
        //审核更新销售单结算标记以及结算单号
        for(int i=0;i<settlementitemVOList.size();i++){
            settlementDao.updateSales(settlementitemVOList.get(i));
        }

        settlementEntity.setCkName(authenticationInfo.getAuthentication().getName());
        settlementEntity.setCktime(new Date());
        settlementEntity.setTs01(System.currentTimeMillis());
        settlementDao.update(settlementEntity);
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
    public ResponseDTO<String> delete(String settlementNo) {
        if (null == settlementNo){
            return ResponseDTO.ok();
        }
        int count=settlementitemDao.delete(settlementNo);
        int row=settlementDao.delete(settlementNo);
        if(count==0||row==0){
            throw new RuntimeException("删除失败,请重新查询后操作");
        }
        return ResponseDTO.ok();
    }

    private ResponseDTO<String> checkData(SettlementAddForm addForm) {
    List<SettlementitemAddForm> settlementitemAddForms=addForm.getSettlementitemAddForms();
    if(settlementitemAddForms==null){
        return ResponseDTO.error(UserErrorCode.PARAM_ERROR,"结算明细不能为空");
    }
    BigDecimal toltel_amount =BigDecimal.ZERO;
        settlementitemAddForms.forEach(e -> {
        SettlementitemQueryForm settlementitemQueryForm =new SettlementitemQueryForm();
        settlementitemQueryForm.setSalesNo(e.getSalesNo());
        List<SettlementitemVO> entityList=settlementDao.querySettlementitem(settlementitemQueryForm);
        if(null!=entityList&&entityList.size()>0){
          throw new RuntimeException("销售单号["+e.getSalesNo()+"]已存在结算记录");
        }
        toltel_amount.add(e.getShareAmount());
    });
    if(addForm.getShareAmount().compareTo(toltel_amount)!=0){
        throw new RuntimeException("结算总金额："+addForm.getShareAmount()+",与明细合计结算金额："+toltel_amount+"不一致");
    }
        return ResponseDTO.ok();
    }

    public ResponseDTO<List<PaymentVO>> queryPayment() {
        List<PaymentVO> adminVO = settlementDao.queryPayment();
        if (adminVO==null) {
            return ResponseDTO.error(UserErrorCode.DATA_NOT_EXIST);
        }
        return ResponseDTO.ok(adminVO);
    }
}
