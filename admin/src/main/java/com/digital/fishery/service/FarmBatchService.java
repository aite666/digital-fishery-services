package com.digital.fishery.service;

import com.alibaba.fastjson.JSONObject;
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
    List<FarmBatch> list(String name, Long blockId, String blockIds, String farmTime, Integer pageSize, Integer pageNum);

    /**
     * 根据区块id查询所有的养殖种类、批次数以及批次列表
     */
    List<JSONObject> listProductCategory(Long blockId, String blockIds);
}
