package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.FarmInspection;
import com.digital.fishery.service.FarmInspectionService;
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
@Api(tags = "FarmInspectionController", description = "区试管理")
@RequestMapping("/inspection")
public class FarmInspectionController {

    @Autowired
    private FarmInspectionService farmInspectionService;

    @ApiOperation("添加区试")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody FarmInspection farmInspection) {
        int count = farmInspectionService.create(farmInspection);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改区试")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody FarmInspection farmInspection) {
        int count = farmInspectionService.update(id, farmInspection);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取区试")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<FarmInspection> getItem(@PathVariable Long id) {
        FarmInspection farmInspection = farmInspectionService.getItem(id);
        return CommonResult.success(farmInspection);
    }

    @ApiOperation("根据ID删除区试")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = farmInspectionService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询区试")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<FarmInspection>> list(@RequestParam(value = "blockId", required = false) Long blockId,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<FarmInspection> farmInspectionList = farmInspectionService.list(blockId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(farmInspectionList));
    }
}
