package com.digital.fishery.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.FarmBatch;
import com.digital.fishery.service.FarmBatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

/**
 * Created by qianhan on 2021-09-19
 */
@Controller
@Api(tags = "FarmBatchController", description = "农事批次管理")
@RequestMapping("/batch")
public class FarmBatchController {

    @Autowired
    private FarmBatchService farmBatchService;

    @ApiOperation("添加农事批次")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody FarmBatch farmBatch) {
        int count = farmBatchService.create(farmBatch);
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
                               @RequestBody FarmBatch farmBatch) {
        int count = farmBatchService.update(id, farmBatch);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取农事批次")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<FarmBatch> getItem(@PathVariable Long id) {
        FarmBatch farmBatch = farmBatchService.getItem(id);
        return CommonResult.success(farmBatch);
    }

    @ApiOperation("根据ID删除农事批次")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = farmBatchService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询农事批次")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<FarmBatch>> list(@RequestParam(value = "name", required = false) String name,
                                                    @RequestParam(value = "blockId", required = false) Long blockId,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<FarmBatch> farmBatchList = farmBatchService.list(name, blockId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(farmBatchList));
    }

    @ApiOperation("根据区块id查询所有的养殖种类、批次数以及批次列表")
    @RequestMapping(value = "/listProductCategory", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listProductCategory(@RequestParam(value = "blockId", required = false) Long blockId) {
        List<JSONObject> farmBatchList = farmBatchService.listProductCategory(blockId);
        return CommonResult.success(farmBatchList);
    }
}
