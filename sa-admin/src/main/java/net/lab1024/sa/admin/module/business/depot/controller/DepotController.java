package net.lab1024.sa.admin.module.business.depot.controller;

import net.lab1024.sa.admin.module.business.depot.domain.form.DepotAddForm;
import net.lab1024.sa.admin.module.business.depot.domain.form.DepotQueryForm;
import net.lab1024.sa.admin.module.business.depot.domain.form.DepotUpdateForm;
import net.lab1024.sa.admin.module.business.depot.domain.form.SelectDepotQueryForm;
import net.lab1024.sa.admin.module.business.depot.domain.vo.DepotVO;
import net.lab1024.sa.admin.module.business.depot.service.DepotService;
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
 * 仓库信息 Controller
 *
 * @Author pengch
 * @Date 2023-04-27 17:13:39
 * @Copyright v1.0
 */

@RestController
@Api(tags = "")
public class DepotController {

    @Autowired
    private DepotService depotService;

    @ApiOperation("分页查询 @author pengch")
    @PostMapping("/depot/queryPage")
    public ResponseDTO<PageResult<DepotVO>> queryPage(@RequestBody @Valid DepotQueryForm queryForm) {
        return ResponseDTO.ok(depotService.queryPage(queryForm));
    }

    @ApiOperation("查询仓库信息")
    @PostMapping("/depot/queryDepot")
    public ResponseDTO<List<DepotVO>>queryDepot(@RequestBody @Valid SelectDepotQueryForm queryForm){
        return depotService.queryDepot(queryForm);
    }

    @ApiOperation("添加 @author pengch")
    @PostMapping("/depot/add")
    public ResponseDTO<String> add(@RequestBody @Valid DepotAddForm addForm) {
        return depotService.add(addForm);
    }

    @ApiOperation("更新 @author pengch")
    @PostMapping("/depot/update")
    public ResponseDTO<String> update(@RequestBody @Valid DepotUpdateForm updateForm) {
        return depotService.update(updateForm);
    }

    @ApiOperation("批量删除 @author pengch")
    @PostMapping("/depot/batchDelete")
    public ResponseDTO<String> batchDelete(@RequestBody ValidateList<Long> idList) {
        return depotService.batchDelete(idList);
    }

    @ApiOperation("单个删除 @author pengch")
    @GetMapping("/depot/delete/{depotId}")
    public ResponseDTO<String> batchDelete(@PathVariable Long depotId) {
        return depotService.delete(depotId);
    }
}
