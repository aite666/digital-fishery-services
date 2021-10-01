package com.digital.fishery.service;

import com.digital.fishery.dto.InfoProductCategoryWithChildrenItem;
import com.digital.fishery.model.InfoProductCategory;

import java.util.List;

/**
 * 农资种类信息管理Service
 * Created by qianhan on 2021-09-19
 */
public interface InfoProductCategoryService {

    /**
     * 创建农资种类信息
     */
    int create(InfoProductCategory infoProductCategory);

    /**
     * 修改农资种类信息
     */
    int update(Long id, InfoProductCategory infoProductCategory);

    /**
     * 根据ID获取农资种类信息详情
     */
    InfoProductCategory getItem(Long id);

    /**
     * 根据ID删除农资种类信息
     */
    int delete(Long id);

    /**
     * 分页查询后台农资种类信息
     */
    List<InfoProductCategory> list(Long parentId, String name, Integer pageSize, Integer pageNum);


    /**
     * 以层级形式获取农资种类分类
     */
    List<InfoProductCategoryWithChildrenItem> listWithChildren();
}
