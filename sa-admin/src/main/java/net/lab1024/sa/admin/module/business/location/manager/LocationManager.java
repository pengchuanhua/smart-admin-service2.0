package net.lab1024.sa.admin.module.business.location.manager;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import net.lab1024.sa.admin.module.business.location.domain.entity.LocationEntity;
import net.lab1024.sa.admin.module.business.location.dao.LocationDao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.lab1024.sa.admin.module.business.location.domain.vo.LocationTreeVO;
import net.lab1024.sa.admin.module.business.region.domain.entity.RegionEntity;
import net.lab1024.sa.admin.module.business.region.domain.vo.RegionTreeVO;
import net.lab1024.sa.common.common.constant.StringConst;
import net.lab1024.sa.common.common.util.SmartBeanUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 位置信息  Manager
 *
 * @Author pengch
 * @Date 2023-05-06 12:04:10
 * @Copyright v1.0
 */
@Service
@Slf4j
public class LocationManager{

    @Autowired
    private LocationDao locationDao;

    public LocationEntity queryLocationById(Long id) {
        return locationDao.queryLocationById(id);
    }

    public List<LocationTreeVO> queryLocationTree(Long parentId) {
        List<LocationEntity> allLocationEntityList = locationDao.queryLocation();
        List<LocationEntity> locationEntityList = allLocationEntityList.stream().filter(e -> e.getParentCode().equals(parentId)).collect(Collectors.toList());
        List<LocationTreeVO> treeList = SmartBeanUtil.copyList(locationEntityList, LocationTreeVO.class);
        treeList.forEach(e -> {
            e.setLabel(e.getName());
            e.setValue(e.getId());
        });
        // 递归设置子类
        this.queryAndSetSubLocation(treeList, allLocationEntityList);
        return treeList;
    }

    private void queryAndSetSubLocation(List<LocationTreeVO> treeList, List<LocationEntity> allLocationEntityList) {
        if (CollectionUtils.isEmpty(treeList)) {
            return;
        }
        List<Long> parentIdList = treeList.stream().map(LocationTreeVO::getValue).collect(Collectors.toList());
        List<LocationEntity> locationEntityList = allLocationEntityList.stream().filter(e -> parentIdList.contains(e.getParentCode())).collect(Collectors.toList());
        Map<Long, List<LocationEntity>> LocationSubMap = locationEntityList.stream().collect(Collectors.groupingBy(LocationEntity::getParentCode));
        treeList.forEach(e -> {
            List<LocationEntity> childrenEntityList = LocationSubMap.getOrDefault(e.getValue(), Lists.newArrayList());
            List<LocationTreeVO> childrenVOList = SmartBeanUtil.copyList(childrenEntityList, LocationTreeVO.class);
            childrenVOList.forEach(item -> {
                item.setLabel(item.getName());
                item.setValue(item.getId());
            });
            // 递归查询
            this.queryAndSetSubLocation(childrenVOList, allLocationEntityList);
            e.setChildren(childrenVOList);
        });
    }
}
