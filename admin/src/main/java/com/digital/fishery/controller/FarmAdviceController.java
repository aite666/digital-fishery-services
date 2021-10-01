package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.FarmAdvice;
import com.digital.fishery.service.FarmAdviceService;
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
@Api(tags = "FarmAdviceController", description = "农事建议管理")
@RequestMapping("/advice")
public class FarmAdviceController {

    @Autowired
    private FarmAdviceService farmAdviceService;

    @ApiOperation("添加农事建议")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody FarmAdvice farmAdvice) {
        int count = farmAdviceService.create(farmAdvice);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改农事建议")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody FarmAdvice farmAdvice) {
        int count = farmAdviceService.update(id, farmAdvice);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取农事建议")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<FarmAdvice> getItem(@PathVariable Long id) {
        FarmAdvice farmAdvice = farmAdviceService.getItem(id);
        return CommonResult.success(farmAdvice);
    }

    @ApiOperation("根据ID删除农事建议")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = farmAdviceService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询农事建议")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<FarmAdvice>> list(@RequestParam(value = "name", required = false) String name,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<FarmAdvice> farmAdviceList = farmAdviceService.list(name, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(farmAdviceList));
    }
}
