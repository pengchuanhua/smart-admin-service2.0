package net.lab1024.sa.admin.module.business.brand.controller;

import net.lab1024.sa.admin.module.business.brand.domain.form.BrandAddForm;
import net.lab1024.sa.admin.module.business.brand.domain.form.BrandQueryForm;
import net.lab1024.sa.admin.module.business.brand.domain.form.BrandUpdateForm;
import net.lab1024.sa.admin.module.business.brand.domain.form.SelectBrandQueryForm;
import net.lab1024.sa.admin.module.business.brand.domain.vo.BrandVO;
import net.lab1024.sa.admin.module.business.brand.service.BrandService;
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
 * 品牌 Controller
 *
 * @Author pengch
 * @Date 2023-04-27 17:16:42
 * @Copyright v1.0
 */

@RestController
@Api(tags = "")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @ApiOperation("分页查询 @author pengch")
    @PostMapping("/brand/queryPage")
    public ResponseDTO<PageResult<BrandVO>> queryPage(@RequestBody @Valid BrandQueryForm queryForm) {
        return ResponseDTO.ok(brandService.queryPage(queryForm));
    }

    @ApiOperation("查询品牌信息")
    @PostMapping("/brand/queryBrand")
    public ResponseDTO<List<BrandVO>>queryBrand(@RequestBody @Valid SelectBrandQueryForm queryForm){
        return brandService.queryBrand(queryForm);
    }

    @ApiOperation("添加 @author pengch")
    @PostMapping("/brand/add")
    public ResponseDTO<String> add(@RequestBody @Valid BrandAddForm addForm) {
        return brandService.add(addForm);
    }

    @ApiOperation("更新 @author pengch")
    @PostMapping("/brand/update")
    public ResponseDTO<String> update(@RequestBody @Valid BrandUpdateForm updateForm) {
        return brandService.update(updateForm);
    }

    @ApiOperation("批量删除 @author pengch")
    @PostMapping("/brand/batchDelete")
    public ResponseDTO<String> batchDelete(@RequestBody ValidateList<Long> idList) {
        return brandService.batchDelete(idList);
    }

    @ApiOperation("单个删除 @author pengch")
    @GetMapping("/brand/delete/{brandId}")
    public ResponseDTO<String> batchDelete(@PathVariable Long brandId) {
        return brandService.delete(brandId);
    }
}
