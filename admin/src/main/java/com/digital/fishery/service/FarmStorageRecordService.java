package com.digital.fishery.service;

import com.digital.fishery.model.FarmStorageRecord;

import java.util.List;

/**
 * 农资记录管理Service
 * Created by qianhan on 2021-09-19
 */
public interface FarmStorageRecordService {

    /**
     * 创建农资记录
     */
    int create(FarmStorageRecord farmStorageRecord);

    /**
     * 修改农资记录
     */
    int update(Long id, FarmStorageRecord farmStorageRecord);

    /**
     * 根据ID获取农资记录详情
     */
    FarmStorageRecord getItem(Long id);

    /**
     * 根据ID删除农资记录
     */
    int delete(Long id);

    /**
     * 分页查询后台农资记录
     */
    List<FarmStorageRecord> list(Long storageId, Integer pageSize, Integer pageNum);
}
