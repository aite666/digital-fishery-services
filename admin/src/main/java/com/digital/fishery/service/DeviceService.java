package com.digital.fishery.service;

import com.alibaba.fastjson.JSONObject;
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
    List<Device> list(Integer deviceAddr, String deviceName, String deviceType, Long blockId, String blockIds, Integer pageSize, Integer pageNum);

    /**
     * 查询结点
     */
    List<DeviceNodeChartsVO> nodeCharts(Integer deviceAddr, Integer nodeId, Integer registerId, String registerName, Long blockId, String blockIds, String startTime, String endTime);

    /**
     * 查询实时数据
     */
    List<DeviceRealTimeVO> realTimeList(List<Integer> deviceAddrs, Long blockId, String blockIds);

    /**
     * 刷新设备数据
     */
    int refeash();

    /**
     * 查询每天历史数据
     */
    List<JSONObject> dayCharts(String registerNames, Long blockId, String blockIds, String startTime, String endTime);
}
