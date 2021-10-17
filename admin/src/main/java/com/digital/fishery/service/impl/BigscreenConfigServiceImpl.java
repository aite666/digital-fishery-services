package com.digital.fishery.service.impl;

import com.alibaba.fastjson.JSON;
import com.digital.fishery.mapper.BigscreenConfigMapper;
import com.digital.fishery.model.BigscreenConfig;
import com.digital.fishery.model.BigscreenConfigExample;
import com.digital.fishery.service.BigscreenConfigService;
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
public class BigscreenConfigServiceImpl implements BigscreenConfigService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BigscreenConfigServiceImpl.class);

    @Autowired
    private BigscreenConfigMapper bigscreenConfigMapper;

    @Override
    public int create(BigscreenConfig bigscreenConfig) {
        bigscreenConfig.setCreateTime(new Date());
        return bigscreenConfigMapper.insert(bigscreenConfig);
    }

    @Override
    public int update(Long id, BigscreenConfig bigscreenConfig) {
        bigscreenConfig.setId(id);
        return bigscreenConfigMapper.updateByPrimaryKeySelective(bigscreenConfig);
    }

    @Override
    public int updateByName(String name, BigscreenConfig bigscreenConfig) {
        BigscreenConfigExample example = new BigscreenConfigExample();
        if (StringUtil.isNotEmpty(name)) {
            example.createCriteria().andNameEqualTo(name);
        }
        List<BigscreenConfig> bigscreenConfigList = bigscreenConfigMapper.selectByExampleWithBLOBs(example);
        int count = 0;
        if (bigscreenConfigList.size() > 0) {
            Long id = bigscreenConfigList.get(0).getId();
            bigscreenConfig.setId(id);
            bigscreenConfig.setConfigData(JSON.toJSONString(bigscreenConfig.getConfigDataJson()));
            count = bigscreenConfigMapper.updateByPrimaryKeySelective(bigscreenConfig);
        }
        return count;
    }

    @Override
    public BigscreenConfig getItem(Long id) {
        return bigscreenConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return bigscreenConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<BigscreenConfig> list(String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        BigscreenConfigExample example = new BigscreenConfigExample();
//        example.setOrderByClause("sort desc");
        if (StringUtil.isNotEmpty(name)) {
            example.createCriteria().andNameEqualTo(name);
        }
        List<BigscreenConfig> bigscreenConfigList = bigscreenConfigMapper.selectByExampleWithBLOBs(example);
        for (BigscreenConfig bigscreenConfig : bigscreenConfigList) {
            bigscreenConfig.setConfigDataJson(JSON.parseObject(bigscreenConfig.getConfigData()));
        }
        return bigscreenConfigList;
    }

}

