package com.digital.fishery.service;

import com.digital.fishery.model.DeviceGroup;

import java.util.List;

public interface DeviceGroupService {

    /**
     * 创建设备组
     */
    int create(DeviceGroup deviceGroup);

    /**
     * 修改设备组
     */
    int update(Long id, DeviceGroup deviceGroup);

    /**
     * 根据ID获取设备组详情
     */
    DeviceGroup getItem(Long id);

    /**
     * 根据ID删除设备组
     */
    int delete(Long id);

    /**
     * 分页查询后台设备组
     */
    List<DeviceGroup> list(String name, Integer pageSize, Integer pageNum);
}
