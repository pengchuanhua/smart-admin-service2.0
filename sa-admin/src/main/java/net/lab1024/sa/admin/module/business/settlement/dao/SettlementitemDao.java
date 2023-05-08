package net.lab1024.sa.admin.module.business.settlement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.sa.admin.module.business.settlement.domain.entity.SettlementEntity;
import net.lab1024.sa.admin.module.business.settlement.domain.entity.SettlementitemEntity;
import net.lab1024.sa.admin.module.business.settlement.domain.form.SettlementQueryForm;
import net.lab1024.sa.admin.module.business.settlement.domain.form.SettlementitemQueryForm;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.SettlementVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 结算主表 Dao
 *
 * @Author pengch
 * @Date 2023-05-04 18:16:11
 * @Copyright v1.0
 */

@Mapper
@Component
public interface SettlementitemDao extends BaseMapper<SettlementitemEntity> {


}
