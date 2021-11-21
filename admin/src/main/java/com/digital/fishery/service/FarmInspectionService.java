package com.digital.fishery.service;

import com.digital.fishery.model.FarmInspection;

import java.util.List;

/**
 * 区试管理Service
 * Created by qianhan on 2021-09-19
 */
public interface FarmInspectionService {

    /**
     * 创建区试
     */
    int create(FarmInspection farmInspection);

    /**
     * 修改区试
     */
    int update(Long id, FarmInspection farmInspection);

    /**
     * 根据ID获取区试详情
     */
    FarmInspection getItem(Long id);

    /**
     * 根据ID删除区试
     */
    int delete(Long id);

    /**
     * 分页查询后台区试
     */
    List<FarmInspection> list(Long blockId, Long adminId, String blockIds, String startTime, String endTime, Integer pageSize, Integer pageNum);
}
