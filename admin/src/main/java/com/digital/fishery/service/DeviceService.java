package com.digital.fishery.service;

import com.digital.fishery.dto.DeviceNodeChartsVO;
import com.digital.fishery.model.Device;
import com.digital.fishery.dto.DeviceRealTimeVO;

import java.util.List;

public interface DeviceService {

    /**
     * 创建设备
     */
    int create(Device device);

    /**
     * 修改设备
     */
    int update(Long id, Device device);

    /**
     * 根据ID获取设备详情
     */
    Device getItem(Long id);

    /**
     * 根据ID删除设备
     */
    int delete(Long id);

    /**
     * 分页查询后台设备
     */
    List<Device> list(Integer deviceAddr, String deviceName, Integer pageSize, Integer pageNum);

    /**
     * 查询结点
     */
    List<DeviceNodeChartsVO> nodeCharts(Integer deviceAddr, Integer nodeId, Integer registerId, String startTime, String endTime);

    List<DeviceRealTimeVO> realTimeList(List<Integer> deviceAddrs, Integer pageSize1, Integer pageNum);
}
