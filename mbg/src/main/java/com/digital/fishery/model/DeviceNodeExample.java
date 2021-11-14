package com.digital.fishery.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceNodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceNodeExample() {
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

        public Criteria andDeviceAddrIsNull() {
            addCriterion("device_addr is null");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrIsNotNull() {
            addCriterion("device_addr is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceAddrEqualTo(Integer value) {
            addCriterion("a.device_addr =", value, "deviceAddr");
            return (Criteria) this;
        }

        public Criteria andBlockIdEqualTo(Long value) {
            addCriterion("d.block_id =", value, "blockId");
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

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(Date value) {
            addCriterion("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(Date value) {
            addCriterion("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(Date value) {
            addCriterion("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(Date value) {
            addCriterion("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(Date value) {
            addCriterion("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<Date> values) {
            addCriterion("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<Date> values) {
            addCriterion("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(Date value1, Date value2) {
            addCriterion("a.record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(Date value1, Date value2) {
            addCriterion("record_time not between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNull() {
            addCriterion("node_id is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("node_id is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(Integer value) {
            addCriterion("a.node_id =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(Integer value) {
            addCriterion("node_id <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(Integer value) {
            addCriterion("node_id >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_id >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(Integer value) {
            addCriterion("node_id <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("node_id <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<Integer> values) {
            addCriterion("node_id in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<Integer> values) {
            addCriterion("node_id not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("node_id between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("node_id not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(Double value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(Double value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(Double value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(Double value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(Double value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(Double value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<Double> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<Double> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(Double value1, Double value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(Double value1, Double value2) {
            addCriterion("lng not between", value1, value2, "lng");
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

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(String value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(String value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(String value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(String value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(String value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLike(String value) {
            addCriterion("record_id like", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotLike(String value) {
            addCriterion("record_id not like", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<String> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<String> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(String value1, String value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(String value1, String value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrIsNull() {
            addCriterion("record_time_str is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrIsNotNull() {
            addCriterion("record_time_str is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrEqualTo(String value) {
            addCriterion("record_time_str =", value, "recordTimeStr");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrNotEqualTo(String value) {
            addCriterion("record_time_str <>", value, "recordTimeStr");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrGreaterThan(String value) {
            addCriterion("record_time_str >", value, "recordTimeStr");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrGreaterThanOrEqualTo(String value) {
            addCriterion("record_time_str >=", value, "recordTimeStr");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrLessThan(String value) {
            addCriterion("record_time_str <", value, "recordTimeStr");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrLessThanOrEqualTo(String value) {
            addCriterion("record_time_str <=", value, "recordTimeStr");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrLike(String value) {
            addCriterion("record_time_str like", value, "recordTimeStr");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrNotLike(String value) {
            addCriterion("record_time_str not like", value, "recordTimeStr");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrIn(List<String> values) {
            addCriterion("record_time_str in", values, "recordTimeStr");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrNotIn(List<String> values) {
            addCriterion("record_time_str not in", values, "recordTimeStr");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrBetween(String value1, String value2) {
            addCriterion("record_time_str between", value1, value2, "recordTimeStr");
            return (Criteria) this;
        }

        public Criteria andRecordTimeStrNotBetween(String value1, String value2) {
            addCriterion("record_time_str not between", value1, value2, "recordTimeStr");
            return (Criteria) this;
        }

        public Criteria andRegisterIdIsNull() {
            addCriterion("register_id is null");
            return (Criteria) this;
        }

        public Criteria andRegisterIdIsNotNull() {
            addCriterion("register_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterIdEqualTo(Integer value) {
            addCriterion("a.register_id =", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdNotEqualTo(Integer value) {
            addCriterion("register_id <>", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdGreaterThan(Integer value) {
            addCriterion("register_id >", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("register_id >=", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdLessThan(Integer value) {
            addCriterion("register_id <", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdLessThanOrEqualTo(Integer value) {
            addCriterion("register_id <=", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdIn(List<Integer> values) {
            addCriterion("register_id in", values, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdNotIn(List<Integer> values) {
            addCriterion("register_id not in", values, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdBetween(Integer value1, Integer value2) {
            addCriterion("register_id between", value1, value2, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("register_id not between", value1, value2, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterNameIsNull() {
            addCriterion("register_name is null");
            return (Criteria) this;
        }

        public Criteria andRegisterNameIsNotNull() {
            addCriterion("register_name is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterNameEqualTo(String value) {
            addCriterion("a.register_name =", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameNotEqualTo(String value) {
            addCriterion("register_name <>", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameGreaterThan(String value) {
            addCriterion("register_name >", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameGreaterThanOrEqualTo(String value) {
            addCriterion("register_name >=", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameLessThan(String value) {
            addCriterion("register_name <", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameLessThanOrEqualTo(String value) {
            addCriterion("register_name <=", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameLike(String value) {
            addCriterion("register_name like", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameNotLike(String value) {
            addCriterion("register_name not like", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameIn(List<String> values) {
            addCriterion("register_name in", values, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameNotIn(List<String> values) {
            addCriterion("register_name not in", values, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameBetween(String value1, String value2) {
            addCriterion("register_name between", value1, value2, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameNotBetween(String value1, String value2) {
            addCriterion("register_name not between", value1, value2, "registerName");
            return (Criteria) this;
        }

        public Criteria andTextIsNull() {
            addCriterion("text is null");
            return (Criteria) this;
        }

        public Criteria andTextIsNotNull() {
            addCriterion("text is not null");
            return (Criteria) this;
        }

        public Criteria andTextEqualTo(String value) {
            addCriterion("text =", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotEqualTo(String value) {
            addCriterion("text <>", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThan(String value) {
            addCriterion("text >", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThanOrEqualTo(String value) {
            addCriterion("text >=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThan(String value) {
            addCriterion("text <", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThanOrEqualTo(String value) {
            addCriterion("text <=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLike(String value) {
            addCriterion("text like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotLike(String value) {
            addCriterion("text not like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextIn(List<String> values) {
            addCriterion("text in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotIn(List<String> values) {
            addCriterion("text not in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextBetween(String value1, String value2) {
            addCriterion("text between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotBetween(String value1, String value2) {
            addCriterion("text not between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(Double value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(Double value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(Double value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(Double value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(Double value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(Double value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<Double> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<Double> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(Double value1, Double value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(Double value1, Double value2) {
            addCriterion("value not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelIsNull() {
            addCriterion("alarm_level is null");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelIsNotNull() {
            addCriterion("alarm_level is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelEqualTo(Integer value) {
            addCriterion("alarm_level =", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelNotEqualTo(Integer value) {
            addCriterion("alarm_level <>", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelGreaterThan(Integer value) {
            addCriterion("alarm_level >", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_level >=", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelLessThan(Integer value) {
            addCriterion("alarm_level <", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_level <=", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelIn(List<Integer> values) {
            addCriterion("alarm_level in", values, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelNotIn(List<Integer> values) {
            addCriterion("alarm_level not in", values, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelBetween(Integer value1, Integer value2) {
            addCriterion("alarm_level between", value1, value2, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_level not between", value1, value2, "alarmLevel");
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