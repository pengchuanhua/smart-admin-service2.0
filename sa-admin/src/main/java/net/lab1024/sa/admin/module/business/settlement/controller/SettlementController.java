package net.lab1024.sa.admin.module.business.settlement.controller;

import net.lab1024.sa.admin.module.business.settlement.domain.form.*;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.PaymentVO;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.QuerySalesVO;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.SettlementVO;
import net.lab1024.sa.admin.module.business.settlement.domain.vo.SettlementitemVO;
import net.lab1024.sa.admin.module.business.settlement.service.SettlementService;
import net.lab1024.sa.common.common.domain.ValidateList;
import net.lab1024.sa.common.module.support.serialnumber.constant.SerialNumberIdEnum;
import net.lab1024.sa.common.module.support.serialnumber.service.SerialNumberService;
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
 * 结算主表 Controller
 *
 * @Author pengch
 * @Date 2023-05-04 18:16:11
 * @Copyright v1.0
 */

@RestController
@Api(tags = "")
public class SettlementController {

    @Autowired
    private SettlementService settlementService;

    @Autowired
    private SerialNumberService serialNumberService;

    @ApiOperation("分页查询 @author pengch")
    @PostMapping("/settlement/queryPage")
    public ResponseDTO<PageResult<SettlementVO>> queryPage(@RequestBody @Valid SettlementQueryForm queryForm) {
        return ResponseDTO.ok(settlementService.queryPage(queryForm));
    }

    @ApiOperation("查询待结算明细 @author pengch")
    @PostMapping("/settlement/querySales")
    public ResponseDTO<PageResult<QuerySalesVO>>querySales(@RequestBody @Valid SalesQueryForm queryForm){
        return ResponseDTO.ok(settlementService.querySales(queryForm));
    }

    @ApiOperation("查结算明细详情 @author pengch")
    @PostMapping("/settlement/querySettlementitem")
    public ResponseDTO<List<SettlementitemVO>>querySettlementitem(@RequestBody @Valid SettlementitemQueryForm queryForm){
        return settlementService.querySettlementitem(queryForm);
    }

    @ApiOperation("查询付款方式")
    @PostMapping("/settlement/queryPayment")
    public ResponseDTO<List<PaymentVO>>queryPayment(){
        return settlementService.queryPayment();
    }

    @ApiOperation("添加 @author pengch")
    @PostMapping("/settlement/add")
    public ResponseDTO<String> add(@RequestBody @Valid SettlementAddForm addForm) {
        String settlementNo=serialNumberService.generate(SerialNumberIdEnum.SETTLEMENT);
        addForm.setSettlementNo(settlementNo);
        return settlementService.add(addForm);
    }

    @ApiOperation("审核 @author pengch")
    @PostMapping("/settlement/check")
    public ResponseDTO<String> update(@RequestBody @Valid SettlementUpdateForm updateForm) {
        return settlementService.update(updateForm);
    }

    @ApiOperation("单个删除 @author pengch")
    @GetMapping("/settlement/delete/{settlementNo}")
    public ResponseDTO<String> batchDelete(@PathVariable String settlementNo) {
        return settlementService.delete(settlementNo);
    }
}
