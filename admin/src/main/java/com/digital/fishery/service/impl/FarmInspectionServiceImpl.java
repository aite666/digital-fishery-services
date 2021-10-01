package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.FarmInspectionMapper;
import com.digital.fishery.model.FarmInspection;
import com.digital.fishery.model.FarmInspectionExample;
import com.digital.fishery.service.FarmInspectionService;
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
public class FarmInspectionServiceImpl implements FarmInspectionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FarmInspectionServiceImpl.class);

    @Autowired
    private FarmInspectionMapper farmInspectionMapper;

    @Override
    public int create(FarmInspection farmInspection) {
        farmInspection.setCreateTime(new Date());
        return farmInspectionMapper.insert(farmInspection);
    }

    @Override
    public int update(Long id, FarmInspection farmInspection) {
        farmInspection.setId(id);
        return farmInspectionMapper.updateByPrimaryKeySelective(farmInspection);
    }

    @Override
    public FarmInspection getItem(Long id) {
        return farmInspectionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return farmInspectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<FarmInspection> list(Long blockId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FarmInspectionExample example = new FarmInspectionExample();
//        example.setOrderByClause("sort desc");
        if (blockId != null) {
            example.createCriteria().andBlockIdEqualTo(blockId);
        }
        return farmInspectionMapper.selectByExample(example);
    }

}

