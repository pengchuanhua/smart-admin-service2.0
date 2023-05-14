package net.lab1024.sa.admin.module.business.sales.controller;

import net.lab1024.sa.admin.module.business.sales.domain.form.*;
import net.lab1024.sa.admin.module.business.sales.domain.vo.*;
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

    @ApiOperation("分页查询-销售明细分析 @author pengch")
    @PostMapping("/querySales/queryPage")
    public ResponseDTO<PageResult<SalesQueryVO>> querySales(@RequestBody @Valid SalesQueryForm queryForm) {
        return ResponseDTO.ok(salesService.queryPage(queryForm));
    }

    @ApiOperation("分页查询-代理商销售分析 @author pengch")
    @PostMapping("/querySalesbyAgent/queryPage")
    public ResponseDTO<PageResult<SalesQueryAgentVO>> querySalesbyAgent(@RequestBody @Valid SalesQueryAgentForm queryForm) {
        return ResponseDTO.ok(salesService.queryPage(queryForm));
    }
    @ApiOperation("分页查询-品类品牌销售分析 @author pengch")
    @PostMapping("/querySalesbyBrandAndCategory/queryPage")
    public ResponseDTO<PageResult<SalesQueryBrandAndCategoryVO>> querySalesbyBrandAndCategory(@RequestBody @Valid SalesQueryBrandAndCategoryForm queryForm) {
        return ResponseDTO.ok(salesService.queryPage(queryForm));
    }

    @ApiOperation("分页查询-商品销售分析 @author pengch")
    @PostMapping("/querySalesbyGoods/queryPage")
    public ResponseDTO<PageResult<SalesQueryGoodsVO>> querySalesbyGoods(@RequestBody @Valid SalesQueryGoodsForm queryForm) {
        return ResponseDTO.ok(salesService.queryPage(queryForm));
    }

    @ApiOperation("分页查询-场所销售分析 @author pengch")
    @PostMapping("/querySalesbyLocation/queryPage")
    public ResponseDTO<PageResult<SalesQueryLocationVO>> querySalesbyLocation(@RequestBody @Valid SalesQueryLocationForm queryForm) {
        return ResponseDTO.ok(salesService.queryPage(queryForm));
    }

    @ApiOperation("分页查询-设备实时销售 @author pengch")
    @PostMapping("/querySalesbyQuipment/queryPage")
    public ResponseDTO<PageResult<SalesQueryQuipmentVO>> querySalesbyQuipment(@RequestBody @Valid SalesQueryQuipmentForm queryForm) {
        return ResponseDTO.ok(salesService.queryPage(queryForm));
    }

    @ApiOperation("分页查询-销售退货明细 @author pengch")
    @PostMapping("/querySalesRef/queryPage")
    public ResponseDTO<PageResult<SalesRefQueryVO>> queryPage(@RequestBody @Valid SalesRefQueryForm queryForm) {
        return ResponseDTO.ok(salesService.queryPage(queryForm));
    }

}
