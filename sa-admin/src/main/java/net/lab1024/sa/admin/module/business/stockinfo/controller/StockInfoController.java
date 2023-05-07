package net.lab1024.sa.admin.module.business.stockinfo.controller;

import net.lab1024.sa.admin.module.business.stockinfo.domain.form.StockInfoQueryForm;
import net.lab1024.sa.admin.module.business.stockinfo.domain.vo.StockInfoVO;
import net.lab1024.sa.admin.module.business.stockinfo.service.StockInfoService;
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
 * 商品库存 Controller
 *
 * @Author pengch
 * @Date 2023-04-28 18:42:05
 * @Copyright v1.0
 */

@RestController
@Api(tags = "")
public class StockInfoController {

    @Autowired
    private StockInfoService stockInfoService;

    @ApiOperation("分页查询 @author pengch")
    @PostMapping("/stockInfo/queryPage")
    public ResponseDTO<PageResult<StockInfoVO>> queryPage(@RequestBody @Valid StockInfoQueryForm queryForm) {
        return ResponseDTO.ok(stockInfoService.queryPage(queryForm));
    }


}
