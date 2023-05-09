package net.lab1024.sa.admin.module.business.brand.dao;

import java.util.List;

import net.lab1024.sa.admin.module.business.brand.domain.entity.BrandEntity;
import net.lab1024.sa.admin.module.business.brand.domain.form.BrandQueryForm;
import net.lab1024.sa.admin.module.business.brand.domain.vo.BrandVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 品牌 Dao
 *
 * @Author pengch
 * @Date 2023-04-27 17:16:42
 * @Copyright v1.0
 */

@Mapper
@Component
public interface BrandDao extends BaseMapper<BrandEntity> {

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<BrandVO> queryPage(Page page, @Param("queryForm") BrandQueryForm queryForm);

    int updateBrand(BrandEntity brandEntity);

    int insertBrand(BrandEntity brandEntity);


    List<BrandVO> queryBrand(@Param("queryForm") BrandQueryForm queryForm);


}
