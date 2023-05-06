package net.lab1024.sa.admin.module.business.region.manager;

import lombok.extern.slf4j.Slf4j;
import net.lab1024.sa.admin.module.business.category.domain.entity.CategoryEntity;
import net.lab1024.sa.admin.module.business.category.domain.vo.CategoryTreeVO;
import net.lab1024.sa.admin.module.business.region.domain.entity.RegionEntity;
import net.lab1024.sa.admin.module.business.region.dao.RegionDao;

import net.lab1024.sa.admin.module.business.region.domain.vo.RegionTreeVO;
import net.lab1024.sa.common.common.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 地区信息  Manager
 *
 * @Author pengch
 * @Date 2023-04-27 17:11:14
 * @Copyright v1.0
 */
@Service
@Slf4j
public class RegionManager{

    @Autowired
    private RegionDao regionDao;

    public RegionEntity queryRegion(Long code) {
        return regionDao.selectById(code);
    }

    public List<RegionTreeVO> queryRegionTree(Long parentId) {
        List<RegionEntity> allRegionEntityList = regionDao.queryByParentId(parentId);
        List<RegionEntity> regionEntityList = allRegionEntityList.stream().filter(e -> e.getParentCode().equals(parentId)).collect(Collectors.toList());
        List<RegionTreeVO> treeList = SmartBeanUtil.copyList(regionEntityList, RegionTreeVO.class);
        treeList.forEach(e -> {
            e.setLabel(e.getName());
            e.setValue(e.getCode());
            e.setFullName(e.getFullName());
        });
        // 递归设置子类
//        this.queryAndSetSubCategory(treeList, allRegionEntityList);
        return treeList;
    }

}
