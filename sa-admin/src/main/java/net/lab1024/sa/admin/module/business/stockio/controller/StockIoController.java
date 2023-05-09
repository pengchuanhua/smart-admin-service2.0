package net.lab1024.sa.admin.module.business.stockio.controller;

import net.lab1024.sa.admin.module.business.stockio.domain.form.StockIoAddForm;
import net.lab1024.sa.admin.module.business.stockio.domain.form.StockIoQueryForm;
import net.lab1024.sa.admin.module.business.stockio.domain.form.StockIoUpdateForm;
import net.lab1024.sa.admin.module.business.stockio.domain.vo.StockIoVO;
import net.lab1024.sa.admin.module.business.stockio.service.StockIoService;
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
 * 商品出入库 Controller
 *
 * @Author pengch
 * @Date 2023-04-28 18:27:48
 * @Copyright v1.0
 */

@RestController
@Api(tags = "")
public class StockIoController {

    @Autowired
    private StockIoService stockIoService;

    @ApiOperation("分页查询 @author pengch")
    @PostMapping("/stockIo/queryPage")
    public ResponseDTO<PageResult<StockIoVO>> queryPage(@RequestBody @Valid StockIoQueryForm queryForm) {
        return ResponseDTO.ok(stockIoService.queryPage(queryForm));
    }

    @ApiOperation("添加 @author pengch")
    @PostMapping("/stockIo/add")
    public ResponseDTO<String> add(@RequestBody @Valid StockIoAddForm addForm) {
        return stockIoService.add(addForm);
    }


}
