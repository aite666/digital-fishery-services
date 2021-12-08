package com.digital.fishery.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.digital.fishery.common.DeviceHttpClient;
import com.digital.fishery.mapper.DeviceFactorMapper;
import com.digital.fishery.model.*;
import com.digital.fishery.scheduled.domain.BaseResponse;
import com.digital.fishery.dto.DeviceNodeChartsVO;
import com.digital.fishery.mapper.DeviceMapper;
import com.digital.fishery.mapper.DeviceNodeMapper;
import com.digital.fishery.service.DeviceService;
import com.digital.fishery.dto.DeviceRealTimeVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import lombok.val;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.digital.fishery.scheduled.consts.Consts.*;

@Service
public class DeviceServiceImpl implements DeviceService {

    private static final Logger logger = LoggerFactory.getLogger(DeviceServiceImpl.class);

    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private DeviceNodeMapper deviceNodeMapper;
    @Autowired
    private DeviceFactorMapper deviceFactorMapper;

    @Autowired
    private DeviceHttpClient deviceHttpClient;

    @Override
    public int create(Device Device) {
        Device.setCreateTime(new Date());
        return deviceMapper.insert(Device);
    }

    @Override
    public int update(Long id, Device Device) {
        Device.setId(id);
        return deviceMapper.updateByPrimaryKeySelective(Device);
    }

    @Override
    public Device getItem(Long id) {
        return deviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return deviceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Device> list(Integer deviceAddr, String deviceName, String deviceType, Long blockId, String blockIds, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        DeviceExample example = new DeviceExample();
        DeviceExample.Criteria criteria =  example.createCriteria();
        if (deviceAddr != null) {
            criteria.andDeviceAddrEqualTo(deviceAddr);
        }
        if (StringUtils.isNotBlank(deviceName)) {
            criteria.andDeviceNameEqualTo("%" + deviceName + "%");
        }
        if (StringUtils.isNotBlank(deviceType)) {
            criteria.andDeviceTypeEqualTo(deviceType);
        }
        if (blockId != null) {
            criteria.andBlockIdEqualTo(blockId);
        }
        if (StringUtil.isNotEmpty(blockIds)) {
            List<Long> blockIdList = Arrays.stream(blockIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
            criteria.andBlockIdIn(blockIdList);
        }
        List<Device> deviceList = deviceMapper.selectByExample(example);
        return deviceList;
    }

    @Override
    public List<DeviceNodeChartsVO> nodeCharts(Integer deviceAddr, Integer nodeId, Integer registerId, String registerName, Long blockId, String blockIds, String startTime, String endTime) {
        DeviceNodeExample example = new DeviceNodeExample();
        example.setOrderByClause("record_time");
        DeviceNodeExample.Criteria criteria = example.createCriteria();
        if (deviceAddr != null) {
            criteria.andDeviceAddrEqualTo(deviceAddr);
        }
        if (nodeId != null) {
            criteria.andNodeIdEqualTo(nodeId);
        }
        if (registerId != null) {
            criteria.andRegisterIdEqualTo(registerId);
        }
        if (registerName != null) {
            criteria.andRegisterNameEqualTo(registerName);
        }
        if (blockId != null) {
            criteria.andBlockIdEqualTo(blockId);
        }
        if (StringUtil.isNotEmpty(blockIds)) {
            List<Long> blockIdList = Arrays.stream(blockIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
            criteria.andBlockIdIn(blockIdList);
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMATTER);
            Date start = simpleDateFormat.parse(startTime);
            Date end = simpleDateFormat.parse(endTime);
            criteria.andRecordTimeBetween(start, end);
            List<DeviceNode> deviceNodes = deviceNodeMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(deviceNodes)) {
                logger.warn("NODE NOT FOUND");
                return null;
            }

            Map<String, List<DeviceNode>> map = deviceNodes.stream()
                    .collect(Collectors.groupingBy(o -> (o.getDeviceAddr().toString() + "," + o.getNodeId().toString() + "," + o.getBlockId().toString() + "," + o.getBlockName() + "," + o.getDeviceName())));

            List<DeviceNodeChartsVO> result = new ArrayList<>();
            for (Map.Entry<String, List<DeviceNode>> entry : map.entrySet()) {
                String key = entry.getKey();

                DeviceNodeChartsVO vo = new DeviceNodeChartsVO();
                String[] split = key.split(",");
                vo.setDeviceAddr(Integer.parseInt(split[0]));
                vo.setNodeId(Integer.parseInt(split[1]));
                vo.setBlockId(Long.parseLong(split[2]));
                vo.setBlockName(split[3]);
                vo.setDeviceName(split[4]);

                List<DeviceNodeChartsVO.NodeData> data = new ArrayList<>();
                List<DeviceNode> value = entry.getValue();
                for (DeviceNode deviceNode : value) {
                    DeviceNodeChartsVO.NodeData nodeData = new DeviceNodeChartsVO.NodeData();
                    BeanUtils.copyProperties(deviceNode, nodeData);
                    data.add(nodeData);
                }
                vo.setData(data);
                result.add(vo);
            }
            return result;
        } catch (ParseException e) {
            logger.warn("ParseException, ", e);
        }
        return null;
    }

    @Override
    public List<DeviceRealTimeVO> realTimeList(List<Integer> deviceAddrs, Long blockId, String blockIds) {
        BaseResponse baseResponse = null;
        List<DeviceRealTimeVO> deviceRealTimeVOList = new ArrayList<>();
        Map<String, String> param = new HashMap<>();
        List<Integer> deviceAddrList = null;
        if (blockId != null || StringUtil.isNotEmpty(blockIds)) {
            DeviceExample example = new DeviceExample();
            DeviceExample.Criteria criteria = example.createCriteria();
            if (blockId != null) {
                criteria.andBlockIdEqualTo(blockId);
            }
            if (StringUtil.isNotEmpty(blockIds)) {
                List<Long> blockIdList = Arrays.stream(blockIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
                criteria.andBlockIdIn(blockIdList);
            }
            List<Device> deviceList = deviceMapper.selectByExample(example);
            deviceAddrList = deviceList.stream().map(Device::getDeviceAddr).collect(Collectors.toList());
        }
        if (deviceAddrList != null && deviceAddrList.size() == 0) {
            return deviceRealTimeVOList;
        }
        if (deviceAddrs != null && deviceAddrs.size() > 0) {
            if (deviceAddrList != null && deviceAddrList.size() > 0) {
                deviceAddrs = (List<Integer>)CollectionUtils.intersection(deviceAddrList, deviceAddrs);
            }
            param.put("deviceAddrs", StringUtils.join(deviceAddrs, ","));
            baseResponse = deviceHttpClient.doGet(DEVICE_REAL_TIME_BY_ADDR_RL + DEVICE_REAL_TIME_URL, param);
        } else {
            if (deviceAddrList != null && deviceAddrList.size() > 0) {
                param.put("deviceAddrs", StringUtils.join(deviceAddrList, ","));
            }
            baseResponse = deviceHttpClient.doGet(DEVICE_BASE_URL + DEVICE_REAL_TIME_URL, param);
        }

        if (baseResponse == null) {
            return deviceRealTimeVOList;
        }
        deviceRealTimeVOList = JSON.parseObject(baseResponse.getData().toString(), new TypeReference<List<DeviceRealTimeVO>>() {});
        return deviceRealTimeVOList;
    }

    @Override
    public int refeash() {
        int count = 0;
        BaseResponse baseResponse = deviceHttpClient.doGet(DEVICE_BASE_URL + DEVICE_URL, null);
        if (baseResponse == null) {
            return count;
        }
        List<Device> deviceList = JSON.parseObject(baseResponse.getData().toString(), new TypeReference<List<Device>>() {});
        if (CollectionUtils.isEmpty(deviceList)) {
            return count;
        }

        //这里先保留所有采集设备的一些信息，然后再删除新增
        DeviceExample deviceExample = new DeviceExample();
        deviceExample.createCriteria().andDeviceTypeEqualTo("采集设备");
        List<Device> dbDeviceList = deviceMapper.selectByExample(deviceExample);
        Map<Integer, Device> dbBlockInfo = new HashMap<Integer, Device>();
        for (int i=0; i<dbDeviceList.size(); i++) {
            dbBlockInfo.put(dbDeviceList.get(i).getDeviceAddr(), dbDeviceList.get(i));
        }
        deviceMapper.deleteByExample(deviceExample);
        for (Device device : deviceList) {
            device.setCreateTime(new Date());
            device.setDeviceType("采集设备");
            if (dbBlockInfo.get(device.getDeviceAddr()) != null) {
                device.setBlockId(dbBlockInfo.get(device.getDeviceAddr()).getBlockId());
                device.setDeviceName(dbBlockInfo.get(device.getDeviceAddr()).getDeviceName());
            }
            deviceMapper.insert(device);

            // factors
            List<DeviceFactor> factors = device.getFactors();
            if (CollectionUtils.isEmpty(factors)) {
                continue;
            }
            DeviceFactorExample delFactorExample = new DeviceFactorExample();
            delFactorExample.createCriteria().andDeviceAddrEqualTo2(device.getDeviceAddr());
            deviceFactorMapper.deleteByExample(delFactorExample);

            for (DeviceFactor factor : factors) {
                factor.setCreateTime(new Date());
                deviceFactorMapper.insert(factor);
            }
        }
        return 1;
    }

    @Override
    public List<JSONObject> dayCharts(String registerNames, Long blockId, String blockIds, String startTime, String endTime) {
        List<JSONObject> result = new ArrayList<>();
        List<String> registerNameList = new ArrayList<>();
        if (registerNames != null) {
            registerNameList = Arrays.stream(registerNames.split(",")).collect(Collectors.toList());
        }
        List<Long> blockIdList = new ArrayList<>();
        if (StringUtil.isNotEmpty(blockIds)) {
            blockIdList = Arrays.stream(blockIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
        }
        List<JSONObject> deviceNodes = deviceNodeMapper.getDeviceNodeDailyData(registerNameList, blockId, blockIdList, startTime, endTime);
        Map<String, JSONObject> deviceNodeMap = new HashMap<>();
        List<String> registerNameStrList = new ArrayList<>();
        for (JSONObject deviceNode: deviceNodes) {
            String recordDate = deviceNode.getString("recordDate");
            String registerName = deviceNode.getString("registerName");
            if (!registerNameStrList.contains(registerName)) {
                registerNameStrList.add(registerName);
            }
            Float dayValue = deviceNode.getFloatValue("dayValue");
            if (deviceNodeMap.get(recordDate) == null) {
                JSONObject data = new JSONObject();
                data.put(registerName, dayValue);
                deviceNodeMap.put(recordDate, data);
            } else {
                JSONObject data = deviceNodeMap.get(recordDate);
                data.put(registerName, dayValue);
                deviceNodeMap.put(recordDate, data);
            }
        }
        List<String> allDateList = this.getAllDate(startTime, endTime);
        for (String date: allDateList) {
            JSONObject o = new JSONObject();
            o.put("date", date);
            if (deviceNodeMap.get(date) != null) {
                JSONObject data = deviceNodeMap.get(date);
                for (String registerName: registerNameStrList) {
                    if (data.get(registerName) != null) {
                        o.put(registerName, data.get(registerName));
                    } else {
                        o.put(registerName, 0);
                    }
                }
            } else {
                for (String registerName: registerNameStrList) {
                    o.put(registerName, 0);
                }
            }
            result.add(o);
        }
        return result;
    }

    private List<String> getAllDate(String startTime, String endTime) {
        List<String> allDateList = new ArrayList<>();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMATTER);
            Date start = simpleDateFormat.parse(startTime);
            Date end = simpleDateFormat.parse(endTime);
            Long startTimestamp = start.getTime();
            Long endTimestamp = end.getTime();
            Long oneDay = 1000 * 60 * 60 * 24L;

            Long time = startTimestamp;
            while (time <= endTimestamp) {
                Date d = new Date(time);
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                allDateList.add(df.format(d));
                time += oneDay;
            }
        } catch (ParseException e) {
            logger.warn("ParseException, ", e);
        }
        return allDateList;
    }
}
