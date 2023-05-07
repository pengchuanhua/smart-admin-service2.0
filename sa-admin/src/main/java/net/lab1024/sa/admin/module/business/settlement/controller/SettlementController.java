package net.lab1024.sa.admin.module.business.settlement.controller;

import net.lab1024.sa.admin.module.business.settlement.domain.form.SettlementAddForm;
import net.lab1024.sa.admin.module.business.settlement.domain.form.SettlementQueryForm;
import net.lab1024.sa.admin.module.business.settlement.domain.form.SettlementUpdateForm;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.SettlementVO;
import net.lab1024.sa.admin.module.business.settlement.service.SettlementService;
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

/**
 * 结算主表 Controller
 *
 * @Author pengch
 * @Date 2023-05-04 18:16:11
 * @Copyright v1.0
 */

@RestController
@Api(tags = "")
public class SettlementController {

    @Autowired
    private SettlementService settlementService;

    @ApiOperation("分页查询 @author pengch")
    @PostMapping("/settlement/queryPage")
    public ResponseDTO<PageResult<SettlementVO>> queryPage(@RequestBody @Valid SettlementQueryForm queryForm) {
        return ResponseDTO.ok(settlementService.queryPage(queryForm));
    }

    @ApiOperation("添加 @author pengch")
    @PostMapping("/settlement/add")
    public ResponseDTO<String> add(@RequestBody @Valid SettlementAddForm addForm) {
        return settlementService.add(addForm);
    }

    @ApiOperation("更新 @author pengch")
    @PostMapping("/settlement/update")
    public ResponseDTO<String> update(@RequestBody @Valid SettlementUpdateForm updateForm) {
        return settlementService.update(updateForm);
    }

    @ApiOperation("批量删除 @author pengch")
    @PostMapping("/settlement/batchDelete")
    public ResponseDTO<String> batchDelete(@RequestBody ValidateList<Long> idList) {
        return settlementService.batchDelete(idList);
    }

    @ApiOperation("单个删除 @author pengch")
    @GetMapping("/settlement/delete/{settlementId}")
    public ResponseDTO<String> batchDelete(@PathVariable Long settlementId) {
        return settlementService.delete(settlementId);
    }
}
