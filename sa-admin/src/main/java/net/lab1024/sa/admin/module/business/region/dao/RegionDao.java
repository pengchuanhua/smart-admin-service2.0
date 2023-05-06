package net.lab1024.sa.admin.module.business.region.dao;

import java.util.List;

import net.lab1024.sa.admin.module.business.category.domain.entity.CategoryEntity;
import net.lab1024.sa.admin.module.business.region.domain.entity.RegionEntity;
import net.lab1024.sa.admin.module.business.region.domain.form.RegionTreeQueryForm;
import net.lab1024.sa.admin.module.business.region.domain.vo.RegionVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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


    List<RegionEntity> queryByParentId(@Param("parentId") long parentId);

    int updateRegionById(RegionEntity regionEntity);



}
