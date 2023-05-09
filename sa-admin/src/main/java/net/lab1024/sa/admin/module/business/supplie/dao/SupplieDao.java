package net.lab1024.sa.admin.module.business.supplie.dao;

import java.util.List;

import net.lab1024.sa.admin.module.business.supplie.domain.entity.SupplieEntity;
import net.lab1024.sa.admin.module.business.supplie.domain.form.SupplieQueryForm;
import net.lab1024.sa.admin.module.business.supplie.domain.vo.SupplieVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 供应商 Dao
 *
 * @Author pengch
 * @Date 2023-04-27 17:15:30
 * @Copyright v1.0
 */

@Mapper
@Component
public interface SupplieDao extends BaseMapper<SupplieEntity> {

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<SupplieVO> queryPage(Page page, @Param("queryForm") SupplieQueryForm queryForm);

    int updateSupplie(SupplieEntity supplieEntity);

    int insertSupplie(SupplieEntity supplieEntity);

    List<SupplieVO> querySupplie(@Param("queryForm") SupplieQueryForm queryForm);



}
