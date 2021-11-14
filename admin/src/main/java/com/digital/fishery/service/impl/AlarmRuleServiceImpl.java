package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.AlarmRuleMapper;
import com.digital.fishery.model.AlarmRule;
import com.digital.fishery.model.AlarmRuleExample;
import com.digital.fishery.service.AlarmRuleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AlarmRuleServiceImpl implements AlarmRuleService {

    private static final Logger logger = LoggerFactory.getLogger(AlarmRuleServiceImpl.class);

    @Autowired
    private AlarmRuleMapper alarmRuleMapper;

    @Override
    public int create(AlarmRule alarmRule) {
        alarmRule.setCreateTime(new Date());
        return alarmRuleMapper.insert(alarmRule);
    }

    @Override
    public int update(Long id, AlarmRule alarmRule) {
        alarmRule.setId(id);
        return alarmRuleMapper.updateByPrimaryKeySelective(alarmRule);
    }

    @Override
    public AlarmRule getItem(Long id) {
        return alarmRuleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return alarmRuleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<AlarmRule> list(Long blockId, Integer type, String factorName, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        AlarmRuleExample example = new AlarmRuleExample();
        AlarmRuleExample.Criteria criteria = example.createCriteria();
        if (blockId != null) {
            criteria.andBlockIdEqualTo(blockId);
        }
        if (type != null) {
            criteria.andTypeEqualTo(type);
        }
        if (StringUtil.isNotEmpty(factorName)) {
            criteria.andFactorNameLike("%" + factorName + "%");
        }
        List<AlarmRule> AlarmRuleList = alarmRuleMapper.selectByExample(example);
        return AlarmRuleList;
    }

}
