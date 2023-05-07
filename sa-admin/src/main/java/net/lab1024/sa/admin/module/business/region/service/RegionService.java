package net.lab1024.sa.admin.module.business.region.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import net.lab1024.sa.admin.config.AuthenticationInfo;
import net.lab1024.sa.admin.module.business.category.domain.entity.CategoryEntity;
import net.lab1024.sa.admin.module.business.category.domain.form.CategoryTreeQueryForm;
import net.lab1024.sa.admin.module.business.category.domain.vo.CategoryTreeVO;
import net.lab1024.sa.admin.module.business.category.domain.vo.CategoryVO;
import net.lab1024.sa.admin.module.business.region.dao.RegionDao;
import net.lab1024.sa.admin.module.business.region.domain.entity.RegionEntity;
import net.lab1024.sa.admin.module.business.region.domain.form.RegionAddForm;
import net.lab1024.sa.admin.module.business.region.domain.form.RegionTreeQueryForm;
import net.lab1024.sa.admin.module.business.region.domain.form.RegionUpdateForm;
import net.lab1024.sa.admin.module.business.region.domain.vo.RegionTreeVO;
import net.lab1024.sa.admin.module.business.region.domain.vo.RegionVO;
import net.lab1024.sa.admin.module.business.region.manager.RegionManager;
import net.lab1024.sa.common.common.code.UserErrorCode;
import net.lab1024.sa.common.common.util.SmartBeanUtil;
import net.lab1024.sa.common.common.util.SmartPageUtil;
import net.lab1024.sa.common.common.domain.ResponseDTO;
import net.lab1024.sa.common.common.domain.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 地区信息 Service
 *
 * @Author pengch
 * @Date 2023-04-27 17:11:14
 * @Copyright v1.0
 */

@Service
public class RegionService {

    @Autowired
    private RegionDao regionDao;

    @Resource
    private AuthenticationInfo authenticationInfo;

    @Autowired
    private RegionManager regionManager;

    public ResponseDTO<RegionVO> queryDetail(Long code) {
        Optional<RegionEntity> optional = queryRegionById(code);
        if (!optional.isPresent()) {
            return ResponseDTO.error(UserErrorCode.DATA_NOT_EXIST);
        }
        RegionVO adminVO = SmartBeanUtil.copy(optional.get(), RegionVO.class);
        return ResponseDTO.ok(adminVO);
    }

    /**
     * 根据父级id 查询所有子类 返回层级树
     * 如果父类id 为空 返回所有类目层级
     *
     * @param queryForm
     * @return
     */
    public ResponseDTO<List<RegionTreeVO>> queryTree(RegionTreeQueryForm queryForm) {
        if (null == queryForm.getParentId()) {
            queryForm.setParentId(NumberUtils.LONG_ZERO);
        }
        List<RegionTreeVO> treeList = regionManager.queryRegionTree(queryForm.getParentId());
        return ResponseDTO.ok(treeList);
    }

    /**
     * 添加
     */
    public ResponseDTO<String> add(RegionAddForm addForm) {
        RegionEntity regionEntity = SmartBeanUtil.copy(addForm, RegionEntity.class);
        ResponseDTO<String> res = this.checkRegion(regionEntity, false);
        if (!res.getOk()) {
            return res;
        }
        long parentCode = null == addForm.getParentCode() ? NumberUtils.LONG_ZERO : addForm.getParentCode();
        regionEntity.setParentCode(parentCode);
        regionEntity.setCempName(authenticationInfo.getAuthentication().getName());
        regionEntity.setCtime(new Date());
        regionEntity.setTs01(System.currentTimeMillis());
        regionDao.insert(regionEntity);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     *
     * @param updateForm
     * @return
     */
    public ResponseDTO<String> update(RegionUpdateForm updateForm) {

        Long code = updateForm.getCode();
        Optional<RegionEntity> optional = this.queryRegionById(code);
        if (!optional.isPresent()) {
            return ResponseDTO.error(UserErrorCode.DATA_NOT_EXIST);
        }


        RegionEntity regionEntity = SmartBeanUtil.copy(updateForm, RegionEntity.class);

        regionEntity.setParentCode(optional.get().getParentCode());

        ResponseDTO<String> responseDTO = this.checkRegion(regionEntity, true);
        if (!responseDTO.getOk()) {
            return responseDTO;
        }

        regionEntity.setUempName(authenticationInfo.getAuthentication().getName());
        regionEntity.setUtime(new Date());
        regionEntity.setNew_ts01(System.currentTimeMillis());
        int row = regionDao.updateRegionById(regionEntity);
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
    public ResponseDTO<String> batchDelete(List<String> idList) {
        if (CollectionUtils.isEmpty(idList)){
            return ResponseDTO.ok();
        }

        regionDao.deleteBatchIds(idList);
        return ResponseDTO.ok();
    }

    /**
     * 单个删除
     */
    public ResponseDTO<String> delete(String code) {
        if (null == code){
            return ResponseDTO.ok();
        }

        regionDao.deleteById(code);
        return ResponseDTO.ok();
    }

    public Optional<RegionEntity> queryRegionById(Long code) {
        if (null == code) {
            return Optional.empty();
        }
        RegionEntity entity = regionManager.queryRegionById(code);
        if (null == entity) {
            return Optional.empty();
        }
        return Optional.of(entity);
    }

    private ResponseDTO<String> checkRegion(RegionEntity regionEntity, boolean isUpdate) {
        // 校验父级是否存在
        Long parentId = regionEntity.getParentCode();
        if (null != parentId) {
            if (Objects.equals(regionEntity.getCode(), parentId)) {
                return ResponseDTO.userErrorParam("地区编码不能和上级编码相同");
            }
            if (!Objects.equals(parentId, NumberUtils.LONG_ZERO)) {
                Optional<RegionEntity> optional = this.queryRegionById(parentId);
                if (!optional.isPresent()) {
                    return ResponseDTO.error(UserErrorCode.DATA_NOT_EXIST, "上级编码不存在");
                }
            }

        } else {
            // 如果没有父类 使用默认父类
            parentId = NumberUtils.LONG_ZERO;
        }
        return ResponseDTO.ok();
    }

}
