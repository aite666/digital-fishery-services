package com.digital.fishery.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.mapper.FarmBatchMapper;
import com.digital.fishery.model.FarmBatch;
import com.digital.fishery.model.FarmBatchExample;
import com.digital.fishery.service.FarmBatchService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.digital.fishery.scheduled.consts.Consts.DATETIME_FORMATTER;

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
        //这里批次号按区块id和创建时间自动生成
        String code = farmBatch.getBlockId().toString() + DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
        farmBatch.setCode(code);
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
    public List<FarmBatch> list(String code, Long blockId, String blockIds, String farmTime, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FarmBatchExample example = new FarmBatchExample();
        example.setOrderByClause("a.farm_time desc");
        FarmBatchExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(code)) {
            criteria.andCodeEqualTo(code);
        }
        if (blockId != null) {
            criteria.andBlockIdEqualTo(blockId);
        }
        if (StringUtil.isNotEmpty(blockIds)) {
            List<Long> blockIdList = Arrays.stream(blockIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
            criteria.andBlockIdIn(blockIdList);
        }
        if (StringUtil.isNotEmpty(farmTime)) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMATTER);
                Date farmTimeDate = simpleDateFormat.parse(farmTime);
                criteria.andFarmTimeEqualTo(farmTimeDate);
            } catch (ParseException e) {
                LOGGER.warn("ParseException, ", e);
            }
        }
        return farmBatchMapper.selectByExample(example);
    }

    @Override
    public List<JSONObject> listProductCategory(Long blockId, String blockIds) {
        List<Long> blockIdList = null;
        if (StringUtil.isNotEmpty(blockIds)) {
            blockIdList = Arrays.stream(blockIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
        }
        List<JSONObject> list = farmBatchMapper.listProductCategory(blockId, blockIdList);
        for (JSONObject item : list) {
            String batchQuantitys = item.get("batchQuantitys").toString();
            String batchUnits = item.get("batchUnits").toString();
            String[] batchQuantityLsit = batchQuantitys.split(",");
            String[] batchUnitList = batchUnits.split(",");
            HashMap<String, Integer> map = new HashMap<>();
            for (int i=0; i< batchUnitList.length; i++) {
                String batchUnit = batchUnitList[i];
                Integer batchQuantity = Integer.parseInt(batchQuantityLsit[i]);
                if (map.get(batchUnit) == null) {
                    map.put(batchUnit, batchQuantity);
                } else {
                    map.put(batchUnit, batchQuantity + map.get(batchUnit));
                }
            }
            List<String> batchTotalList = new ArrayList();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                batchTotalList.add(entry.getValue().toString() + entry.getKey());
            }
            String batchTotal = String.join(",", batchTotalList);
            item.put("batchTotal", batchTotal);
        }
        return list;
    }

}

