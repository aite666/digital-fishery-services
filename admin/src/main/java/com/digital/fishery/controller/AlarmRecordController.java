package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.AlarmRecord;
import com.digital.fishery.model.AlarmRule;
import com.digital.fishery.service.AlarmRecordService;
import com.digital.fishery.service.AlarmRuleService;
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
@Api(tags = "AlarmRecordController", description = "告警规则")
@RequestMapping("/alarm")
public class AlarmRecordController {

    @Autowired
    private AlarmRecordService alarmRecordService;

    @ApiOperation("用户告警数")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Long> count(@RequestParam(value = "userId") Long userId) {
        Long count = alarmRecordService.count(userId);
        return CommonResult.success(count);
    }

    @ApiOperation("用户已读操作")
    @RequestMapping(value = "/updateStatus", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateStatus(@RequestParam(value = "recordId", required = false) Long recordId,
                                     @RequestParam(value = "userId") Long userId) {
        alarmRecordService.updateStatus(recordId, userId);
        return CommonResult.success("更改状态成功");
    }

    @ApiOperation("分页查询告警列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AlarmRecord>> list(@RequestParam(value = "userId", required = false) Long userId,
                                                      @RequestParam(value = "blockId", required = false) Long blockId,
                                                      @RequestParam(value = "description", required = false) String description,
                                                      @RequestParam(value = "startTime", required = false) String startTime,
                                                      @RequestParam(value = "endTime", required = false) String endTime,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<AlarmRecord> alarmRules = alarmRecordService.list(userId, blockId, description, startTime, endTime, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(alarmRules));
    }

    @ApiOperation("根据ID删除告警记录")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = alarmRecordService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
