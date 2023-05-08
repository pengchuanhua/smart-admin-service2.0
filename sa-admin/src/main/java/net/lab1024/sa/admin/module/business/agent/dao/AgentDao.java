package net.lab1024.sa.admin.module.business.agent.dao;

import java.util.List;
import net.lab1024.sa.admin.module.business.agent.domain.entity.AgentEntity;
import net.lab1024.sa.admin.module.business.agent.domain.form.AgentQueryForm;
import net.lab1024.sa.admin.module.business.agent.domain.vo.AgentVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.sa.admin.module.business.settlement.domain.form.SettlementQueryForm;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.QuerySalesVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 代理商 Dao
 *
 * @Author pengch
 * @Date 2023-04-27 17:11:22
 * @Copyright v1.0
 */

@Mapper
@Component
public interface AgentDao extends BaseMapper<AgentEntity> {

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<AgentVO> queryPage(Page page, @Param("queryForm") AgentQueryForm queryForm);

    int insertAgent(AgentEntity agentEntity);

    int updateAgent(AgentEntity agentEntity);

    List<AgentVO> queryAgent(@Param("queryForm") AgentQueryForm queryForm);


}
