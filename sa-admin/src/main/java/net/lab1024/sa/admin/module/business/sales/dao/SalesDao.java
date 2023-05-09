package net.lab1024.sa.admin.module.business.sales.dao;

import java.util.List;
import net.lab1024.sa.admin.module.business.sales.domain.entity.SalesEntity;
import net.lab1024.sa.admin.module.business.sales.domain.form.SalesQueryForm;
import net.lab1024.sa.admin.module.business.sales.domain.vo.SalesVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 设备销售表 Dao
 *
 * @Author pengch
 * @Date 2023-04-29 19:56:46
 * @Copyright v1.0
 */

@Mapper
@Component
public interface SalesDao extends BaseMapper<SalesEntity> {

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<SalesVO> queryPage(Page page, @Param("queryForm") SalesQueryForm queryForm);

    SalesEntity querySalesById(@Param ("id") long id);


}
