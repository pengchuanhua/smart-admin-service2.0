package net.lab1024.sa.admin.module.business.sales.controller;

import net.lab1024.sa.admin.module.business.sales.domain.form.SalesQueryForm;
import net.lab1024.sa.admin.module.business.sales.domain.vo.SalesVO;
import net.lab1024.sa.admin.module.business.sales.service.SalesService;
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
 * 设备销售表 Controller
 *
 * @Author pengch
 * @Date 2023-04-29 19:56:46
 * @Copyright v1.0
 */

@RestController
@Api(tags = "")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @ApiOperation("分页查询 @author pengch")
    @PostMapping("/sales/queryPage")
    public ResponseDTO<PageResult<SalesVO>> queryPage(@RequestBody @Valid SalesQueryForm queryForm) {
        return ResponseDTO.ok(salesService.queryPage(queryForm));
    }


}
