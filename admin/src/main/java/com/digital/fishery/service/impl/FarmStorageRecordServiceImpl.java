package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.FarmStorageMapper;
import com.digital.fishery.mapper.FarmStorageRecordMapper;
import com.digital.fishery.model.FarmStorage;
import com.digital.fishery.model.FarmStorageExample;
import com.digital.fishery.model.FarmStorageRecord;
import com.digital.fishery.model.FarmStorageRecordExample;
import com.digital.fishery.service.FarmStorageRecordService;
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
public class FarmStorageRecordServiceImpl implements FarmStorageRecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FarmStorageRecordServiceImpl.class);

    @Autowired
    private FarmStorageRecordMapper farmStorageRecordMapper;

    @Autowired
    private FarmStorageMapper farmStorageMapper;

    @Override
    public int create(FarmStorageRecord farmStorageRecord) {
        farmStorageRecord.setCreateTime(new Date());
        int count = farmStorageRecordMapper.insert(farmStorageRecord);
        // 当农资记录类型是出库的时候，要减去库存里面的数量
        if (count == 1 && farmStorageRecord.getType() == 2) {
            FarmStorage farmStorage = farmStorageMapper.selectByPrimaryKey(farmStorageRecord.getStorageId());
            farmStorage.setQuantity(farmStorage.getQuantity() - farmStorageRecord.getQuantity());
            farmStorageMapper.updateByPrimaryKeySelective(farmStorage);
        }
        return count;
    }

    @Override
    public int update(Long id, FarmStorageRecord farmStorageRecord) {
        farmStorageRecord.setId(id);
        return farmStorageRecordMapper.updateByPrimaryKeySelective(farmStorageRecord);
    }

    @Override
    public FarmStorageRecord getItem(Long id) {
        return farmStorageRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        FarmStorageRecord farmStorageRecord = farmStorageRecordMapper.selectByPrimaryKey(id);
        int count = farmStorageRecordMapper.deleteByPrimaryKey(id);
        // 根据农资操作记录，要反向增减库存里面的数量
        if (count == 1) {
            FarmStorage farmStorage = farmStorageMapper.selectByPrimaryKey(farmStorageRecord.getStorageId());
            if (farmStorageRecord.getType() == 1) {
                farmStorage.setQuantity(farmStorage.getQuantity() - farmStorageRecord.getQuantity());
            } else {
                farmStorage.setQuantity(farmStorage.getQuantity() + farmStorageRecord.getQuantity());
            }
            farmStorageMapper.updateByPrimaryKeySelective(farmStorage);
        }
        return count;
    }

    @Override
    public List<FarmStorageRecord> list(Long storageId, String storageName, Long blockId, Long productCategoryId, Integer type, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FarmStorageRecordExample example = new FarmStorageRecordExample();
//        example.setOrderByClause("sort desc");
        FarmStorageRecordExample.Criteria criteria =  example.createCriteria();
        if (storageId != null) {
            criteria.andStorageIdEqualTo(storageId);
        }
        if (StringUtil.isNotEmpty(storageName)) {
            criteria.andStorageNameLike("%" + storageName + "%");
        }
        if (blockId != null) {
            criteria.andBlockIdEqualTo(blockId);
        }
        if (productCategoryId != null) {
            criteria.andProductCategoryIdEqualTo(productCategoryId);
        }
        if (type != null) {
            criteria.andTypeEqualTo(type);
        }
        return farmStorageRecordMapper.selectByExample(example);
    }

    @Override
    public int confirm(Long id) {
        FarmStorageRecord farmStorageRecord = farmStorageRecordMapper.selectByPrimaryKey(id);
        int count = 0;
        if (farmStorageRecord.getStatus() == 0) {
            farmStorageRecord.setStatus(1);
            count = farmStorageRecordMapper.updateByPrimaryKeySelective(farmStorageRecord);
            if (count == 1) {
                FarmStorage farmStorage = farmStorageMapper.selectByPrimaryKey(farmStorageRecord.getStorageId());
                if (farmStorageRecord.getType() == 1) {
                    farmStorage.setQuantity(farmStorage.getQuantity() + farmStorageRecord.getQuantity());
                } else {
                    farmStorage.setQuantity(farmStorage.getQuantity() - farmStorageRecord.getQuantity());
                }
                farmStorageMapper.updateByPrimaryKeySelective(farmStorage);
            }
        }
        return count;
    }

}

