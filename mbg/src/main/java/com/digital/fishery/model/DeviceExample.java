package com.digital.fishery.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAlarmRecordIsNull() {
            addCriterion("alarm_record is null");
            return (Criteria) this;
        }

        public Criteria andAlarmRecordIsNotNull() {
            addCriterion("alarm_record is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmRecordEqualTo(Integer value) {
            addCriterion("alarm_record =", value, "alarmRecord");
            return (Criteria) this;
        }

        public Criteria andAlarmRecordNotEqualTo(Integer value) {
            addCriterion("alarm_record <>", value, "alarmRecord");
            return (Criteria) this;
        }

        public Criteria andAlarmRecordGreaterThan(Integer value) {
            addCriterion("alarm_record >", value, "alarmRecord");
            return (Criteria) this;
        }

        public Criteria andAlarmRecordGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_record >=", value, "alarmRecord");
            return (Criteria) this;
        }

        public Criteria andAlarmRecordLessThan(Integer value) {
            addCriterion("alarm_record <", value, "alarmRecord");
            return (Criteria) this;
        }

        public Criteria andAlarmRecordLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_record <=", value, "alarmRecord");
            return (Criteria) this;
        }

        public Criteria andAlarmRecordIn(List<Integer> values) {
            addCriterion("alarm_record in", values, "alarmRecord");
            return (Criteria) this;
        }

        public Criteria andAlarmRecordNotIn(List<Integer> values) {
            addCriterion("alarm_record not in", values, "alarmRecord");
            return (Criteria) this;
        }

        public Criteria andAlarmRecordBetween(Integer value1, Integer value2) {
            addCriterion("alarm_record between", value1, value2, "alarmRecord");
            return (Criteria) this;
        }

        public Criteria andAlarmRecordNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_record not between", value1, value2, "alarmRecord");
            return (Criteria) this;
        }

        public Criteria andAlarmSwitchIsNull() {
            addCriterion("alarm_switch is null");
            return (Criteria) this;
        }

        public Criteria andAlarmSwitchIsNotNull() {
            addCriterion("alarm_switch is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmSwitchEqualTo(Integer value) {
            addCriterion("alarm_switch =", value, "alarmSwitch");
            return (Criteria) this;
        }

        public Criteria andAlarmSwitchNotEqualTo(Integer value) {
            addCriterion("alarm_switch <>", value, "alarmSwitch");
            return (Criteria) this;
        }

        public Criteria andAlarmSwitchGreaterThan(Integer value) {
            addCriterion("alarm_switch >", value, "alarmSwitch");
            return (Criteria) this;
        }

        public Criteria andAlarmSwitchGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_switch >=", value, "alarmSwitch");
            return (Criteria) this;
        }

        public Criteria andAlarmSwitchLessThan(Integer value) {
            addCriterion("alarm_switch <", value, "alarmSwitch");
            return (Criteria) this;
        }

        public Criteria andAlarmSwitchLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_switch <=", value, "alarmSwitch");
            return (Criteria) this;
        }

        public Criteria andAlarmSwitchIn(List<Integer> values) {
            addCriterion("alarm_switch in", values, "alarmSwitch");
            return (Criteria) this;
        }

        public Criteria andAlarmSwitchNotIn(List<Integer> values) {
            addCriterion("alarm_switch not in", values, "alarmSwitch");
            return (Criteria) this;
        }

        public Criteria andAlarmSwitchBetween(Integer value1, Integer value2) {
            addCriterion("alarm_switch between", value1, value2, "alarmSwitch");
            return (Criteria) this;
        }

        public Criteria andAlarmSwitchNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_switch not between", value1, value2, "alarmSwitch");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrIsNull() {
            addCriterion("device_addr is null");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrIsNotNull() {
            addCriterion("device_addr is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrEqualTo(Integer value) {
            addCriterion("device_addr =", value, "deviceAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrNotEqualTo(Integer value) {
            addCriterion("device_addr <>", value, "deviceAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrGreaterThan(Integer value) {
            addCriterion("device_addr >", value, "deviceAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_addr >=", value, "deviceAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrLessThan(Integer value) {
            addCriterion("device_addr <", value, "deviceAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrLessThanOrEqualTo(Integer value) {
            addCriterion("device_addr <=", value, "deviceAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrIn(List<Integer> values) {
            addCriterion("device_addr in", values, "deviceAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrNotIn(List<Integer> values) {
            addCriterion("device_addr not in", values, "deviceAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrBetween(Integer value1, Integer value2) {
            addCriterion("device_addr between", value1, value2, "deviceAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrNotBetween(Integer value1, Integer value2) {
            addCriterion("device_addr not between", value1, value2, "deviceAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Double value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Double value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Double value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Double value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Double value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Double value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Double> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Double> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Double value1, Double value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Double value1, Double value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("Lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("Lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(Double value) {
            addCriterion("Lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(Double value) {
            addCriterion("Lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(Double value) {
            addCriterion("Lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(Double value) {
            addCriterion("Lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(Double value) {
            addCriterion("Lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(Double value) {
            addCriterion("Lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<Double> values) {
            addCriterion("Lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<Double> values) {
            addCriterion("Lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(Double value1, Double value2) {
            addCriterion("Lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(Double value1, Double value2) {
            addCriterion("Lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andOfflineintervalIsNull() {
            addCriterion("offlineinterval is null");
            return (Criteria) this;
        }

        public Criteria andOfflineintervalIsNotNull() {
            addCriterion("offlineinterval is not null");
            return (Criteria) this;
        }

        public Criteria andOfflineintervalEqualTo(Integer value) {
            addCriterion("offlineinterval =", value, "offlineinterval");
            return (Criteria) this;
        }

        public Criteria andOfflineintervalNotEqualTo(Integer value) {
            addCriterion("offlineinterval <>", value, "offlineinterval");
            return (Criteria) this;
        }

        public Criteria andOfflineintervalGreaterThan(Integer value) {
            addCriterion("offlineinterval >", value, "offlineinterval");
            return (Criteria) this;
        }

        public Criteria andOfflineintervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("offlineinterval >=", value, "offlineinterval");
            return (Criteria) this;
        }

        public Criteria andOfflineintervalLessThan(Integer value) {
            addCriterion("offlineinterval <", value, "offlineinterval");
            return (Criteria) this;
        }

        public Criteria andOfflineintervalLessThanOrEqualTo(Integer value) {
            addCriterion("offlineinterval <=", value, "offlineinterval");
            return (Criteria) this;
        }

        public Criteria andOfflineintervalIn(List<Integer> values) {
            addCriterion("offlineinterval in", values, "offlineinterval");
            return (Criteria) this;
        }

        public Criteria andOfflineintervalNotIn(List<Integer> values) {
            addCriterion("offlineinterval not in", values, "offlineinterval");
            return (Criteria) this;
        }

        public Criteria andOfflineintervalBetween(Integer value1, Integer value2) {
            addCriterion("offlineinterval between", value1, value2, "offlineinterval");
            return (Criteria) this;
        }

        public Criteria andOfflineintervalNotBetween(Integer value1, Integer value2) {
            addCriterion("offlineinterval not between", value1, value2, "offlineinterval");
            return (Criteria) this;
        }

        public Criteria andSavedataintervalIsNull() {
            addCriterion("savedatainterval is null");
            return (Criteria) this;
        }

        public Criteria andSavedataintervalIsNotNull() {
            addCriterion("savedatainterval is not null");
            return (Criteria) this;
        }

        public Criteria andSavedataintervalEqualTo(Integer value) {
            addCriterion("savedatainterval =", value, "savedatainterval");
            return (Criteria) this;
        }

        public Criteria andSavedataintervalNotEqualTo(Integer value) {
            addCriterion("savedatainterval <>", value, "savedatainterval");
            return (Criteria) this;
        }

        public Criteria andSavedataintervalGreaterThan(Integer value) {
            addCriterion("savedatainterval >", value, "savedatainterval");
            return (Criteria) this;
        }

        public Criteria andSavedataintervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("savedatainterval >=", value, "savedatainterval");
            return (Criteria) this;
        }

        public Criteria andSavedataintervalLessThan(Integer value) {
            addCriterion("savedatainterval <", value, "savedatainterval");
            return (Criteria) this;
        }

        public Criteria andSavedataintervalLessThanOrEqualTo(Integer value) {
            addCriterion("savedatainterval <=", value, "savedatainterval");
            return (Criteria) this;
        }

        public Criteria andSavedataintervalIn(List<Integer> values) {
            addCriterion("savedatainterval in", values, "savedatainterval");
            return (Criteria) this;
        }

        public Criteria andSavedataintervalNotIn(List<Integer> values) {
            addCriterion("savedatainterval not in", values, "savedatainterval");
            return (Criteria) this;
        }

        public Criteria andSavedataintervalBetween(Integer value1, Integer value2) {
            addCriterion("savedatainterval between", value1, value2, "savedatainterval");
            return (Criteria) this;
        }

        public Criteria andSavedataintervalNotBetween(Integer value1, Integer value2) {
            addCriterion("savedatainterval not between", value1, value2, "savedatainterval");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andUseMarkLocationIsNull() {
            addCriterion("use_mark_location is null");
            return (Criteria) this;
        }

        public Criteria andUseMarkLocationIsNotNull() {
            addCriterion("use_mark_location is not null");
            return (Criteria) this;
        }

        public Criteria andUseMarkLocationEqualTo(Integer value) {
            addCriterion("use_mark_location =", value, "useMarkLocation");
            return (Criteria) this;
        }

        public Criteria andUseMarkLocationNotEqualTo(Integer value) {
            addCriterion("use_mark_location <>", value, "useMarkLocation");
            return (Criteria) this;
        }

        public Criteria andUseMarkLocationGreaterThan(Integer value) {
            addCriterion("use_mark_location >", value, "useMarkLocation");
            return (Criteria) this;
        }

        public Criteria andUseMarkLocationGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_mark_location >=", value, "useMarkLocation");
            return (Criteria) this;
        }

        public Criteria andUseMarkLocationLessThan(Integer value) {
            addCriterion("use_mark_location <", value, "useMarkLocation");
            return (Criteria) this;
        }

        public Criteria andUseMarkLocationLessThanOrEqualTo(Integer value) {
            addCriterion("use_mark_location <=", value, "useMarkLocation");
            return (Criteria) this;
        }

        public Criteria andUseMarkLocationIn(List<Integer> values) {
            addCriterion("use_mark_location in", values, "useMarkLocation");
            return (Criteria) this;
        }

        public Criteria andUseMarkLocationNotIn(List<Integer> values) {
            addCriterion("use_mark_location not in", values, "useMarkLocation");
            return (Criteria) this;
        }

        public Criteria andUseMarkLocationBetween(Integer value1, Integer value2) {
            addCriterion("use_mark_location between", value1, value2, "useMarkLocation");
            return (Criteria) this;
        }

        public Criteria andUseMarkLocationNotBetween(Integer value1, Integer value2) {
            addCriterion("use_mark_location not between", value1, value2, "useMarkLocation");
            return (Criteria) this;
        }

        public Criteria andMaxVoiceAlarmTimesIsNull() {
            addCriterion("max_voice_alarm_times is null");
            return (Criteria) this;
        }

        public Criteria andMaxVoiceAlarmTimesIsNotNull() {
            addCriterion("max_voice_alarm_times is not null");
            return (Criteria) this;
        }

        public Criteria andMaxVoiceAlarmTimesEqualTo(Integer value) {
            addCriterion("max_voice_alarm_times =", value, "maxVoiceAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxVoiceAlarmTimesNotEqualTo(Integer value) {
            addCriterion("max_voice_alarm_times <>", value, "maxVoiceAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxVoiceAlarmTimesGreaterThan(Integer value) {
            addCriterion("max_voice_alarm_times >", value, "maxVoiceAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxVoiceAlarmTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_voice_alarm_times >=", value, "maxVoiceAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxVoiceAlarmTimesLessThan(Integer value) {
            addCriterion("max_voice_alarm_times <", value, "maxVoiceAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxVoiceAlarmTimesLessThanOrEqualTo(Integer value) {
            addCriterion("max_voice_alarm_times <=", value, "maxVoiceAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxVoiceAlarmTimesIn(List<Integer> values) {
            addCriterion("max_voice_alarm_times in", values, "maxVoiceAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxVoiceAlarmTimesNotIn(List<Integer> values) {
            addCriterion("max_voice_alarm_times not in", values, "maxVoiceAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxVoiceAlarmTimesBetween(Integer value1, Integer value2) {
            addCriterion("max_voice_alarm_times between", value1, value2, "maxVoiceAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxVoiceAlarmTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("max_voice_alarm_times not between", value1, value2, "maxVoiceAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxSmsAlarmTimesIsNull() {
            addCriterion("max_sms_alarm_times is null");
            return (Criteria) this;
        }

        public Criteria andMaxSmsAlarmTimesIsNotNull() {
            addCriterion("max_sms_alarm_times is not null");
            return (Criteria) this;
        }

        public Criteria andMaxSmsAlarmTimesEqualTo(Integer value) {
            addCriterion("max_sms_alarm_times =", value, "maxSmsAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxSmsAlarmTimesNotEqualTo(Integer value) {
            addCriterion("max_sms_alarm_times <>", value, "maxSmsAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxSmsAlarmTimesGreaterThan(Integer value) {
            addCriterion("max_sms_alarm_times >", value, "maxSmsAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxSmsAlarmTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_sms_alarm_times >=", value, "maxSmsAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxSmsAlarmTimesLessThan(Integer value) {
            addCriterion("max_sms_alarm_times <", value, "maxSmsAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxSmsAlarmTimesLessThanOrEqualTo(Integer value) {
            addCriterion("max_sms_alarm_times <=", value, "maxSmsAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxSmsAlarmTimesIn(List<Integer> values) {
            addCriterion("max_sms_alarm_times in", values, "maxSmsAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxSmsAlarmTimesNotIn(List<Integer> values) {
            addCriterion("max_sms_alarm_times not in", values, "maxSmsAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxSmsAlarmTimesBetween(Integer value1, Integer value2) {
            addCriterion("max_sms_alarm_times between", value1, value2, "maxSmsAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andMaxSmsAlarmTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("max_sms_alarm_times not between", value1, value2, "maxSmsAlarmTimes");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}