package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.FarmStorageRecord;
import com.digital.fishery.service.FarmStorageRecordService;
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
@Api(tags = "FarmStorageRecordController", description = "农资记录管理")
@RequestMapping("/storageRecord")
public class FarmStorageRecordController {

    @Autowired
    private FarmStorageRecordService farmStorageRecordService;

    @ApiOperation("添加农资记录")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody FarmStorageRecord farmStorageRecord) {
        int count = farmStorageRecordService.create(farmStorageRecord);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改农资记录")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody FarmStorageRecord farmStorageRecord) {
        int count = farmStorageRecordService.update(id, farmStorageRecord);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取农资记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<FarmStorageRecord> getItem(@PathVariable Long id) {
        FarmStorageRecord farmStorageRecord = farmStorageRecordService.getItem(id);
        return CommonResult.success(farmStorageRecord);
    }

    @ApiOperation("根据ID删除农资记录")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = farmStorageRecordService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询农资记录")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<FarmStorageRecord>> list(@RequestParam(value = "storageId", required = false) Long storageId,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<FarmStorageRecord> farmStorageRecordList = farmStorageRecordService.list(storageId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(farmStorageRecordList));
    }
}
