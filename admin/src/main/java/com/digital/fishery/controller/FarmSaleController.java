package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.FarmSale;
import com.digital.fishery.service.FarmSaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by qianhan on 2021-09-19
 */
@Controller
@Api(tags = "FarmSaleController", description = "销售管理")
@RequestMapping("/sale")
public class FarmSaleController {

    @Autowired
    private FarmSaleService farmSaleService;

    @ApiOperation("添加销售")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody FarmSale farmSale) {
        int count = farmSaleService.create(farmSale);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改销售")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody FarmSale farmSale) {
        int count = farmSaleService.update(id, farmSale);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取销售")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<FarmSale> getItem(@PathVariable Long id) {
        FarmSale farmSale = farmSaleService.getItem(id);
        return CommonResult.success(farmSale);
    }

    @ApiOperation("根据ID删除销售")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = farmSaleService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询销售")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<FarmSale>> list(@RequestParam(value = "blockId", required = false) Long blockId,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<FarmSale> farmSaleList = farmSaleService.list(blockId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(farmSaleList));
    }
}
