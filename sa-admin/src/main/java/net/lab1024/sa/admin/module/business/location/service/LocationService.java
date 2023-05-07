package net.lab1024.sa.admin.module.business.location.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import net.lab1024.sa.admin.config.AuthenticationInfo;
import net.lab1024.sa.admin.module.business.location.dao.LocationDao;
import net.lab1024.sa.admin.module.business.location.domain.entity.LocationEntity;
import net.lab1024.sa.admin.module.business.location.domain.form.LocationAddForm;
import net.lab1024.sa.admin.module.business.location.domain.form.LocationTreeQueryForm;
import net.lab1024.sa.admin.module.business.location.domain.form.LocationUpdateForm;
import net.lab1024.sa.admin.module.business.location.domain.vo.LocationTreeVO;
import net.lab1024.sa.admin.module.business.location.domain.vo.LocationVO;
import net.lab1024.sa.admin.module.business.location.manager.LocationManager;
import net.lab1024.sa.admin.module.business.region.domain.entity.RegionEntity;
import net.lab1024.sa.admin.module.business.region.domain.form.RegionTreeQueryForm;
import net.lab1024.sa.admin.module.business.region.domain.vo.RegionTreeVO;
import net.lab1024.sa.admin.module.business.region.domain.vo.RegionVO;
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
 * 位置信息 Service
 *
 * @Author pengch
 * @Date 2023-05-06 12:04:10
 * @Copyright v1.0
 */

@Service
public class LocationService {

    @Autowired
    private LocationDao locationDao;

    @Resource
    private AuthenticationInfo authenticationInfo;

    @Autowired
    private LocationManager locationManager;

    public ResponseDTO<LocationVO> queryDetail(Long code) {
        Optional<LocationEntity> optional = queryLocationById(code);
        if (!optional.isPresent()) {
            return ResponseDTO.error(UserErrorCode.DATA_NOT_EXIST);
        }
        LocationVO adminVO = SmartBeanUtil.copy(optional.get(), LocationVO.class);
        return ResponseDTO.ok(adminVO);
    }

    /**
     * 根据父级id 查询所有子类 返回层级树
     * 如果父类id 为空 返回所有类目层级
     *
     * @param queryForm
     * @return
     */
    public ResponseDTO<List<LocationTreeVO>> queryTree(LocationTreeQueryForm queryForm) {
        if (null == queryForm.getParentId()) {
            queryForm.setParentId(NumberUtils.LONG_ZERO);
        }
        List<LocationTreeVO> treeList = locationManager.queryLocationTree(queryForm.getParentId());
        return ResponseDTO.ok(treeList);
    }


    /**
     * 添加
     */
    public ResponseDTO<String> add(LocationAddForm addForm) {
        LocationEntity locationEntity = SmartBeanUtil.copy(addForm, LocationEntity.class);
        ResponseDTO<String> res = this.checkLocation(locationEntity, false);
        if (!res.getOk()) {
            return res;
        }
        long parentCode = null == addForm.getParentCode() ? NumberUtils.LONG_ZERO : addForm.getParentCode();
        locationEntity.setParentCode(parentCode);
        locationEntity.setCempName(authenticationInfo.getAuthentication().getName());
        locationEntity.setCtime(new Date());
        locationEntity.setTs01(System.currentTimeMillis());
        locationDao.insert(locationEntity);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     *
     * @param updateForm
     * @return
     */
    public ResponseDTO<String> update(LocationUpdateForm updateForm) {

        Long code = updateForm.getCode();
        Optional<LocationEntity> optional = this.queryLocationById(code);
        if (!optional.isPresent()) {
            return ResponseDTO.error(UserErrorCode.DATA_NOT_EXIST);
        }
        LocationEntity locationEntity = SmartBeanUtil.copy(updateForm, LocationEntity.class);
        locationEntity.setParentCode (optional.get().getParentCode());

        ResponseDTO<String> responseDTO = this.checkLocation(locationEntity, true);
        if (!responseDTO.getOk()) {
            return responseDTO;
        }

        locationEntity.setUempName(authenticationInfo.getAuthentication().getName());
        locationEntity.setUtime(new Date());
        locationEntity.setNew_ts01(System.currentTimeMillis());
        int row = locationDao.updateLocationById(locationEntity);
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

        locationDao.deleteBatchIds(idList);
        return ResponseDTO.ok();
    }

    /**
     * 单个删除
     */
    public ResponseDTO<String> delete(Long id) {
        if (null == id){
            return ResponseDTO.ok();
        }

        locationDao.deleteById(id);
        return ResponseDTO.ok();
    }

    public Optional<LocationEntity> queryLocationById(Long code) {
        if (null == code) {
            return Optional.empty();
        }
        LocationEntity entity = locationManager.queryLocationById(code);
        if (null == entity) {
            return Optional.empty();
        }
        return Optional.of(entity);
    }

    private ResponseDTO<String> checkLocation(LocationEntity locationEntity, boolean isUpdate) {
        // 校验父级是否存在
        Long parentId = locationEntity.getParentCode();
        if (null != parentId) {
            if (Objects.equals(locationEntity.getCode(), parentId)) {
                return ResponseDTO.userErrorParam("编码不能和上级编码相同");
            }
            if (!Objects.equals(parentId, NumberUtils.LONG_ZERO)) {
                Optional<LocationEntity> optional = this.queryLocationById(parentId);
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
