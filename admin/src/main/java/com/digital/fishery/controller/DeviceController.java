package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.dto.DeviceNodeChartsVO;
import com.digital.fishery.model.Device;
import com.digital.fishery.service.DeviceService;
import com.digital.fishery.dto.DeviceRealTimeVO;
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
@Api(tags = "DeviceController", description = "设备管理")
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @ApiOperation("添加设备")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody Device device) {
        int count = deviceService.create(device);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改设备")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody Device device) {
        int count = deviceService.update(id, device);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取设备")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Device> getItem(@PathVariable Long id) {
        Device device = deviceService.getItem(id);
        return CommonResult.success(device);
    }

    @ApiOperation("根据ID删除设备")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = deviceService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询设备")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Device>> list(@RequestParam(value = "deviceAddr", required = false) Integer deviceAddr,
                                                 @RequestParam(value = "deviceName", required = false) String deviceName,
                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Device> deviceList = deviceService.list(deviceAddr, deviceName, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(deviceList));
    }

    @ApiOperation("设备节点值")
    @RequestMapping(value = "/node/charts", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<DeviceNodeChartsVO>> nodeCharts(@RequestParam(value = "deviceAddr", required = false) Integer deviceAddr,
                                                     @RequestParam(value = "nodeId", required = false) Integer nodeId,
                                                     @RequestParam(value = "registerId") Integer registerId,
                                                     @RequestParam(value = "startTime") String startTime,
                                                     @RequestParam(value = "endTime") String endTime) {
        List<DeviceNodeChartsVO> result = deviceService.nodeCharts(deviceAddr, nodeId, registerId, startTime, endTime);
        return CommonResult.success(result);
    }

    @ApiOperation("分页查询设备")
    @RequestMapping(value = "/realtime/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<DeviceRealTimeVO>> realTimeList(@RequestParam(value = "deviceAddrs", required = false) List<Integer> deviceAddrs,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<DeviceRealTimeVO> deviceRealTimeVOList = deviceService.realTimeList(deviceAddrs, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(deviceRealTimeVOList));
    }
}