package net.lab1024.sa.admin.module.business.region.dao;

import java.util.List;

import net.lab1024.sa.admin.module.business.region.domain.entity.RegionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 地区信息 Dao
 *
 * @Author pengch
 * @Date 2023-04-27 17:11:14
 * @Copyright v1.0
 */

@Mapper
@Component
public interface RegionDao extends BaseMapper<RegionEntity> {


    List<RegionEntity> queryByParentId(@Param("parentIdList") List<Long> parentIdList);

    int updateRegionById(RegionEntity regionEntity);

    int insertRegion(RegionEntity regionEntity);

    RegionEntity queryRegionById(@Param ("code") Long code);

    RegionEntity queryRegionByParenId(@Param ("parentCode") Long parentCode);

    List<RegionEntity> queryRegion();

    int deleteRegion(@Param ("code")Long code);




}
