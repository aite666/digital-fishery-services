package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.FarmAdviceDetail;
import com.digital.fishery.service.FarmAdviceDetailService;
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
@Api(tags = "FarmAdviceDetailController", description = "农事建议详情管理")
@RequestMapping("/adviceDetail")
public class FarmAdviceDetailController {

    @Autowired
    private FarmAdviceDetailService farmAdviceDetailService;

    @ApiOperation("添加农事建议详情")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody FarmAdviceDetail farmAdviceDetail) {
        int count = farmAdviceDetailService.create(farmAdviceDetail);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改农事建议详情")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody FarmAdviceDetail farmAdviceDetail) {
        int count = farmAdviceDetailService.update(id, farmAdviceDetail);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取农事建议详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<FarmAdviceDetail> getItem(@PathVariable Long id) {
        FarmAdviceDetail farmAdviceDetail = farmAdviceDetailService.getItem(id);
        return CommonResult.success(farmAdviceDetail);
    }

    @ApiOperation("根据ID删除农事建议详情")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = farmAdviceDetailService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询农事建议详情")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<FarmAdviceDetail>> list(@RequestParam(value = "adviceId", required = false) Long adviceId,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<FarmAdviceDetail> farmAdviceDetailList = farmAdviceDetailService.list(adviceId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(farmAdviceDetailList));
    }

    @ApiOperation("批量修改农事建议详情")
    @RequestMapping(value = "/updateBatch/{adviceId}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBatch(@PathVariable Long adviceId,
                                    @RequestBody List<FarmAdviceDetail> farmAdviceDetailList) {
        int count = farmAdviceDetailService.updateBatch(adviceId, farmAdviceDetailList);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
