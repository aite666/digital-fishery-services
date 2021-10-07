package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.FarmStorage;
import com.digital.fishery.service.FarmStorageService;
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
@Api(tags = "FarmStorageController", description = "农资管理")
@RequestMapping("/storage")
public class FarmStorageController {

    @Autowired
    private FarmStorageService farmStorageService;

    @ApiOperation("添加农资")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody FarmStorage farmStorage) {
        int count = farmStorageService.create(farmStorage);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改农资")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody FarmStorage farmStorage) {
        int count = farmStorageService.update(id, farmStorage);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取农资")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<FarmStorage> getItem(@PathVariable Long id) {
        FarmStorage farmStorage = farmStorageService.getItem(id);
        return CommonResult.success(farmStorage);
    }

    @ApiOperation("根据ID删除农资")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = farmStorageService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询农资")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<FarmStorage>> list(@RequestParam(value = "name", required = false) String name,
                                                      @RequestParam(value = "productCategoryId", required = false) Long productCategoryId,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<FarmStorage> farmStorageList = farmStorageService.list(name, productCategoryId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(farmStorageList));
    }
}
