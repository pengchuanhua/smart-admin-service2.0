package net.lab1024.sa.admin.module.business.location.dao;

import java.util.List;
import net.lab1024.sa.admin.module.business.location.domain.entity.LocationEntity;
import net.lab1024.sa.admin.module.business.location.domain.form.LocationTreeQueryForm;
import net.lab1024.sa.admin.module.business.location.domain.vo.LocationVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.sa.admin.module.business.region.domain.entity.RegionEntity;
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

    List<LocationEntity> queryByParentId(@Param("parentId") long parentId);
    int updateLocationById(LocationEntity locationEntity);

    LocationEntity queryLocationById(@Param("code") long code);



}
