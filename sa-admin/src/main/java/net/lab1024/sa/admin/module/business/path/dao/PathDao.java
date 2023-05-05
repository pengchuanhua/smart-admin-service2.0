package net.lab1024.sa.admin.module.business.path.dao;

import java.util.List;
import net.lab1024.sa.admin.module.business.path.domain.entity.PathEntity;
import net.lab1024.sa.admin.module.business.path.domain.form.PathQueryForm;
import net.lab1024.sa.admin.module.business.path.domain.vo.PathVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 设备路线 Dao
 *
 * @Author pengch
 * @Date 2023-04-27 17:39:58
 * @Copyright pengch
 */

@Mapper
@Component
public interface PathDao extends BaseMapper<PathEntity> {

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<PathVO> queryPage(Page page, @Param("queryForm") PathQueryForm queryForm);


}
