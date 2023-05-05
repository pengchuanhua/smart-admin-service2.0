package net.lab1024.sa.admin.module.business.path.controller;

import net.lab1024.sa.admin.module.business.path.domain.form.PathAddForm;
import net.lab1024.sa.admin.module.business.path.domain.form.PathQueryForm;
import net.lab1024.sa.admin.module.business.path.domain.form.PathUpdateForm;
import net.lab1024.sa.admin.module.business.path.domain.vo.PathVO;
import net.lab1024.sa.admin.module.business.path.service.PathService;
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
 * 设备路线 Controller
 *
 * @Author pengch
 * @Date 2023-04-27 17:39:58
 * @Copyright pengch
 */

@RestController
@Api(tags = "")
public class PathController {

    @Autowired
    private PathService pathService;

    @ApiOperation("分页查询 @author pengch")
    @PostMapping("/path/queryPage")
    public ResponseDTO<PageResult<PathVO>> queryPage(@RequestBody @Valid PathQueryForm queryForm) {
        return ResponseDTO.ok(pathService.queryPage(queryForm));
    }

    @ApiOperation("添加 @author pengch")
    @PostMapping("/path/add")
    public ResponseDTO<String> add(@RequestBody @Valid PathAddForm addForm) {
        return pathService.add(addForm);
    }

    @ApiOperation("更新 @author pengch")
    @PostMapping("/path/update")
    public ResponseDTO<String> update(@RequestBody @Valid PathUpdateForm updateForm) {
        return pathService.update(updateForm);
    }

    @ApiOperation("批量删除 @author pengch")
    @PostMapping("/path/batchDelete")
    public ResponseDTO<String> batchDelete(@RequestBody ValidateList<Long> idList) {
        return pathService.batchDelete(idList);
    }

    @ApiOperation("单个删除 @author pengch")
    @GetMapping("/path/delete/{pathId}")
    public ResponseDTO<String> batchDelete(@PathVariable Long pathId) {
        return pathService.delete(pathId);
    }
}
