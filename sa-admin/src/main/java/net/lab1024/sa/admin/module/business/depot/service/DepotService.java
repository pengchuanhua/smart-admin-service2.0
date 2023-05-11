package net.lab1024.sa.admin.module.business.depot.service;

import java.util.Date;
import java.util.List;

import net.lab1024.sa.admin.config.AuthenticationInfo;
import net.lab1024.sa.admin.module.business.depot.dao.DepotDao;
import net.lab1024.sa.admin.module.business.depot.domain.entity.DepotEntity;
import net.lab1024.sa.admin.module.business.depot.domain.form.DepotAddForm;
import net.lab1024.sa.admin.module.business.depot.domain.form.DepotQueryForm;
import net.lab1024.sa.admin.module.business.depot.domain.form.DepotUpdateForm;
import net.lab1024.sa.admin.module.business.depot.domain.form.SelectDepotQueryForm;
import net.lab1024.sa.admin.module.business.depot.domain.vo.DepotVO;
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
 * 仓库信息 Service
 *
 * @Author pengch
 * @Date 2023-04-27 17:13:39
 * @Copyright v1.0
 */

@Service
public class DepotService {

    @Autowired
    private DepotDao depotDao;

    @Resource
    private AuthenticationInfo authenticationInfo;

    /**
     * 分页查询
     *
     * @param queryForm
     * @return
     */
    public PageResult<DepotVO> queryPage(DepotQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<DepotVO> list = depotDao.queryPage(page, queryForm);
        PageResult<DepotVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    public ResponseDTO<List<DepotVO>> queryDepot(SelectDepotQueryForm queryForm) {
        List<DepotVO> adminVO = depotDao.queryDepot(queryForm);
        if (adminVO==null) {
            return ResponseDTO.error(UserErrorCode.DATA_NOT_EXIST);
        }
        return ResponseDTO.ok(adminVO);
    }

    /**
     * 添加
     */
    public ResponseDTO<String> add(DepotAddForm addForm) {
        DepotEntity depotEntity = SmartBeanUtil.copy(addForm, DepotEntity.class);
        depotEntity.setCempName(authenticationInfo.getAuthentication().getName());
        depotEntity.setCtime(new Date());
        depotEntity.setTs01(System.currentTimeMillis());
        depotDao.insertDepot(depotEntity);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     *
     * @param updateForm
     * @return
     */
    public ResponseDTO<String> update(DepotUpdateForm updateForm) {
        DepotEntity depotEntity = SmartBeanUtil.copy(updateForm, DepotEntity.class);
        depotEntity.setUempName(authenticationInfo.getAuthentication().getName());
        depotEntity.setUtime(new Date());
        depotEntity.setNew_ts01(System.currentTimeMillis());
        int row = depotDao.updateDepot(depotEntity);
        if (row==0){
            throw new RuntimeException("数据已改变,请查询后再操作!");
        }
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

        depotDao.deleteBatchIds(idList);
        return ResponseDTO.ok();
    }

    /**
     * 单个删除
     */
    public ResponseDTO<String> delete(Long id) {
        if (null == id){
            return ResponseDTO.ok();
        }

        depotDao.deleteById(id);
        return ResponseDTO.ok();
    }
}
