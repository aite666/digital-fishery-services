package com.digital.fishery.service;

import com.digital.fishery.model.DeviceRelay;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DeviceRelayService {

    /**
     * 创建设备
     */
    int create(DeviceRelay deviceRelay);

    /**
     * 修改设备
     */
    int update(Long id, DeviceRelay deviceRelay);

    /**
     * 根据ID获取设备详情
     */
    DeviceRelay getItem(Long id);


    /**
     * 根据ID删除设备
     */
    int delete(Long id);

    /**
     * 分页查询后台设备
     */
    List<DeviceRelay> list(Integer relayNo, String relayName, Integer deviceAddr, Integer pageSize, Integer pageNum);
}
