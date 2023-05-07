package net.lab1024.sa.admin.module.business.supplie.service;

import java.util.Date;
import java.util.List;

import net.lab1024.sa.admin.config.AuthenticationInfo;
import net.lab1024.sa.admin.module.business.supplie.dao.SupplieDao;
import net.lab1024.sa.admin.module.business.supplie.domain.entity.SupplieEntity;
import net.lab1024.sa.admin.module.business.supplie.domain.form.SupplieAddForm;
import net.lab1024.sa.admin.module.business.supplie.domain.form.SupplieQueryForm;
import net.lab1024.sa.admin.module.business.supplie.domain.form.SupplieUpdateForm;
import net.lab1024.sa.admin.module.business.supplie.domain.vo.SupplieVO;
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
 * 供应商 Service
 *
 * @Author pengch
 * @Date 2023-04-27 17:15:30
 * @Copyright v1.0
 */

@Service
public class SupplieService {

    @Autowired
    private SupplieDao supplieDao;

    @Resource
    private AuthenticationInfo authenticationInfo;

    /**
     * 分页查询
     *
     * @param queryForm
     * @return
     */
    public PageResult<SupplieVO> queryPage(SupplieQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<SupplieVO> list = supplieDao.queryPage(page, queryForm);
        PageResult<SupplieVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    /**
     * 添加
     */
    public ResponseDTO<String> add(SupplieAddForm addForm) {
        SupplieEntity supplieEntity = SmartBeanUtil.copy(addForm, SupplieEntity.class);
        supplieEntity.setCempName(authenticationInfo.getAuthentication().getName());
        supplieEntity.setCtime(new Date());
        supplieEntity.setTs01(System.currentTimeMillis());
        supplieDao.insert(supplieEntity);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     *
     * @param updateForm
     * @return
     */
    public ResponseDTO<String> update(SupplieUpdateForm updateForm) {
        SupplieEntity supplieEntity = SmartBeanUtil.copy(updateForm, SupplieEntity.class);
        supplieEntity.setUempName(authenticationInfo.getAuthentication().getName());
        supplieEntity.setUtime(new Date());
        supplieEntity.setTs01(System.currentTimeMillis());
        int row = supplieDao.updateSupplieById(supplieEntity);
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

        supplieDao.deleteBatchIds(idList);
        return ResponseDTO.ok();
    }

    /**
     * 单个删除
     */
    public ResponseDTO<String> delete(Long id) {
        if (null == id){
            return ResponseDTO.ok();
        }

        supplieDao.deleteById(id);
        return ResponseDTO.ok();
    }
}
