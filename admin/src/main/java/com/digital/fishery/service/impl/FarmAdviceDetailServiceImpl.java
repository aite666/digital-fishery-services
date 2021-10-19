package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.FarmAdviceDetailMapper;
import com.digital.fishery.model.FarmAdviceDetail;
import com.digital.fishery.model.FarmAdviceDetailExample;
import com.digital.fishery.service.FarmAdviceDetailService;
import com.github.pagehelper.PageHelper;
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
public class FarmAdviceDetailServiceImpl implements FarmAdviceDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FarmAdviceDetailServiceImpl.class);

    @Autowired
    private FarmAdviceDetailMapper farmAdviceDetailMapper;

    @Override
    public int create(FarmAdviceDetail farmAdviceDetail) {
        farmAdviceDetail.setCreateTime(new Date());
        return farmAdviceDetailMapper.insert(farmAdviceDetail);
    }

    @Override
    public int update(Long id, FarmAdviceDetail farmAdviceDetail) {
        farmAdviceDetail.setId(id);
        return farmAdviceDetailMapper.updateByPrimaryKeySelective(farmAdviceDetail);
    }

    @Override
    public FarmAdviceDetail getItem(Long id) {
        return farmAdviceDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return farmAdviceDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateBatch(Long adviceId, List<FarmAdviceDetail> farmAdviceDetailList) {
        // 先批量删除所有adviceId的建议详情，然后新增
        FarmAdviceDetailExample example = new FarmAdviceDetailExample();
        example.createCriteria().andAdviceIdEqualTo(adviceId);
        int count = farmAdviceDetailMapper.deleteByExample(example);
        for (FarmAdviceDetail farmAdviceDetail : farmAdviceDetailList) {
            farmAdviceDetail.setCreateTime(new Date());
            count = farmAdviceDetailMapper.insert(farmAdviceDetail);
            if (count == 0) {
                break;
            }
        }
        return count;
    }

    @Override
    public List<FarmAdviceDetail> list(Long adviceId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FarmAdviceDetailExample example = new FarmAdviceDetailExample();
//        example.setOrderByClause("sort desc");
        if (adviceId != null) {
            example.createCriteria().andAdviceIdEqualTo(adviceId);
        }
        return farmAdviceDetailMapper.selectByExample(example);
    }

}

