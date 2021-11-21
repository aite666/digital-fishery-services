package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.InfoBlock;
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
@Api(tags = "InfoBlockController", description = "区块信息管理")
@RequestMapping("/block")
public class InfoBlockController {

    @Autowired
    private InfoBlockService infoBlockService;

    @ApiOperation("添加区块信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody InfoBlock infoBlock) {
        int count = infoBlockService.create(infoBlock);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改区块信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody InfoBlock infoBlock) {
        int count = infoBlockService.update(id, infoBlock);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取区块信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<InfoBlock> getItem(@PathVariable Long id) {
        InfoBlock infoBlock = infoBlockService.getItem(id);
        return CommonResult.success(infoBlock);
    }

    @ApiOperation("根据ID删除区块信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = infoBlockService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询区块信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<InfoBlock>> list(@RequestParam(value = "name", required = false) String name,
                                                    @RequestParam(value = "enterpriseId", required = false) Long enterpriseId,
                                                    @RequestParam(value = "blockIds", required = false) String blockIds,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<InfoBlock> infoBlockList = infoBlockService.list(name, enterpriseId, blockIds, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(infoBlockList));
    }
}
