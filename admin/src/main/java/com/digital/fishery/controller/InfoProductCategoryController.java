package com.digital.fishery.controller;

import com.digital.fishery.api.CommonPage;
import com.digital.fishery.api.CommonResult;
import com.digital.fishery.dto.InfoProductCategoryWithChildrenItem;
import com.digital.fishery.model.InfoProductCategory;
import com.digital.fishery.service.InfoProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by qianhan on 2021-09-19
 */
@Controller
@Api(tags = "InfoProductCategoryController", description = "农资种类信息管理")
@RequestMapping("/productCategory")
public class InfoProductCategoryController {

    @Autowired
    private InfoProductCategoryService infoProductCategoryService;

    @ApiOperation("添加农资种类信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody InfoProductCategory infoProductCategory) {
        int count = infoProductCategoryService.create(infoProductCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改农资种类信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @Validated
                               @RequestBody InfoProductCategory infoProductCategory) {
        int count = infoProductCategoryService.update(id, infoProductCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取农资种类信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<InfoProductCategory> getItem(@PathVariable Long id) {
        InfoProductCategory infoProductCategory = infoProductCategoryService.getItem(id);
        return CommonResult.success(infoProductCategory);
    }

    @ApiOperation("根据ID删除农资种类信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = infoProductCategoryService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询农资种类信息")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<InfoProductCategory>> list(
                                                         @PathVariable Long parentId,
                                                         @RequestParam(value = "name", required = false) String name,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<InfoProductCategory> infoProductCategoryList = infoProductCategoryService.list(parentId, name, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(infoProductCategoryList));
    }


    @ApiOperation("查询所有一级分类及子分类")
    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<InfoProductCategoryWithChildrenItem>> listWithChildren() {
        List<InfoProductCategoryWithChildrenItem> list = infoProductCategoryService.listWithChildren();
        return CommonResult.success(list);
    }
}
