package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.FarmAdviceMapper;
import com.digital.fishery.model.FarmAdvice;
import com.digital.fishery.model.FarmAdviceExample;
import com.digital.fishery.service.FarmAdviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
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
public class FarmAdviceServiceImpl implements FarmAdviceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FarmAdviceServiceImpl.class);

    @Autowired
    private FarmAdviceMapper farmAdviceMapper;

    @Override
    public int create(FarmAdvice farmAdvice) {
        farmAdvice.setCreateTime(new Date());
        return farmAdviceMapper.insert(farmAdvice);
    }

    @Override
    public int update(Long id, FarmAdvice farmAdvice) {
        farmAdvice.setId(id);
        return farmAdviceMapper.updateByPrimaryKeySelective(farmAdvice);
    }

    @Override
    public FarmAdvice getItem(Long id) {
        return farmAdviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return farmAdviceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<FarmAdvice> list(String name, Long blockId, String blockIds, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FarmAdviceExample example = new FarmAdviceExample();
//        example.setOrderByClause("sort desc");
        FarmAdviceExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (StringUtil.isNotEmpty(blockIds)) {
            List<Long> blockIdList = Arrays.stream(blockIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
            criteria.andBlockIdIn(blockIdList);
        }
        return farmAdviceMapper.selectByExample(example);
    }

}

