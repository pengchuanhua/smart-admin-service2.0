package net.lab1024.sa.admin.module.business.brand.service;

import java.util.Date;
import java.util.List;

import net.lab1024.sa.admin.config.AuthenticationInfo;
import net.lab1024.sa.admin.module.business.brand.dao.BrandDao;
import net.lab1024.sa.admin.module.business.brand.domain.entity.BrandEntity;
import net.lab1024.sa.admin.module.business.brand.domain.form.BrandAddForm;
import net.lab1024.sa.admin.module.business.brand.domain.form.BrandQueryForm;
import net.lab1024.sa.admin.module.business.brand.domain.form.BrandUpdateForm;
import net.lab1024.sa.admin.module.business.brand.domain.vo.BrandVO;
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
 * 品牌 Service
 *
 * @Author pengch
 * @Date 2023-04-27 17:16:42
 * @Copyright v1.0
 */

@Service
public class BrandService {

    @Autowired
    private BrandDao brandDao;

    @Resource
    private AuthenticationInfo authenticationInfo;

    /**
     * 分页查询
     *
     * @param queryForm
     * @return
     */
    public PageResult<BrandVO> queryPage(BrandQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<BrandVO> list = brandDao.queryPage(page, queryForm);
        PageResult<BrandVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    /**
     * 添加
     */
    public ResponseDTO<String> add(BrandAddForm addForm) {
        BrandEntity brandEntity = SmartBeanUtil.copy(addForm, BrandEntity.class);
        brandEntity.setCempName(authenticationInfo.getAuthentication().getName());
        brandEntity.setCtime(new Date());
        brandEntity.setTs01(System.currentTimeMillis());
        brandDao.insert(brandEntity);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     *
     * @param updateForm
     * @return
     */
    public ResponseDTO<String> update(BrandUpdateForm updateForm) {
        BrandEntity brandEntity = SmartBeanUtil.copy(updateForm, BrandEntity.class);
        brandEntity.setUempName(authenticationInfo.getAuthentication().getName());
        brandEntity.setUtime(new Date());
        brandEntity.setNew_ts01(System.currentTimeMillis());
        int row = brandDao.updateBrandById(brandEntity);
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

        brandDao.deleteBatchIds(idList);
        return ResponseDTO.ok();
    }

    /**
     * 单个删除
     */
    public ResponseDTO<String> delete(Long id) {
        if (null == id){
            return ResponseDTO.ok();
        }

        brandDao.deleteById(id);
        return ResponseDTO.ok();
    }
}
