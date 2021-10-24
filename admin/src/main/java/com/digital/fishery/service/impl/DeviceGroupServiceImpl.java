package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.DeviceGroupMapper;
import com.digital.fishery.model.DeviceGroup;
import com.digital.fishery.model.DeviceGroupExample;
import com.digital.fishery.service.DeviceGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by qianhan on 2021-09-19
 */
@Service
public class DeviceGroupServiceImpl implements DeviceGroupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceGroupServiceImpl.class);

    @Autowired
    private DeviceGroupMapper deviceGroupMapper;

    @Override
    public int create(DeviceGroup deviceGroup) {
        deviceGroup.setCreateTime(new Date());
        return deviceGroupMapper.insert(deviceGroup);
    }

    @Override
    public int update(Long id, DeviceGroup deviceGroup) {
        deviceGroup.setId(id);
        return deviceGroupMapper.updateByPrimaryKeySelective(deviceGroup);
    }

    @Override
    public DeviceGroup getItem(Long id) {
        return deviceGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return deviceGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<DeviceGroup> list(String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        DeviceGroupExample example = new DeviceGroupExample();
        if (StringUtil.isNotEmpty(name)) {
            example.createCriteria().andNameEqualTo(name);
        }
        List<DeviceGroup> deviceGroupList = deviceGroupMapper.selectByExample(example);
        return deviceGroupList;
    }

}

