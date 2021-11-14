package com.digital.fishery.service;

import com.digital.fishery.model.AlarmRule;

import java.util.List;

public interface AlarmRuleService {

    int create(AlarmRule alarmRule);

    int update(Long id, AlarmRule alarmRule);

    AlarmRule getItem(Long id);

    int delete(Long id);

    List<AlarmRule> list(Long blockId, Integer type, String factorName, Integer pageSize, Integer pageNum);
}
