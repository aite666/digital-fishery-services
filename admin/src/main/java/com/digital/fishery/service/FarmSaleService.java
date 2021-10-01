package com.digital.fishery.service;

import com.digital.fishery.model.FarmSale;

import java.util.List;

/**
 * 销售管理Service
 * Created by qianhan on 2021-09-19
 */
public interface FarmSaleService {

    /**
     * 创建销售
     */
    int create(FarmSale farmSale);

    /**
     * 修改销售
     */
    int update(Long id, FarmSale farmSale);

    /**
     * 根据ID获取销售详情
     */
    FarmSale getItem(Long id);

    /**
     * 根据ID删除销售
     */
    int delete(Long id);

    /**
     * 分页查询后台销售
     */
    List<FarmSale> list(Long blockId, Integer pageSize, Integer pageNum);
}
