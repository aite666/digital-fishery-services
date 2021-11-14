package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.AlarmRule;
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
@Api(tags = "AlarmRuleController", description = "告警规则")
@RequestMapping("/alarm/rule")
public class AlarmRuleController {

    @Autowired
    private AlarmRuleService alarmRuleService;

    @ApiOperation("添加告警规则")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody AlarmRule alarmRule) {
        int count = alarmRuleService.create(alarmRule);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改告警规则")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody AlarmRule alarmRule) {
        int count = alarmRuleService.update(id, alarmRule);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取告警规则")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<AlarmRule> getItem(@PathVariable Long id) {
        AlarmRule alarmRule = alarmRuleService.getItem(id);
        return CommonResult.success(alarmRule);
    }

    @ApiOperation("根据ID删除告警规则")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = alarmRuleService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询告警规则")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AlarmRule>> list(@RequestParam(value = "blockId", required = false) Long blockId,
                                                 @RequestParam(value = "type", required = false) Integer type,
                                                 @RequestParam(value = "factorName", required = false) String factorName,
                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<AlarmRule> alarmRules = alarmRuleService.list(blockId, type, factorName, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(alarmRules));
    }

}
