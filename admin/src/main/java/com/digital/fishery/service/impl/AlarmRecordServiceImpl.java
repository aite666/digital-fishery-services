package com.digital.fishery.service.impl;

import com.digital.fishery.consts.AlarmContactRecordStatus;
import com.digital.fishery.consts.OperatorType;
import com.digital.fishery.mapper.*;
import com.digital.fishery.model.*;
import com.digital.fishery.service.AlarmRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.digital.fishery.scheduled.consts.Consts.DATETIME_FORMATTER;

@Service
public class AlarmRecordServiceImpl implements AlarmRecordService {

    private static final Logger logger = LoggerFactory.getLogger(AlarmRecordServiceImpl.class);

    @Autowired
    private AlarmRuleMapper alarmRuleMapper;
    @Autowired
    private AlarmRecordMapper alarmRecordMapper;
    @Autowired
    private AlarmContactRecordMapper alarmContactRecordMapper;
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private InfoBlockMapper infoBlockMapper;
    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Override
    public void sync(List<DeviceNodeResp> deviceNodeResp) {
        for (DeviceNodeResp deviceNode : deviceNodeResp) {
            List<DeviceNodeResp.RegisterData> data = deviceNode.getData();
            Integer deviceAddr = deviceNode.getDeviceAddr();
            DeviceExample deviceExample = new DeviceExample();
            deviceExample.createCriteria().andDeviceAddrEqualTo(deviceAddr);
            List<Device> devices = deviceMapper.selectByExample(deviceExample);
            if (CollectionUtils.isEmpty(devices)) {
                continue;
            }
            List<Long> blockIds = devices.stream().map(Device::getBlockId).collect(Collectors.toList());
            for (DeviceNodeResp.RegisterData nodeData : data) {
                // 设备节点值
                String registerName = nodeData.getRegisterName();
                Double value = nodeData.getValue();

                List<AlarmRule> alarmRules = new ArrayList<>();
                for (Long blockId : blockIds) {
                    // 告警规则
                    AlarmRuleExample alarmRuleExample = new AlarmRuleExample();
                    alarmRuleExample.createCriteria().andFactorNameEqualTo(registerName);
                    alarmRuleExample.createCriteria().andBlockIdEqualTo(blockId);
                    alarmRules.addAll(alarmRuleMapper.selectByExample(alarmRuleExample));
                }
                if (CollectionUtils.isEmpty(alarmRules)) {
                    continue;
                }

                for (AlarmRule alarmRule : alarmRules) {
                    switch (alarmRule.getOperator()) {
                        case OperatorType.EQUAL:
                            if (value.equals(alarmRule.getThreshold())) {
                                insertAlarmRecord(nodeData, alarmRule);
                            }
                            break;
                        case OperatorType.NOT_EQUAL:
                            if (!value.equals(alarmRule.getThreshold())) {
                                insertAlarmRecord(nodeData, alarmRule);
                            }
                            break;
                        case OperatorType.GREATER_THAN:
                            if (value > alarmRule.getThreshold()) {
                                insertAlarmRecord(nodeData, alarmRule);
                            }
                            break;
                        case OperatorType.LESS_THAN:
                            if (value < alarmRule.getThreshold()) {
                                insertAlarmRecord(nodeData, alarmRule);
                            }
                            break;
                        case OperatorType.GREATER_EQUAL:
                            if (value >= alarmRule.getThreshold()) {
                                insertAlarmRecord(nodeData, alarmRule);
                            }
                            break;
                        case OperatorType.LESS_EQUAL:
                            if (value <= alarmRule.getThreshold()) {
                                insertAlarmRecord(nodeData, alarmRule);
                            }
                            break;
                    }
                }
            }
        }
    }

    @Override
    public List<AlarmRecord> list(Long userId, Long blockId, String description, String startTime, String endTime, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        AlarmRecordExample example = new AlarmRecordExample();
        AlarmRecordExample.Criteria recordCriteria = example.createCriteria();
        if (userId != null) {
            AlarmContactRecordExample alarmContactRecordExample = new AlarmContactRecordExample();
            AlarmContactRecordExample.Criteria criteria = alarmContactRecordExample.createCriteria();
            criteria.andUserIdEqualTo(userId);
            List<AlarmContactRecord> alarmContactRecords = alarmContactRecordMapper.selectByExample(alarmContactRecordExample);
            if (CollectionUtils.isEmpty(alarmContactRecords)) {
                return new ArrayList<>();
            }
            List<Long> recordIds = alarmContactRecords.stream().map(AlarmContactRecord::getRecordId).collect(Collectors.toList());
            recordCriteria.andIdIn(recordIds);
        }
        if (blockId != null) {
            AlarmRuleExample alarmRuleExample = new AlarmRuleExample();
            alarmRuleExample.createCriteria().andBlockIdEqualTo(blockId);
            List<AlarmRule> alarmRules = alarmRuleMapper.selectByExample(alarmRuleExample);
            if (CollectionUtils.isEmpty(alarmRules)) {
                return new ArrayList<>();
            }
            List<Long> ruleIds = alarmRules.stream().map(AlarmRule::getId).collect(Collectors.toList());
            recordCriteria.andRuleIdIn(ruleIds);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMATTER);
        if (StringUtil.isNotEmpty(description)) {
            recordCriteria.andDescriptionLike("%" + description + "%");
        }
        try {
            if (StringUtil.isNotEmpty(startTime)) {
                recordCriteria.andAlarmTimeGreaterThanOrEqualTo(simpleDateFormat.parse(startTime));
            }
            if (StringUtil.isNotEmpty(endTime)) {
                recordCriteria.andAlarmTimeLessThanOrEqualTo(simpleDateFormat.parse(endTime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return alarmRecordMapper.selectByExample(example);
    }

    @Override
    public Long count(Long userId) {
        AlarmContactRecordExample example = new AlarmContactRecordExample();
        example.createCriteria().andUserIdEqualTo(userId);
        example.createCriteria().andStatusEqualTo(AlarmContactRecordStatus.UNREAD);
        return alarmContactRecordMapper.countByExample(example);
    }

    @Override
    public void updateStatus(Long recordId, Long userId) {
        AlarmContactRecord record = new AlarmContactRecord();
        if (recordId != null) {
            record.setRecordId(recordId);
        }
        if (userId != null) {
            record.setUserId(userId);
        }
        record.setStatus(AlarmContactRecordStatus.READ);
        alarmContactRecordMapper.updateByExample(record, new AlarmContactRecordExample());
    }

    private void insertAlarmRecord(DeviceNodeResp.RegisterData data, AlarmRule alarmRule) {
        AlarmRecord alarmRecord = new AlarmRecord();
        alarmRecord.setRuleId(alarmRule.getId());
        String description = "区块" + alarmRule.getBlockId() + alarmRule.getFactorName() + alarmRule.getOperator() + "阈值"
                + alarmRule.getThreshold() + "，当前值为" + data.getValue();
        alarmRecord.setDescription(description);
        alarmRecord.setAlarmTime(new Date());
        alarmRecord.setCreateTime(new Date());
        alarmRecordMapper.insert(alarmRecord);

        // 查询用户
        InfoBlock infoBlock = infoBlockMapper.selectByPrimaryKey(alarmRule.getBlockId());
        if (infoBlock == null) {
            logger.info("未绑定企业");
            return;
        }
        UmsAdminExample umsAdminExample = new UmsAdminExample();
        umsAdminExample.createCriteria().andEnterpriseIdEqualTo(infoBlock.getEnterpriseId());
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectByExample(umsAdminExample);
        List<Long> userIds = umsAdmins.stream().distinct().map(UmsAdmin::getId).collect(Collectors.toList());
        for (Long userId : userIds) {
            AlarmContactRecord alarmContactRecord = new AlarmContactRecord();
            alarmContactRecord.setRecordId(alarmRecord.getId());
            alarmContactRecord.setUserId(userId);
            alarmContactRecord.setAlarmStatus(AlarmContactRecordStatus.UNREAD);
            alarmContactRecord.setCreateTime(new Date());
            alarmContactRecordMapper.insert(alarmContactRecord);
        }
    }

    @Override
    public int delete(Long id) {
        return alarmRecordMapper.deleteByPrimaryKey(id);
    }

}
