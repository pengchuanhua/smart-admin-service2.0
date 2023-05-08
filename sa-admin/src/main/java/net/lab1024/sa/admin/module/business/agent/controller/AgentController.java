package net.lab1024.sa.admin.module.business.agent.controller;

import net.lab1024.sa.admin.module.business.agent.domain.form.AgentAddForm;
import net.lab1024.sa.admin.module.business.agent.domain.form.AgentQueryForm;
import net.lab1024.sa.admin.module.business.agent.domain.form.AgentUpdateForm;
import net.lab1024.sa.admin.module.business.agent.domain.vo.AgentVO;
import net.lab1024.sa.admin.module.business.agent.service.AgentService;
import net.lab1024.sa.admin.module.business.settlement.domain.form.SettlementQueryForm;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.QuerySalesVO;
import net.lab1024.sa.common.common.domain.ValidateList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import net.lab1024.sa.common.common.domain.ResponseDTO;
import net.lab1024.sa.common.common.domain.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import java.util.List;

/**
 * 代理商 Controller
 *
 * @Author pengch
 * @Date 2023-04-27 17:11:22
 * @Copyright v1.0
 */

@RestController
@Api(tags = "")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @ApiOperation("分页查询 @author pengch")
    @PostMapping("/agent/queryPage")
    public ResponseDTO<PageResult<AgentVO>> queryPage(@RequestBody @Valid AgentQueryForm queryForm) {
        return ResponseDTO.ok(agentService.queryPage(queryForm));
    }

    @ApiOperation("查询代理商")
    @PostMapping("/settlement/queryAgent")
    public ResponseDTO<List<AgentVO>>queryAgent(@RequestBody @Valid AgentQueryForm queryForm){
        return agentService.queryAgent(queryForm);
    }

    @ApiOperation("添加 @author pengch")
    @PostMapping("/agent/add")
    public ResponseDTO<String> add(@RequestBody @Valid AgentAddForm addForm) {
        return agentService.add(addForm);
    }

    @ApiOperation("更新 @author pengch")
    @PostMapping("/agent/update")
    public ResponseDTO<String> update(@RequestBody @Valid AgentUpdateForm updateForm) {
        return agentService.update(updateForm);
    }

    @ApiOperation("批量删除 @author pengch")
    @PostMapping("/agent/batchDelete")
    public ResponseDTO<String> batchDelete(@RequestBody ValidateList<Long> idList) {
        return agentService.batchDelete(idList);
    }

    @ApiOperation("单个删除 @author pengch")
    @GetMapping("/agent/delete/{agentId}")
    public ResponseDTO<String> batchDelete(@PathVariable Long agentId) {
        return agentService.delete(agentId);
    }
}
