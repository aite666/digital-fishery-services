package com.digital.fishery.service;

import com.digital.fishery.model.InfoBlockPosition;

import java.util.List;

/**
 * 区块坐标管理Service
 * Created by qianhan on 2021-09-19
 */
public interface InfoBlockPositionService {

    /**
     * 创建区块坐标
     */
    int create(InfoBlockPosition infoBlockPosition);

    /**
     * 修改区块坐标
     */
    int update(Long id, InfoBlockPosition infoBlockPosition);

    /**
     * 根据ID获取区块坐标详情
     */
    InfoBlockPosition getItem(Long id);

    /**
     * 根据ID删除区块坐标
     */
    int delete(Long id);

    /**
     * 分页查询后台区块坐标
     */
    List<InfoBlockPosition> list(Long blockId, Integer pageSize, Integer pageNum);
}
