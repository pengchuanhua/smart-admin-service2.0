package net.lab1024.sa.admin.module.business.supplie.controller;

import net.lab1024.sa.admin.module.business.brand.domain.form.BrandQueryForm;
import net.lab1024.sa.admin.module.business.brand.domain.vo.BrandVO;
import net.lab1024.sa.admin.module.business.supplie.domain.form.SupplieAddForm;
import net.lab1024.sa.admin.module.business.supplie.domain.form.SupplieQueryForm;
import net.lab1024.sa.admin.module.business.supplie.domain.form.SupplieUpdateForm;
import net.lab1024.sa.admin.module.business.supplie.domain.vo.SupplieVO;
import net.lab1024.sa.admin.module.business.supplie.service.SupplieService;
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
 * 供应商 Controller
 *
 * @Author pengch
 * @Date 2023-04-27 17:15:30
 * @Copyright v1.0
 */

@RestController
@Api(tags = "")
public class SupplieController {

    @Autowired
    private SupplieService supplieService;

    @ApiOperation("分页查询 @author pengch")
    @PostMapping("/supplie/queryPage")
    public ResponseDTO<PageResult<SupplieVO>> queryPage(@RequestBody @Valid SupplieQueryForm queryForm) {
        return ResponseDTO.ok(supplieService.queryPage(queryForm));
    }

    @ApiOperation("查询供应商信息")
    @PostMapping("/supplie/querySupplie")
    public ResponseDTO<List<SupplieVO>>querySupplie(@RequestBody @Valid SupplieQueryForm queryForm){
        return supplieService.querySupplie(queryForm);
    }

    @ApiOperation("添加 @author pengch")
    @PostMapping("/supplie/add")
    public ResponseDTO<String> add(@RequestBody @Valid SupplieAddForm addForm) {
        return supplieService.add(addForm);
    }

    @ApiOperation("更新 @author pengch")
    @PostMapping("/supplie/update")
    public ResponseDTO<String> update(@RequestBody @Valid SupplieUpdateForm updateForm) {
        return supplieService.update(updateForm);
    }

    @ApiOperation("批量删除 @author pengch")
    @PostMapping("/supplie/batchDelete")
    public ResponseDTO<String> batchDelete(@RequestBody ValidateList<Long> idList) {
        return supplieService.batchDelete(idList);
    }

    @ApiOperation("单个删除 @author pengch")
    @GetMapping("/supplie/delete/{supplieId}")
    public ResponseDTO<String> batchDelete(@PathVariable Long supplieId) {
        return supplieService.delete(supplieId);
    }
}
