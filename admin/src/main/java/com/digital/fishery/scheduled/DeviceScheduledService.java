package com.digital.fishery.scheduled;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.digital.fishery.common.DeviceHttpClient;
import com.digital.fishery.mapper.*;
import com.digital.fishery.model.*;
import com.digital.fishery.scheduled.domain.BaseResponse;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.digital.fishery.scheduled.consts.Consts.*;

@Service
public class DeviceScheduledService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceScheduledService.class);

    @Autowired
    private DeviceGroupMapper deviceGroupMapper;
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private DeviceRelayMapper deviceRelayMapper;
    @Autowired
    private DeviceFactorMapper deviceFactorMapper;
    @Autowired
    private DeviceNodeMapper deviceNodeMapper;
    @Autowired
    private DeviceHttpClient deviceHttpClient;

    /**
     * 设备组信息每天凌晨0点15分执行一次
     */
//    @Scheduled(cron = "0 15 0 * * ?")
//    public void insertDeviceGroup() {
//        try {
//            BaseResponse baseResponse = doGet(DEVICE_BASE_URL + DEVICE_GROUP_URL, null);
//            if (baseResponse == null) {
//                return;
//            }
//            List<DeviceGroup> deviceGroupList = (List<DeviceGroup>)baseResponse.getData();
//            for (DeviceGroup deviceGroup : deviceGroupList) {
//                deviceGroupMapper.insert(deviceGroup);
//            }
//        } catch (Exception e) {
//            LOGGER.warn("insertDeviceGroup error, ", e);
//        }
//    }

    /**
     * 设备每天凌晨1点执行一次
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void insertDevice() {
//            List<DeviceGroup> deviceGroupList = deviceGroupMapper.selectByExample(new DeviceGroupExample());
//            if (CollectionUtils.isEmpty(deviceGroupList)) {
//                return;
//            }
//            List<String> groupIds = deviceGroupList.stream().map(DeviceGroup::getGroupid).collect(Collectors.toList());
//            if (CollectionUtils.isEmpty(groupIds)) {
//                return;
//            }

        BaseResponse baseResponse = deviceHttpClient.doGet(DEVICE_BASE_URL + DEVICE_URL, null);
        if (baseResponse == null) {
            return;
        }
        List<Device> deviceList = JSON.parseObject(baseResponse.getData().toString(), new TypeReference<List<Device>>() {});
        if (CollectionUtils.isEmpty(deviceList)) {
            return;
        }

        deviceMapper.deleteByExample(new DeviceExample());
        for (Device device : deviceList) {
            device.setCreateTime(new Date());
            deviceMapper.insert(device);

            // factors
            List<DeviceFactor> factors = device.getFactors();
            if (CollectionUtils.isEmpty(factors)) {
                continue;
            }
            DeviceFactorExample delFactorExample = new DeviceFactorExample();
            delFactorExample.createCriteria().andDeviceAddrEqualTo(device.getDeviceAddr());
            deviceFactorMapper.deleteByExample(delFactorExample);

            for (DeviceFactor factor : factors) {
                factor.setCreateTime(new Date());
                deviceFactorMapper.insert(factor);
            }
        }
        LOGGER.info("insertDevice finish");
    }

    /**
     * 继电器每天凌晨2点执行一次
     */
    @Scheduled(cron = "0 0 2 * * ?")
    public void insertDeviceRelay() {
        List<Device> deviceList = deviceMapper.selectByExample(new DeviceExample());
        if (CollectionUtils.isEmpty(deviceList)) {
            return;
        }
        List<Integer> deviceAddrs = deviceList.stream().map(Device::getDeviceAddr).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(deviceAddrs)) {
            return;
        }

        for (Integer deviceAddr : deviceAddrs) {
            Map<String, String> param = new HashMap<>();
            param.put("deviceAddr", deviceAddr.toString());
            BaseResponse baseResponse = deviceHttpClient.doGet(DEVICE_BASE_URL + DEVICE_RELAY_URL, param);
            if (baseResponse == null) {
                continue;
            }

            List<DeviceRelay> deviceRelays = JSON.parseObject(baseResponse.getData().toString(), new TypeReference<List<DeviceRelay>>() {});
            if (CollectionUtils.isNotEmpty(deviceRelays)) {
                // delete
                DeviceRelayExample delRelayExample = new DeviceRelayExample();
                delRelayExample.createCriteria().andDeviceAddrEqualTo(deviceAddr);
                deviceRelayMapper.deleteByExample(delRelayExample);
            }
            for (DeviceRelay deviceRelay : deviceRelays) {
                // insert
                deviceRelay.setCreateTime(new Date());
                deviceRelayMapper.insert(deviceRelay);
            }

        }
        LOGGER.info("insertDeviceRelay finish");
    }

    /**
     * 历史数据列表每30分钟执行一次
     */
    @Scheduled(cron = "0 30 * * * ?")
    public void insertDeviceNode() {
        List<Device> deviceList = deviceMapper.selectByExample(new DeviceExample());
        if (CollectionUtils.isEmpty(deviceList)) {
            return;
        }
        List<Integer> deviceAddrs = deviceList.stream().map(Device::getDeviceAddr).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(deviceAddrs)) {
            return;
        }

        for (Integer deviceAddr : deviceAddrs) {
            Map<String, String> param = new HashMap<>();
            param.put("deviceAddr", deviceAddr.toString());
            param.put("nodeId", "-1");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMATTER);
            param.put("startTime", simpleDateFormat.format(new Date(new Date().getTime() - (1000*60*30))));
            param.put("endTime", simpleDateFormat.format(new Date()));
            BaseResponse baseResponse = deviceHttpClient.doGet(DEVICE_BASE_URL + DEVICE_HISTORY_URL, param);
            if (baseResponse == null) {
                continue;
            }

            List<DeviceNodeResp> deviceNodeResp = JSON.parseObject(baseResponse.getData().toString(), new TypeReference<List<DeviceNodeResp>>() {});
            for (DeviceNodeResp node : deviceNodeResp) {
                DeviceNode deviceNode = new DeviceNode();
                BeanUtils.copyProperties(node, deviceNode);
                List<DeviceNodeResp.RegisterData> data = node.getData();
                if (CollectionUtils.isEmpty(data)) {
                    deviceNode.setCreateTime(new Date());
                    deviceNodeMapper.insert(deviceNode);
                    continue;
                }
                for (DeviceNodeResp.RegisterData registerData : data) {
                    BeanUtils.copyProperties(registerData, deviceNode);
                    deviceNode.setCreateTime(new Date());
                    deviceNodeMapper.insert(deviceNode);
                }
            }
        }
        LOGGER.info("insertDeviceNode finish");
    }

}
