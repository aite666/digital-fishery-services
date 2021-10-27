package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.InfoBlockPosition;
import com.digital.fishery.service.InfoBlockPositionService;
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
@Api(tags = "InfoBlockPositionController", description = "区块坐标管理")
@RequestMapping("/blockPosition")
public class InfoBlockPositionController {

    @Autowired
    private InfoBlockPositionService infoBlockPositionService;

    @ApiOperation("添加区块坐标")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody InfoBlockPosition infoBlockPosition) {
        int count = infoBlockPositionService.create(infoBlockPosition);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改区块坐标")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody InfoBlockPosition infoBlockPosition) {
        int count = infoBlockPositionService.update(id, infoBlockPosition);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取区块坐标")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<InfoBlockPosition> getItem(@PathVariable Long id) {
        InfoBlockPosition infoBlockPosition = infoBlockPositionService.getItem(id);
        return CommonResult.success(infoBlockPosition);
    }

    @ApiOperation("根据ID删除区块坐标")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = infoBlockPositionService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询区块坐标")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<InfoBlockPosition>> list(@RequestParam(value = "blockId", required = false) Long blockId,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<InfoBlockPosition> infoBlockPositionList = infoBlockPositionService.list(blockId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(infoBlockPositionList));
    }
}
