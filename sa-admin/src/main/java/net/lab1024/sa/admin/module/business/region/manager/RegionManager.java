package net.lab1024.sa.admin.module.business.region.manager;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import net.lab1024.sa.admin.constant.AdminCacheConst;
import net.lab1024.sa.admin.module.business.region.domain.entity.RegionEntity;
import net.lab1024.sa.admin.module.business.region.dao.RegionDao;

import net.lab1024.sa.admin.module.business.region.domain.vo.RegionTreeVO;
import net.lab1024.sa.common.common.constant.StringConst;
import net.lab1024.sa.common.common.util.SmartBeanUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

    @CacheEvict(value = {AdminCacheConst.REGION.REGION_ENTITY, AdminCacheConst.REGION.REGION_SUB, AdminCacheConst.REGION.REGION_TREE}, allEntries = true)
    public void removeCache() {
        log.info("clear REGION ,REGION_SUB ,REGION_TREE");
    }


    @Cacheable(AdminCacheConst.REGION.REGION_ENTITY)
    public RegionEntity queryRegionByCode(Long code) {
        return regionDao.queryRegionById(code);
    }

    @Cacheable(AdminCacheConst.REGION.REGION_ENTITY)
    public List<RegionEntity> querySubRegion(Long ParentId) {
        return regionDao.queryByParentId(Lists.newArrayList(ParentId));
    }
    @Cacheable(AdminCacheConst.REGION.REGION_ENTITY)
    public List<RegionTreeVO> queryRegionTree(Long parentId) {
        List<RegionEntity> allRegionEntityList = regionDao.queryRegion();
        List<RegionEntity> regionEntityList = allRegionEntityList.stream().filter(e -> e.getParentCode().equals(parentId)).collect(Collectors.toList());
        List<RegionTreeVO> treeList = SmartBeanUtil.copyList(regionEntityList, RegionTreeVO.class);
        treeList.forEach(e -> {
            e.setLabel(e.getName());
            e.setValue(e.getCode());
            e.setFullName(e.getFullName());
        });
        // 递归设置子类
        this.queryAndSetSubRegion(treeList, allRegionEntityList);
        return treeList;
    }

    private void queryAndSetSubRegion(List<RegionTreeVO> treeList, List<RegionEntity> allRegionEntityList) {
        if (CollectionUtils.isEmpty(treeList)) {
            return;
        }
        List<Long> parentIdList =treeList.stream().map(RegionTreeVO::getValue).collect(Collectors.toList());
        List<RegionEntity> regionEntityList = allRegionEntityList.stream().filter(e -> parentIdList.contains(e.getParentCode())).collect(Collectors.toList());
        Map<Long, List<RegionEntity>> RegionSubMap = regionEntityList.stream().collect(Collectors.groupingBy(RegionEntity::getParentCode));
        treeList.forEach(e -> {
            List<RegionEntity> childrenEntityList = RegionSubMap.getOrDefault(e.getValue(), Lists.newArrayList());
            List<RegionTreeVO> childrenVOList = SmartBeanUtil.copyList(childrenEntityList, RegionTreeVO.class);
            childrenVOList.forEach(item -> {
                item.setLabel(item.getName());
                item.setValue(item.getCode());
                item.setFullName(e.getFullName() + StringConst.SEPARATOR_SLASH + item.getName());
            });
            // 递归查询
            this.queryAndSetSubRegion(childrenVOList, allRegionEntityList);
            e.setChildren(childrenVOList);
        });
    }

}
