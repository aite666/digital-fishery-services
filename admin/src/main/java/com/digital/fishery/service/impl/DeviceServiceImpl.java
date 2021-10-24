package com.digital.fishery.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.digital.fishery.common.DeviceHttpClient;
import com.digital.fishery.scheduled.domain.BaseResponse;
import com.digital.fishery.dto.DeviceNodeChartsVO;
import com.digital.fishery.mapper.DeviceMapper;
import com.digital.fishery.mapper.DeviceNodeMapper;
import com.digital.fishery.model.Device;
import com.digital.fishery.model.DeviceExample;
import com.digital.fishery.model.DeviceNode;
import com.digital.fishery.model.DeviceNodeExample;
import com.digital.fishery.service.DeviceService;
import com.digital.fishery.dto.DeviceRealTimeVO;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Device> list(Integer deviceAddr, String deviceName, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        DeviceExample example = new DeviceExample();
        if (deviceAddr != null) {
            example.createCriteria().andDeviceAddrEqualTo(deviceAddr);
        }
        if (StringUtils.isNotBlank(deviceName)) {
            example.createCriteria().andDeviceNameEqualTo(deviceName);
        }
        List<Device> deviceList = deviceMapper.selectByExample(example);
        return deviceList;
    }

    @Override
    public List<DeviceNodeChartsVO> nodeCharts(Integer deviceAddr, Integer nodeId, Integer registerId, String startTime, String endTime) {
        DeviceNodeExample example = new DeviceNodeExample();
        if (deviceAddr != null) {
            example.createCriteria().andDeviceAddrEqualTo(deviceAddr);
        }
        if (nodeId != null) {
            example.createCriteria().andNodeIdEqualTo(nodeId);
        }
        example.createCriteria().andRegisterIdEqualTo(registerId);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMATTER);
            Date start = simpleDateFormat.parse(startTime);
            Date end = simpleDateFormat.parse(endTime);
            example.createCriteria().andRecordTimeBetween(start, end);
            List<DeviceNode> deviceNodes = deviceNodeMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(deviceNodes)) {
                logger.warn("NODE NOT FOUND");
                return null;
            }

            Map<String, List<DeviceNode>> map = deviceNodes.stream()
                    .collect(Collectors.groupingBy(o -> (o.getDeviceAddr().toString() + "," + o.getNodeId().toString())));

            List<DeviceNodeChartsVO> result = new ArrayList<>();
            for (Map.Entry<String, List<DeviceNode>> entry : map.entrySet()) {
                String key = entry.getKey();

                DeviceNodeChartsVO vo = new DeviceNodeChartsVO();
                String[] split = key.split(",");
                vo.setDeviceAddr(Integer.parseInt(split[0]));
                vo.setNodeId(Integer.parseInt(split[1]));

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
    public List<DeviceRealTimeVO> realTimeList(List<Integer> deviceAddrs, Integer pageSize1, Integer pageNum) {
        Map<String, String> param = new HashMap<>();
        param.put("deviceAddrs", StringUtils.join(deviceAddrs, ","));
        BaseResponse baseResponse = deviceHttpClient.doGet(DEVICE_BASE_URL + DEVICE_REAL_TIME_URL, param);
        if (baseResponse == null) {
            return null;
        }
        List<DeviceRealTimeVO> deviceRealTimeVOList = JSON.parseObject(baseResponse.getData().toString(), new TypeReference<List<DeviceRealTimeVO>>() {});
        return deviceRealTimeVOList;
    }
}
