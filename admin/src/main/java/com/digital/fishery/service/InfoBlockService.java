package com.digital.fishery.service;

import com.digital.fishery.model.InfoBlock;

import java.util.List;

/**
 * 区块信息管理Service
 * Created by qianhan on 2021-09-19
 */
public interface InfoBlockService {

    /**
     * 创建区块信息
     */
    int create(InfoBlock infoBlock);

    /**
     * 修改区块信息
     */
    int update(Long id, InfoBlock infoBlock);

    /**
     * 根据ID获取区块信息详情
     */
    InfoBlock getItem(Long id);

    /**
     * 根据ID删除区块信息
     */
    int delete(Long id);

    /**
     * 分页查询后台区块信息
     */
    List<InfoBlock> list(String name, Long enterpriseId, String blockIds, Integer pageSize, Integer pageNum);
}
