package net.lab1024.sa.admin.module.business.location.controller;

import net.lab1024.sa.admin.module.business.location.domain.form.LocationAddForm;
import net.lab1024.sa.admin.module.business.location.domain.form.LocationTreeQueryForm;
import net.lab1024.sa.admin.module.business.location.domain.form.LocationUpdateForm;
import net.lab1024.sa.admin.module.business.location.domain.vo.LocationTreeVO;
import net.lab1024.sa.admin.module.business.location.domain.vo.LocationVO;
import net.lab1024.sa.admin.module.business.location.service.LocationService;
import net.lab1024.sa.admin.module.business.region.domain.form.RegionTreeQueryForm;
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
 * 位置信息 Controller
 *
 * @Author pengch
 * @Date 2023-05-06 12:04:10
 * @Copyright v1.0
 */

@RestController
@Api(tags = "")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @ApiOperation("查询详情 @author pengch")
    @GetMapping("/location/{code}")
    public ResponseDTO<LocationVO> queryDetail(@PathVariable Long id) {
        return locationService.queryDetail(id);
    }

    @ApiOperation("查询层级树 @author pengch")
    @PostMapping("/location/tree")
    public ResponseDTO<List<LocationTreeVO>> queryTree(@RequestBody @Valid LocationTreeQueryForm queryForm) {
        return locationService.queryTree(queryForm);
    }

    @ApiOperation("添加 @author pengch")
    @PostMapping("/location/add")
    public ResponseDTO<String> add(@RequestBody @Valid LocationAddForm addForm) {
        return locationService.add(addForm);
    }

    @ApiOperation("更新 @author pengch")
    @PostMapping("/location/update")
    public ResponseDTO<String> update(@RequestBody @Valid LocationUpdateForm updateForm) {
        return locationService.update(updateForm);
    }

    @ApiOperation("批量删除 @author pengch")
    @PostMapping("/location/batchDelete")
    public ResponseDTO<String> batchDelete(@RequestBody ValidateList<Long> idList) {
        return locationService.batchDelete(idList);
    }

    @ApiOperation("单个删除 @author pengch")
    @GetMapping("/location/delete/{locationId}")
    public ResponseDTO<String> batchDelete(@PathVariable Long locationId) {
        return locationService.delete(locationId);
    }
}
