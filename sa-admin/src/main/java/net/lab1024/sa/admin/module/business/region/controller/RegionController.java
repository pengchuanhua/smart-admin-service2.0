package net.lab1024.sa.admin.module.business.region.controller;

import net.lab1024.sa.admin.module.business.category.domain.form.CategoryTreeQueryForm;
import net.lab1024.sa.admin.module.business.region.domain.form.RegionAddForm;
import net.lab1024.sa.admin.module.business.region.domain.form.RegionTreeQueryForm;
import net.lab1024.sa.admin.module.business.region.domain.form.RegionUpdateForm;
import net.lab1024.sa.admin.module.business.region.domain.vo.RegionTreeVO;
import net.lab1024.sa.admin.module.business.region.domain.vo.RegionVO;
import net.lab1024.sa.admin.module.business.region.service.RegionService;
import net.lab1024.sa.common.common.domain.ValidateList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import net.lab1024.sa.common.common.domain.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import java.util.List;

/**
 * 地区信息 Controller
 *
 * @Author pengch
 * @Date 2023-04-27 17:11:14
 * @Copyright v1.0
 */

@RestController
@Api(tags = "")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @ApiOperation("查询详情 @author pengch")
    @GetMapping("/region/{code}")
    public ResponseDTO<RegionVO> queryDetail(@PathVariable Long code) {
        return regionService.queryDetail(code);
    }

    @ApiOperation("查询层级树 @author pengch")
    @PostMapping("/region/tree")
    public ResponseDTO<List<RegionTreeVO>> queryTree(@RequestBody @Valid RegionTreeQueryForm queryForm) {
        return regionService.queryTree(queryForm);
    }

    @ApiOperation("添加 @author pengch")
    @PostMapping("/region/add")
    public ResponseDTO<String> add(@RequestBody @Valid RegionAddForm addForm) {
        return regionService.add(addForm);
    }

    @ApiOperation("更新 @author pengch")
    @PostMapping("/region/update")
    public ResponseDTO<String> update(@RequestBody @Valid RegionUpdateForm updateForm) {
        return regionService.update(updateForm);
    }

    @ApiOperation("批量删除 @author pengch")
    @PostMapping("/region/batchDelete")
    public ResponseDTO<String> batchDelete(@RequestBody ValidateList<String> idList) {
        return regionService.batchDelete(idList);
    }

    @ApiOperation("单个删除 @author pengch")
    @GetMapping("/region/delete/{regionId}")
    public ResponseDTO<String> batchDelete(@PathVariable String regionId) {
        return regionService.delete(regionId);
    }
}
