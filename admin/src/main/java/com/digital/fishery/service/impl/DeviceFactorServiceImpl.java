package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.DeviceFactorMapper;
import com.digital.fishery.model.DeviceFactor;
import com.digital.fishery.model.DeviceFactorExample;
import com.digital.fishery.service.DeviceFactorService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeviceFactorServiceImpl implements DeviceFactorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceFactorServiceImpl.class);

    @Autowired
    private DeviceFactorMapper deviceFactorMapper;

    @Override
    public int create(DeviceFactor DeviceFactor) {
        DeviceFactor.setCreateTime(new Date());
        return deviceFactorMapper.insert(DeviceFactor);
    }

    @Override
    public int update(Long id, DeviceFactor DeviceFactor) {
        DeviceFactor.setId(id);
        return deviceFactorMapper.updateByPrimaryKeySelective(DeviceFactor);
    }

    @Override
    public DeviceFactor getItem(Long id) {
        return deviceFactorMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return deviceFactorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<DeviceFactor> list(String factorId, String factorName, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        DeviceFactorExample example = new DeviceFactorExample();
        if (StringUtils.isNotBlank(factorId)) {
            example.createCriteria().andFactorIdEqualTo(factorId);
        }
        if (StringUtils.isNotBlank(factorName)) {
            example.createCriteria().andFactorNameEqualTo(factorName);
        }
        List<DeviceFactor> deviceFactorList = deviceFactorMapper.selectByExample(example);
        return deviceFactorList;
    }
}
