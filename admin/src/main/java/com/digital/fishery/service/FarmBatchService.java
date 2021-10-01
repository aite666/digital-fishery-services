package com.digital.fishery.service;

import com.digital.fishery.model.FarmBatch;

import java.util.List;

/**
 * 批次管理Service
 * Created by qianhan on 2021-09-19
 */
public interface FarmBatchService {

    /**
     * 创建批次
     */
    int create(FarmBatch farmBatch);

    /**
     * 修改批次
     */
    int update(Long id, FarmBatch farmBatch);

    /**
     * 根据ID获取批次详情
     */
    FarmBatch getItem(Long id);

    /**
     * 根据ID删除批次
     */
    int delete(Long id);

    /**
     * 分页查询后台批次
     */
    List<FarmBatch> list(String name, Integer pageSize, Integer pageNum);
}
