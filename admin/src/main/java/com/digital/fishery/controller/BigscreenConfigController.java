package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.BigscreenConfig;
import com.digital.fishery.service.BigscreenConfigService;
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
@Api(tags = "BigscreenConfigController", description = "大屏配置管理")
@RequestMapping("/bigscreen")
public class BigscreenConfigController {

    @Autowired
    private BigscreenConfigService bigscreenConfigService;

    @ApiOperation("添加大屏配置")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody BigscreenConfig bigscreenConfig) {
        int count = bigscreenConfigService.create(bigscreenConfig);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改大屏配置")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody BigscreenConfig bigscreenConfig) {
        int count = bigscreenConfigService.update(id, bigscreenConfig);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("通过名称修改大屏配置")
    @RequestMapping(value = "/updateByName/{name}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateByName(@PathVariable String name,
                               @RequestBody BigscreenConfig bigscreenConfig) {
        int count = bigscreenConfigService.updateByName(name, bigscreenConfig);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取大屏配置")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<BigscreenConfig> getItem(@PathVariable Long id) {
        BigscreenConfig bigscreenConfig = bigscreenConfigService.getItem(id);
        return CommonResult.success(bigscreenConfig);
    }

    @ApiOperation("根据ID删除大屏配置")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = bigscreenConfigService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询大屏配置")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<BigscreenConfig>> list(@RequestParam(value = "name", required = false) String name,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BigscreenConfig> bigscreenConfigList = bigscreenConfigService.list(name, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(bigscreenConfigList));
    }
}
