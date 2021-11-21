package com.digital.fishery.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.mapper.FarmBatchOutMapper;
import com.digital.fishery.model.FarmBatchExample;
import com.digital.fishery.model.FarmBatchOut;
import com.digital.fishery.model.FarmBatchOutExample;
import com.digital.fishery.service.FarmBatchOutService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by qianhan on 2021-09-19
 */
@Service
public class FarmBatchOutServiceImpl implements FarmBatchOutService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FarmBatchOutServiceImpl.class);

    @Autowired
    private FarmBatchOutMapper farmBatchOutMapper;

    @Override
    public int create(FarmBatchOut farmBatchOut) {
        farmBatchOut.setCreateTime(new Date());
        return farmBatchOutMapper.insert(farmBatchOut);
    }

    @Override
    public int update(Long id, FarmBatchOut farmBatchOut) {
        farmBatchOut.setId(id);
        return farmBatchOutMapper.updateByPrimaryKeySelective(farmBatchOut);
    }

    @Override
    public FarmBatchOut getItem(Long id) {
        return farmBatchOutMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return farmBatchOutMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<FarmBatchOut> list(String batchCode, Long blockId, String blockIds, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FarmBatchOutExample example = new FarmBatchOutExample();
        FarmBatchOutExample.Criteria criteria = example.createCriteria();
//        example.setOrderByClause("sort desc");
        if (StringUtil.isNotEmpty(batchCode)) {
            criteria.andBatchCodeEqualTo(batchCode);
        }
        if (blockId != null) {
            criteria.andBlockIdEqualTo(blockId);
        }
        if (StringUtil.isNotEmpty(blockIds)) {
            List<Long> blockIdList = Arrays.stream(blockIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
            criteria.andBlockIdIn(blockIdList);
        }
        return farmBatchOutMapper.selectByExample(example);
    }

    @Override
    public long count(String batchCode, Long blockId) {
        FarmBatchOutExample example = new FarmBatchOutExample();
        FarmBatchOutExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(batchCode)) {
            criteria.andBatchCodeEqualTo(batchCode);
        }
        if (blockId != null) {
            criteria.andBlockIdEqualTo(blockId);
        }
        return farmBatchOutMapper.countByExample(example);

    }

}

