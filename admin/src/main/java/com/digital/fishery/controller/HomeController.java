package com.digital.fishery.controller;

import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.dto.HomeStatsResult;
import com.digital.fishery.model.InfoBlock;
import com.digital.fishery.service.HomeService;
import com.digital.fishery.service.InfoBlockService;
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
@Api(tags = "HomeController", description = "首页管理")
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @ApiOperation("首页统计信息")
    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<HomeStatsResult> stats(@RequestParam(value = "blockIds", required = false) String blockIds) {
        HomeStatsResult stats = homeService.stats(blockIds);
        return CommonResult.success(stats);
    }

    @ApiOperation("首页统计图表")
    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<JSONObject>> chart(
            @RequestParam(value = "blockIds", required = false) String blockIds,
            @RequestParam(value = "startTime", required = true) String startTime,
            @RequestParam(value = "endTime", required = true) String endTime) {
        List<JSONObject> chartData = homeService.chart(blockIds, startTime, endTime);
        return CommonResult.success(chartData);
    }
}
