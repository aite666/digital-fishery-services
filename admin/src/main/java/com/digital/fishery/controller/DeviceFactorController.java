package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.DeviceFactor;
import com.digital.fishery.service.DeviceFactorService;
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
@Api(tags = "DeviceFactorController", description = "设备因子管理")
@RequestMapping("/deviceFactor")
public class DeviceFactorController {

    @Autowired
    private DeviceFactorService deviceFactorService;

    @ApiOperation("添加设备因子")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DeviceFactor deviceFactor) {
        int count = deviceFactorService.create(deviceFactor);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改设备因子")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody DeviceFactor deviceFactor) {
        int count = deviceFactorService.update(id, deviceFactor);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取设备因子")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DeviceFactor> getItem(@PathVariable Long id) {
        DeviceFactor deviceFactor = deviceFactorService.getItem(id);
        return CommonResult.success(deviceFactor);
    }

    @ApiOperation("根据ID删除设备因子")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = deviceFactorService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询设备因子")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<DeviceFactor>> list(@RequestParam(value = "factorId", required = false) String factorId,
                                                       @RequestParam(value = "factorName", required = false) String factorName,
                                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<DeviceFactor> deviceFactorList = deviceFactorService.list(factorId, factorName, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(deviceFactorList));
    }
}
