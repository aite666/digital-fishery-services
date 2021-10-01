package com.digital.fishery.dao;

import com.digital.fishery.dto.InfoProductCategoryWithChildrenItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 农资种类自定义Dao
 * Created by qianhan on 2021-09-21
 */
@Mapper
public interface InfoProductCategoryDao {

    /**
     * 获取商品分类及其子分类
     */
    List<InfoProductCategoryWithChildrenItem> listWithChildren();

}
