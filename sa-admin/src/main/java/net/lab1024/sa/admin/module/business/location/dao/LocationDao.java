package net.lab1024.sa.admin.module.business.location.dao;

import java.util.List;
import net.lab1024.sa.admin.module.business.location.domain.entity.LocationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 位置信息 Dao
 *
 * @Author pengch
 * @Date 2023-05-06 12:04:10
 * @Copyright v1.0
 */

@Mapper
@Component
public interface LocationDao extends BaseMapper<LocationEntity> {

    List<LocationEntity> queryByParentId(@Param("parentIdList") List<Long> parentIdList);
    int updateLocationById(LocationEntity locationEntity);


    int insertLocation(LocationEntity locationEntity);

    LocationEntity queryLocationById(@Param("id") long id);

    LocationEntity queryLocationByParenId(@Param ("parentId") Long parentId);

    List<LocationEntity> queryLocation();




}
