package net.lab1024.sa.admin.module.business.quipment.service;

import java.util.Date;
import java.util.List;

import net.lab1024.sa.admin.config.AuthenticationInfo;
import net.lab1024.sa.admin.module.business.quipment.dao.QuipmentDao;
import net.lab1024.sa.admin.module.business.quipment.domain.entity.QuipmentEntity;
import net.lab1024.sa.admin.module.business.quipment.domain.form.QuipmentAddForm;
import net.lab1024.sa.admin.module.business.quipment.domain.form.QuipmentQueryForm;
import net.lab1024.sa.admin.module.business.quipment.domain.form.QuipmentUpdateForm;
import net.lab1024.sa.admin.module.business.quipment.domain.vo.QuipmentVO;
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
 * 设备信息 Service
 *
 * @Author pengch
 * @Date 2023-04-28 18:56:09
 * @Copyright v1.0
 */

@Service
public class QuipmentService {

    @Autowired
    private QuipmentDao quipmentDao;

    @Resource
    private AuthenticationInfo authenticationInfo;

    /**
     * 分页查询
     *
     * @param queryForm
     * @return
     */
    public PageResult<QuipmentVO> queryPage(QuipmentQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<QuipmentVO> list = quipmentDao.queryPage(page, queryForm);
        PageResult<QuipmentVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    /**
     * 添加
     */
    public ResponseDTO<String> add(QuipmentAddForm addForm) {
        QuipmentEntity quipmentEntity = SmartBeanUtil.copy(addForm, QuipmentEntity.class);
        quipmentEntity.setCreateUser(authenticationInfo.getAuthentication().getName());
        quipmentEntity.setCreateTime(new Date());
        quipmentEntity.setTs01(System.currentTimeMillis());
        quipmentDao.insert(quipmentEntity);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     *
     * @param updateForm
     * @return
     */
    public ResponseDTO<String> update(QuipmentUpdateForm updateForm) {
        QuipmentEntity quipmentEntity = SmartBeanUtil.copy(updateForm, QuipmentEntity.class);
        quipmentEntity.setUpdateUser(authenticationInfo.getAuthentication().getName());
        quipmentEntity.setUpdateTime(new Date());
        quipmentEntity.setTs01(System.currentTimeMillis());
        int row = quipmentDao.updateQuipmentById(quipmentEntity);
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

        quipmentDao.deleteBatchIds(idList);
        return ResponseDTO.ok();
    }

    /**
     * 单个删除
     */
    public ResponseDTO<String> delete(Long id) {
        if (null == id){
            return ResponseDTO.ok();
        }

        quipmentDao.deleteById(id);
        return ResponseDTO.ok();
    }
}
