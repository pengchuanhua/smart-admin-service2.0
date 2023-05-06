package net.lab1024.sa.admin.module.business.location.manager;

import lombok.extern.slf4j.Slf4j;
import net.lab1024.sa.admin.module.business.location.domain.entity.LocationEntity;
import net.lab1024.sa.admin.module.business.location.dao.LocationDao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.lab1024.sa.admin.module.business.location.domain.vo.LocationTreeVO;
import net.lab1024.sa.admin.module.business.region.domain.entity.RegionEntity;
import net.lab1024.sa.admin.module.business.region.domain.vo.RegionTreeVO;
import net.lab1024.sa.common.common.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public LocationEntity queryLocation(Long code) {
        return locationDao.selectById(code);
    }

    public List<LocationTreeVO> queryLocationTree(Long parentId) {
        List<LocationEntity> allLocationEntityList = locationDao.queryByParentId(parentId);
        List<LocationEntity> locationEntityList = allLocationEntityList.stream().filter(e -> e.getParentCode().equals(parentId)).collect(Collectors.toList());
        List<LocationTreeVO> treeList = SmartBeanUtil.copyList(locationEntityList, LocationTreeVO.class);
        treeList.forEach(e -> {
            e.setLabel(e.getName());
            e.setValue(e.getCode());
        });
        // 递归设置子类
//        this.queryAndSetSubCategory(treeList, allRegionEntityList);
        return treeList;
    }
}
