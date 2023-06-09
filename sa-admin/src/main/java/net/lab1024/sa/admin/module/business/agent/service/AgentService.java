package net.lab1024.sa.admin.module.business.agent.service;

import java.util.Date;
import java.util.List;

import net.lab1024.sa.admin.config.AuthenticationInfo;
import net.lab1024.sa.admin.module.business.agent.dao.AgentDao;
import net.lab1024.sa.admin.module.business.agent.domain.entity.AgentEntity;
import net.lab1024.sa.admin.module.business.agent.domain.form.AgentAddForm;
import net.lab1024.sa.admin.module.business.agent.domain.form.AgentQueryForm;
import net.lab1024.sa.admin.module.business.agent.domain.form.AgentUpdateForm;
import net.lab1024.sa.admin.module.business.agent.domain.vo.AgentVO;
import net.lab1024.sa.common.common.code.UserErrorCode;
import net.lab1024.sa.common.common.util.SmartBeanUtil;
import net.lab1024.sa.common.common.util.SmartPageUtil;
import net.lab1024.sa.common.common.domain.ResponseDTO;
import net.lab1024.sa.common.common.domain.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 代理商 Service
 *
 * @Author pengch
 * @Date 2023-04-27 17:11:22
 * @Copyright v1.0
 */

@Service
public class AgentService {

    @Autowired
    private AgentDao agentDao;

    @Resource
    private AuthenticationInfo authenticationInfo;

    /**
     * 分页查询
     *
     * @param queryForm
     * @return
     */
    public PageResult<AgentVO> queryPage(AgentQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<AgentVO> list = agentDao.queryPage(page, queryForm);
        PageResult<AgentVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    public ResponseDTO<List<AgentVO>> queryAgent(AgentQueryForm queryForm) {
        List<AgentVO> adminVO = agentDao.queryAgent(queryForm);
        if (adminVO==null) {
            return ResponseDTO.error(UserErrorCode.DATA_NOT_EXIST);
        }
        return ResponseDTO.ok(adminVO);
    }

    /**
     * 添加
     */
    public ResponseDTO<String> add(AgentAddForm addForm) {
        AgentEntity agentEntity = SmartBeanUtil.copy(addForm, AgentEntity.class);
        agentEntity.setCempName(authenticationInfo.getAuthentication().getName());
        agentEntity.setCtime(new Date());
        agentEntity.setTs01(System.currentTimeMillis());
        agentDao.insertAgent(agentEntity);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     *
     * @param updateForm
     * @return
     */
    public ResponseDTO<String> update(AgentUpdateForm updateForm) {
        AgentEntity agentEntity = SmartBeanUtil.copy(updateForm, AgentEntity.class);
        agentEntity.setUempName(authenticationInfo.getAuthentication().getName());
        agentEntity.setUtime(new Date());
        agentEntity.setNew_ts01(System.currentTimeMillis());
        int row = agentDao.updateAgent(agentEntity);
        if (row==0){
            throw new RuntimeException("数据已改变,请查询后再操作!");
        }
        return ResponseDTO.ok();
    }

    /**
     * 批量删除
     *
     * @param idList
     * @return
     */
    public ResponseDTO<String> batchDelete(List<Long> idList) {
        if (CollectionUtils.isEmpty(idList)){
            return ResponseDTO.ok();
        }

        agentDao.deleteBatchIds(idList);
        return ResponseDTO.ok();
    }

    /**
     * 单个删除
     */
    public ResponseDTO<String> delete(Long id) {
        if (null == id){
            return ResponseDTO.ok();
        }

        agentDao.deleteById(id);
        return ResponseDTO.ok();
    }
}
