package net.lab1024.sa.admin.module.business.quipment.controller;

import net.lab1024.sa.admin.module.business.brand.domain.form.BrandQueryForm;
import net.lab1024.sa.admin.module.business.brand.domain.vo.BrandVO;
import net.lab1024.sa.admin.module.business.quipment.domain.form.QuipmentAddForm;
import net.lab1024.sa.admin.module.business.quipment.domain.form.QuipmentQueryForm;
import net.lab1024.sa.admin.module.business.quipment.domain.form.QuipmentUpdateForm;
import net.lab1024.sa.admin.module.business.quipment.domain.vo.QuipmentLogVO;
import net.lab1024.sa.admin.module.business.quipment.domain.vo.QuipmentVO;
import net.lab1024.sa.admin.module.business.quipment.service.QuipmentService;
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
 * 设备信息 Controller
 *
 * @Author pengch
 * @Date 2023-04-28 18:56:09
 * @Copyright v1.0
 */

@RestController
@Api(tags = "")
public class QuipmentController {

    @Autowired
    private QuipmentService quipmentService;

    @ApiOperation("分页查询 @author pengch")
    @PostMapping("/quipment/queryPage")
    public ResponseDTO<PageResult<QuipmentVO>> queryPage(@RequestBody @Valid QuipmentQueryForm queryForm) {
        return ResponseDTO.ok(quipmentService.queryPage(queryForm));
    }

    @ApiOperation("查询设备修改记录")
    @GetMapping("/quipment/queryQuipmentLog/{quipmentId}")
    public ResponseDTO<List<QuipmentLogVO>>queryQuipmentLog(@PathVariable Long quipmentId){
        return quipmentService.queryQuipmentLog(quipmentId);
    }

    @ApiOperation("添加 @author pengch")
    @PostMapping("/quipment/add")
    public ResponseDTO<String> add(@RequestBody @Valid QuipmentAddForm addForm) {
        return quipmentService.add(addForm);
    }

    @ApiOperation("更新 @author pengch")
    @PostMapping("/quipment/update")
    public ResponseDTO<String> update(@RequestBody @Valid QuipmentUpdateForm updateForm) {
        return quipmentService.update(updateForm);
    }

    @ApiOperation("批量删除 @author pengch")
    @PostMapping("/quipment/batchDelete")
    public ResponseDTO<String> batchDelete(@RequestBody ValidateList<Long> idList) {
        return quipmentService.batchDelete(idList);
    }

    @ApiOperation("单个删除 @author pengch")
    @GetMapping("/quipment/delete/{quipmentId}")
    public ResponseDTO<String> batchDelete(@PathVariable Long quipmentId) {
        return quipmentService.delete(quipmentId);
    }
}
