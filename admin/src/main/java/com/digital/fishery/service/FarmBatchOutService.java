package com.digital.fishery.service;

import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.model.FarmBatchOut;

import java.util.List;

/**
 * 批次管理Service
 * Created by qianhan on 2021-09-19
 */
public interface FarmBatchOutService {

    /**
     * 创建批次
     */
    int create(FarmBatchOut farmBatchOut);

    /**
     * 修改批次
     */
    int update(Long id, FarmBatchOut farmBatchOut);

    /**
     * 根据ID获取批次详情
     */
    FarmBatchOut getItem(Long id);

    /**
     * 根据ID删除批次
     */
    int delete(Long id);

    /**
     * 分页查询后台批次
     */
    List<FarmBatchOut> list(String name, Long blockId, String blockIds, Integer pageSize, Integer pageNum);

    /**
     * 查询农事批次数量
     */
    long count(String name, Long blockId);
}
