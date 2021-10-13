package com.digital.fishery.controller;

import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.FarmBatchOut;
import com.digital.fishery.service.FarmBatchOutService;
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
@Api(tags = "FarmBatchOutController", description = "农事批次管理")
@RequestMapping("/batchOut")
public class FarmBatchOutController {

    @Autowired
    private FarmBatchOutService farmBatchOutService;

    @ApiOperation("添加农事批次")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody FarmBatchOut farmBatchOut) {
        int count = farmBatchOutService.create(farmBatchOut);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改农事批次")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody FarmBatchOut farmBatchOut) {
        int count = farmBatchOutService.update(id, farmBatchOut);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取农事批次")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<FarmBatchOut> getItem(@PathVariable Long id) {
        FarmBatchOut farmBatchOut = farmBatchOutService.getItem(id);
        return CommonResult.success(farmBatchOut);
    }

    @ApiOperation("根据ID删除农事批次")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = farmBatchOutService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询农事批次")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<FarmBatchOut>> list(@RequestParam(value = "name", required = false) String name,
                                                       @RequestParam(value = "blockId", required = false) Long blockId,
                                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<FarmBatchOut> farmBatchOutList = farmBatchOutService.list(name, blockId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(farmBatchOutList));
    }

    @ApiOperation("查询农事批次数量")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult count(@RequestParam(value = "name", required = false) String name,
                                                       @RequestParam(value = "blockId", required = false) Long blockId) {
        long result = farmBatchOutService.count(name, blockId);
        return CommonResult.success(result);
    }
}
