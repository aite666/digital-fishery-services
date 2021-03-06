package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.FarmSaleMapper;
import com.digital.fishery.model.FarmSale;
import com.digital.fishery.model.FarmSaleExample;
import com.digital.fishery.service.FarmSaleService;
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
public class FarmSaleServiceImpl implements FarmSaleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FarmSaleServiceImpl.class);

    @Autowired
    private FarmSaleMapper farmSaleMapper;

    @Override
    public int create(FarmSale farmSale) {
        farmSale.setCreateTime(new Date());
        return farmSaleMapper.insert(farmSale);
    }

    @Override
    public int update(Long id, FarmSale farmSale) {
        farmSale.setId(id);
        return farmSaleMapper.updateByPrimaryKeySelective(farmSale);
    }

    @Override
    public FarmSale getItem(Long id) {
        return farmSaleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return farmSaleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<FarmSale> list(Long blockId, String blockIds, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FarmSaleExample example = new FarmSaleExample();
//        example.setOrderByClause("sort desc");
        FarmSaleExample.Criteria criteria = example.createCriteria();
        if (blockId != null) {
            criteria.andBlockIdEqualTo(blockId);
        }
        if (StringUtil.isNotEmpty(blockIds)) {
            List<Long> blockIdList = Arrays.stream(blockIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
            criteria.andBlockIdIn(blockIdList);
        }
        return farmSaleMapper.selectByExample(example);
    }

}

