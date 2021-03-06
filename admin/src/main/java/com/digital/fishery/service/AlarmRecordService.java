package com.digital.fishery.service;

import com.digital.fishery.model.AlarmRecord;
import com.digital.fishery.model.AlarmRule;
import com.digital.fishery.model.DeviceNodeResp;

import java.util.List;

public interface AlarmRecordService {

    void sync(List<DeviceNodeResp> deviceNodeResp);

    List<AlarmRecord> list(Long userId, Long blockId, String blockIds, String description, String startTime, String endTime, Integer pageSize, Integer pageNum);

    Long count(Long userId);

    void updateStatus(Long recordId, Long userId);

    int delete(Long id);
}
