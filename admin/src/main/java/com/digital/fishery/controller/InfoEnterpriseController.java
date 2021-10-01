package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.InfoEnterprise;
import com.digital.fishery.service.InfoEnterpriseService;
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
@Api(tags = "InfoEnterpriseController", description = "企业信息管理")
@RequestMapping("/enterprise")
public class InfoEnterpriseController {

    @Autowired
    private InfoEnterpriseService infoEnterpriseService;

    @ApiOperation("添加企业信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody InfoEnterprise infoEnterprise) {
        int count = infoEnterpriseService.create(infoEnterprise);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改企业信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody InfoEnterprise infoEnterprise) {
        int count = infoEnterpriseService.update(id, infoEnterprise);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取企业信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<InfoEnterprise> getItem(@PathVariable Long id) {
        InfoEnterprise infoEnterprise = infoEnterpriseService.getItem(id);
        return CommonResult.success(infoEnterprise);
    }

    @ApiOperation("根据ID删除企业信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = infoEnterpriseService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询企业信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<InfoEnterprise>> list(@RequestParam(value = "name", required = false) String name,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<InfoEnterprise> infoEnterpriseList = infoEnterpriseService.list(name, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(infoEnterpriseList));
    }
}
