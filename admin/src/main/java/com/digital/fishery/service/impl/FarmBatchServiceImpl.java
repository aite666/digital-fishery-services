package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.FarmBatchMapper;
import com.digital.fishery.model.FarmBatch;
import com.digital.fishery.model.FarmBatchExample;
import com.digital.fishery.service.FarmBatchService;
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
public class FarmBatchServiceImpl implements FarmBatchService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FarmBatchServiceImpl.class);

    @Autowired
    private FarmBatchMapper farmBatchMapper;

    @Override
    public int create(FarmBatch farmBatch) {
        farmBatch.setCreateTime(new Date());
        return farmBatchMapper.insert(farmBatch);
    }

    @Override
    public int update(Long id, FarmBatch farmBatch) {
        farmBatch.setId(id);
        return farmBatchMapper.updateByPrimaryKeySelective(farmBatch);
    }

    @Override
    public FarmBatch getItem(Long id) {
        return farmBatchMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return farmBatchMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<FarmBatch> list(String code, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FarmBatchExample example = new FarmBatchExample();
//        example.setOrderByClause("sort desc");
        if (StringUtil.isNotEmpty(code)) {
            example.createCriteria().andCodeEqualTo(code);
        }
        return farmBatchMapper.selectByExample(example);
    }

}
