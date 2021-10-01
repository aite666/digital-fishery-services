package com.digital.fishery.service;

import com.digital.fishery.model.FarmStorage;

import java.util.List;

/**
 * 农资管理Service
 * Created by qianhan on 2021-09-19
 */
public interface FarmStorageService {

    /**
     * 创建农资
     */
    int create(FarmStorage farmStorage);

    /**
     * 修改农资
     */
    int update(Long id, FarmStorage farmStorage);

    /**
     * 根据ID获取农资详情
     */
    FarmStorage getItem(Long id);

    /**
     * 根据ID删除农资
     */
    int delete(Long id);

    /**
     * 分页查询后台农资
     */
    List<FarmStorage> list(String name, Integer pageSize, Integer pageNum);
}
