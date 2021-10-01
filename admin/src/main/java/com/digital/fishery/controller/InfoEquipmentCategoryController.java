package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.InfoEquipmentCategory;
import com.digital.fishery.service.InfoEquipmentCategoryService;
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
@Api(tags = "InfoEquipmentCategoryController", description = "设备种类信息管理")
@RequestMapping("/equipmentCategory")
public class InfoEquipmentCategoryController {

    @Autowired
    private InfoEquipmentCategoryService infoEquipmentCategoryService;

    @ApiOperation("添加设备种类信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody InfoEquipmentCategory infoEquipmentCategory) {
        int count = infoEquipmentCategoryService.create(infoEquipmentCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改设备种类信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody InfoEquipmentCategory infoEquipmentCategory) {
        int count = infoEquipmentCategoryService.update(id, infoEquipmentCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取设备种类信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<InfoEquipmentCategory> getItem(@PathVariable Long id) {
        InfoEquipmentCategory infoEquipmentCategory = infoEquipmentCategoryService.getItem(id);
        return CommonResult.success(infoEquipmentCategory);
    }

    @ApiOperation("根据ID删除设备种类信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = infoEquipmentCategoryService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询设备种类信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<InfoEquipmentCategory>> list(@RequestParam(value = "name", required = false) String name,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<InfoEquipmentCategory> infoEquipmentCategoryList = infoEquipmentCategoryService.list(name, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(infoEquipmentCategoryList));
    }
}
