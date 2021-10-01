package com.digital.fishery.service;

import com.digital.fishery.model.FarmAdvice;

import java.util.List;

/**
 * 农事建议管理Service
 * Created by qianhan on 2021-09-19
 */
public interface FarmAdviceService {

    /**
     * 创建农事建议
     */
    int create(FarmAdvice farmAdvice);

    /**
     * 修改农事建议
     */
    int update(Long id, FarmAdvice farmAdvice);

    /**
     * 根据ID获取农事建议详情
     */
    FarmAdvice getItem(Long id);

    /**
     * 根据ID删除农事建议
     */
    int delete(Long id);

    /**
     * 分页查询后台农事建议
     */
    List<FarmAdvice> list(String name, Integer pageSize, Integer pageNum);
}
