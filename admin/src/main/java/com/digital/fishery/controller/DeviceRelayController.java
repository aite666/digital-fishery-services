package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.DeviceRelay;
import com.digital.fishery.service.DeviceRelayService;
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
@Api(tags = "DeviceRelayController", description = "设备继电器管理")
@RequestMapping("/deviceRelay")
public class DeviceRelayController {

    @Autowired
    private DeviceRelayService deviceRelayService;

    @ApiOperation("添加设备继电器")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DeviceRelay deviceRelay) {
        int count = deviceRelayService.create(deviceRelay);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改设备继电器")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody DeviceRelay deviceRelay) {
        int count = deviceRelayService.update(id, deviceRelay);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取设备继电器")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DeviceRelay> getItem(@PathVariable Long id) {
        DeviceRelay deviceRelay = deviceRelayService.getItem(id);
        return CommonResult.success(deviceRelay);
    }

    @ApiOperation("根据ID删除设备继电器")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = deviceRelayService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询设备继电器")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<DeviceRelay>> list(@RequestParam(value = "relayNo", required = false) Integer relayNo,
                                                       @RequestParam(value = "relayName", required = false) String relayName,
                                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<DeviceRelay> deviceRelayList = deviceRelayService.list(relayNo, relayName, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(deviceRelayList));
    }
}
