package com.digital.fishery.service;

import com.digital.fishery.model.InfoEquipmentCategory;

import java.util.List;

/**
 * 设备种类信息管理Service
 * Created by qianhan on 2021-09-19
 */
public interface InfoEquipmentCategoryService {

    /**
     * 创建设备种类信息
     */
    int create(InfoEquipmentCategory infoEquipmentCategory);

    /**
     * 修改设备种类信息
     */
    int update(Long id, InfoEquipmentCategory infoEquipmentCategory);

    /**
     * 根据ID获取设备种类信息详情
     */
    InfoEquipmentCategory getItem(Long id);

    /**
     * 根据ID删除设备种类信息
     */
    int delete(Long id);

    /**
     * 分页查询后台设备种类信息
     */
    List<InfoEquipmentCategory> list(String name, Integer pageSize, Integer pageNum);
}
