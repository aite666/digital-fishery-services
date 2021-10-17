package com.digital.fishery.service;

import com.digital.fishery.model.BigscreenConfig;

import java.util.List;

/**
 * 大屏配置管理Service
 * Created by qianhan on 2021-09-19
 */
public interface BigscreenConfigService {

    /**
     * 创建大屏配置
     */
    int create(BigscreenConfig bigscreenConfig);

    /**
     * 修改大屏配置
     */
    int update(Long id, BigscreenConfig bigscreenConfig);

    /**
     * 修改大屏配置
     */
    int updateByName(String name, BigscreenConfig bigscreenConfig);

    /**
     * 根据ID获取大屏配置详情
     */
    BigscreenConfig getItem(Long id);

    /**
     * 根据ID删除大屏配置
     */
    int delete(Long id);

    /**
     * 分页查询后台大屏配置
     */
    List<BigscreenConfig> list(String name, Integer pageSize, Integer pageNum);
}
