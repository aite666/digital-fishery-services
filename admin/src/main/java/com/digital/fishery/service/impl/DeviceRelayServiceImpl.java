package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.DeviceRelayMapper;
import com.digital.fishery.model.DeviceRelay;
import com.digital.fishery.model.DeviceRelayExample;
import com.digital.fishery.service.DeviceRelayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeviceRelayServiceImpl implements DeviceRelayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceRelayServiceImpl.class);

    @Autowired
    private DeviceRelayMapper deviceRelayMapper;

    @Override
    public int create(DeviceRelay DeviceRelay) {
        DeviceRelay.setCreateTime(new Date());
        return deviceRelayMapper.insert(DeviceRelay);
    }

    @Override
    public int update(Long id, DeviceRelay DeviceRelay) {
        DeviceRelay.setId(id);
        return deviceRelayMapper.updateByPrimaryKeySelective(DeviceRelay);
    }

    @Override
    public DeviceRelay getItem(Long id) {
        return deviceRelayMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return deviceRelayMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<DeviceRelay> list(Integer relayNo, String relayName, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        DeviceRelayExample example = new DeviceRelayExample();
        if (relayNo != null) {
            example.createCriteria().andRelayNoEqualTo(relayNo);
        }
        if (StringUtil.isNotEmpty(relayName)) {
            example.createCriteria().andRelayNameEqualTo(relayName);
        }
        List<DeviceRelay> deviceRelayList = deviceRelayMapper.selectByExample(example);
        return deviceRelayList;
    }
}
