package net.lab1024.sa.admin.module.business.quipment.dao;

import java.util.List;
import net.lab1024.sa.admin.module.business.quipment.domain.entity.QuipmentEntity;
import net.lab1024.sa.admin.module.business.quipment.domain.entity.UpdateQuipmentEntity;
import net.lab1024.sa.admin.module.business.quipment.domain.form.QuipmentQueryForm;
import net.lab1024.sa.admin.module.business.quipment.domain.vo.QuipmentLogVO;
import net.lab1024.sa.admin.module.business.quipment.domain.vo.QuipmentVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 设备信息 Dao
 *
 * @Author pengch
 * @Date 2023-04-28 18:56:09
 * @Copyright v1.0
 */

@Mapper
@Component
public interface QuipmentDao extends BaseMapper<QuipmentEntity> {

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<QuipmentVO> queryPage(Page page, @Param("queryForm") QuipmentQueryForm queryForm);

    int insertQuipment(QuipmentEntity quipmentEntity);

    int insertQuipmentLog(UpdateQuipmentEntity updateQuipmentEntity);

    int updateQuipmentById(QuipmentEntity quipmentEntity);

    UpdateQuipmentEntity selectQuipmentById(@Param("id") Long id);

    List<QuipmentLogVO>queryQuipmentLog(@Param("quipment_id")Long quipment_id);




}
