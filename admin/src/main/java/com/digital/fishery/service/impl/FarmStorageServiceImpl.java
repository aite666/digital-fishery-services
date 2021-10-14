package com.digital.fishery.service.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.mapper.FarmStorageMapper;
import com.digital.fishery.mapper.FarmStorageRecordMapper;
import com.digital.fishery.model.FarmStorage;
import com.digital.fishery.model.FarmStorageExample;
import com.digital.fishery.model.FarmStorageRecordExample;
import com.digital.fishery.service.FarmStorageService;
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
public class FarmStorageServiceImpl implements FarmStorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FarmStorageServiceImpl.class);

    @Autowired
    private FarmStorageMapper farmStorageMapper;

    @Autowired
    private FarmStorageRecordMapper farmStorageRecordMapper;

    @Override
    public int create(FarmStorage farmStorage) {
        farmStorage.setCreateTime(new Date());
        return farmStorageMapper.insert(farmStorage);
    }

    @Override
    public int update(Long id, FarmStorage farmStorage) {
        farmStorage.setId(id);
        return farmStorageMapper.updateByPrimaryKeySelective(farmStorage);
    }

    @Override
    public FarmStorage getItem(Long id) {
        return farmStorageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return farmStorageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<FarmStorage> list(String name, Long productCategoryId, Boolean thresholdVisible, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FarmStorageExample example = new FarmStorageExample();
//        example.setOrderByClause("sort desc");
        FarmStorageExample.Criteria criteria =  example.createCriteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (productCategoryId != null) {
            criteria.andProductCategoryIdEqualTo(productCategoryId);
        }
        if (thresholdVisible != null && thresholdVisible) {
            criteria.andThresholdVisible();
        }
        return farmStorageMapper.selectByExample(example);
    }

    @Override
    public JSONObject stats() {
        // 查询本月出库记录数，入库记录数，偏少农资数和偏多农资数
        String now = DateUtil.now();
        Date date = DateUtil.parse(now);
        FarmStorageRecordExample recordExample = new FarmStorageRecordExample();
        recordExample.createCriteria()
                     .andRecordTimeBetween(DateUtil.beginOfMonth(date), DateUtil.endOfMonth(date))
                     .andTypeEqualTo(1);
        long inNum = farmStorageRecordMapper.countByExample(recordExample);
        FarmStorageRecordExample recordExample2 = new FarmStorageRecordExample();
        recordExample2.createCriteria()
                .andRecordTimeBetween(DateUtil.beginOfMonth(date), DateUtil.endOfMonth(date))
                .andTypeEqualTo(2);
        long outNum = farmStorageRecordMapper.countByExample(recordExample2);
        JSONObject result = farmStorageMapper.selectThresholdStats();
        result.put("inNum", inNum);
        result.put("outNum", outNum);
        return result;
    }

}

