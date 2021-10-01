package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.model.InfoQrCode;
import com.digital.fishery.service.InfoQrCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by qianhan on 2021-09-26
 */
@Controller
@Api(tags = "InfoQrCodeController", description = "二维码管理")
@RequestMapping("/qrCode")
public class InfoQrCodeController {
    @Autowired
    private InfoQrCodeService infoQrCodeService;

    @ApiOperation("添加二维码")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody InfoQrCode infoQrCode) {
        int count = infoQrCodeService.create(infoQrCode);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改二维码")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody InfoQrCode infoQrCode) {
        int count = infoQrCodeService.update(id, infoQrCode);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取二维码")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<InfoQrCode> getItem(@PathVariable Long id) {
        InfoQrCode infoQrCode = infoQrCodeService.getItem(id);
        return CommonResult.success(infoQrCode);
    }

    @ApiOperation("根据ID删除二维码")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = infoQrCodeService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询二维码")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<InfoQrCode>> list(@RequestParam(value = "title", required = false) String title,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<InfoQrCode> infoQrCodeList = infoQrCodeService.list(title, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(infoQrCodeList));
    }}
