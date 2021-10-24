package com.digital.fishery.service;

import com.digital.fishery.model.FarmAdviceDetail;

import java.util.List;

/**
 * 农事建议详情管理Service
 * Created by qianhan on 2021-09-19
 */
public interface FarmAdviceDetailService {

    /**
     * 创建农事建议详情
     */
    int create(FarmAdviceDetail farmAdviceDetail);

    /**
     * 修改农事建议详情
     */
    int update(Long id, FarmAdviceDetail farmAdviceDetail);

    /**
     * 根据ID获取农事建议详情详情
     */
    FarmAdviceDetail getItem(Long id);

    /**
     * 根据ID删除农事建议详情
     */
    int delete(Long id);

    /**
     * 分页查询后台农事建议详情
     */
    List<FarmAdviceDetail> list(Long adviceId, Integer pageSize, Integer pageNum);

    /**
     * 批量修改农事建议详情
     */
    int updateBatch(Long adviceId, List<FarmAdviceDetail> farmAdviceDetailList);
}
