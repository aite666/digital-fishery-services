package com.digital.fishery.service;

import com.digital.fishery.model.DeviceFactor;

import java.util.List;

public interface DeviceFactorService {

    /**
     * 创建设备因子
     */
    int create(DeviceFactor deviceFactor);

    /**
     * 修改设备因子
     */
    int update(Long id, DeviceFactor deviceFactor);

    /**
     * 根据ID获取设备因子详情
     */
    DeviceFactor getItem(Long id);

    /**
     * 根据ID删除设备因子
     */
    int delete(Long id);

    /**
     * 分页查询后台设备因子
     */
    List<DeviceFactor> list(String factorId, String factorName, Integer deviceAddr, Integer pageSize, Integer pageNum);
}
