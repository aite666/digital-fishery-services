package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.FarmStorageMapper;
import com.digital.fishery.model.FarmStorage;
import com.digital.fishery.model.FarmStorageExample;
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
    public List<FarmStorage> list(String name, Long productCategoryId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FarmStorageExample example = new FarmStorageExample();
//        example.setOrderByClause("sort desc");
        if (StringUtil.isNotEmpty(name)) {
            example.createCriteria().andNameLike("%" + name + "%");
        }
        if (productCategoryId != null) {
            example.createCriteria().andProductCategoryIdEqualTo(productCategoryId);
        }
        return farmStorageMapper.selectByExample(example);
    }

}

