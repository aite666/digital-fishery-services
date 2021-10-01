package com.digital.fishery.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FarmAdviceDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FarmAdviceDetailExample() {
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

        public Criteria andAdviceIdIsNull() {
            addCriterion("advice_id is null");
            return (Criteria) this;
        }

        public Criteria andAdviceIdIsNotNull() {
            addCriterion("advice_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceIdEqualTo(Long value) {
            addCriterion("advice_id =", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdNotEqualTo(Long value) {
            addCriterion("advice_id <>", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdGreaterThan(Long value) {
            addCriterion("advice_id >", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("advice_id >=", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdLessThan(Long value) {
            addCriterion("advice_id <", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdLessThanOrEqualTo(Long value) {
            addCriterion("advice_id <=", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdIn(List<Long> values) {
            addCriterion("advice_id in", values, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdNotIn(List<Long> values) {
            addCriterion("advice_id not in", values, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdBetween(Long value1, Long value2) {
            addCriterion("advice_id between", value1, value2, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdNotBetween(Long value1, Long value2) {
            addCriterion("advice_id not between", value1, value2, "adviceId");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(Integer value) {
            addCriterion("step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(Integer value) {
            addCriterion("step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(Integer value) {
            addCriterion("step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(Integer value) {
            addCriterion("step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(Integer value) {
            addCriterion("step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<Integer> values) {
            addCriterion("step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<Integer> values) {
            addCriterion("step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(Integer value1, Integer value2) {
            addCriterion("step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(Integer value1, Integer value2) {
            addCriterion("step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepDayIsNull() {
            addCriterion("step_day is null");
            return (Criteria) this;
        }

        public Criteria andStepDayIsNotNull() {
            addCriterion("step_day is not null");
            return (Criteria) this;
        }

        public Criteria andStepDayEqualTo(Integer value) {
            addCriterion("step_day =", value, "stepDay");
            return (Criteria) this;
        }

        public Criteria andStepDayNotEqualTo(Integer value) {
            addCriterion("step_day <>", value, "stepDay");
            return (Criteria) this;
        }

        public Criteria andStepDayGreaterThan(Integer value) {
            addCriterion("step_day >", value, "stepDay");
            return (Criteria) this;
        }

        public Criteria andStepDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("step_day >=", value, "stepDay");
            return (Criteria) this;
        }

        public Criteria andStepDayLessThan(Integer value) {
            addCriterion("step_day <", value, "stepDay");
            return (Criteria) this;
        }

        public Criteria andStepDayLessThanOrEqualTo(Integer value) {
            addCriterion("step_day <=", value, "stepDay");
            return (Criteria) this;
        }

        public Criteria andStepDayIn(List<Integer> values) {
            addCriterion("step_day in", values, "stepDay");
            return (Criteria) this;
        }

        public Criteria andStepDayNotIn(List<Integer> values) {
            addCriterion("step_day not in", values, "stepDay");
            return (Criteria) this;
        }

        public Criteria andStepDayBetween(Integer value1, Integer value2) {
            addCriterion("step_day between", value1, value2, "stepDay");
            return (Criteria) this;
        }

        public Criteria andStepDayNotBetween(Integer value1, Integer value2) {
            addCriterion("step_day not between", value1, value2, "stepDay");
            return (Criteria) this;
        }

        public Criteria andStepTitleIsNull() {
            addCriterion("step_title is null");
            return (Criteria) this;
        }

        public Criteria andStepTitleIsNotNull() {
            addCriterion("step_title is not null");
            return (Criteria) this;
        }

        public Criteria andStepTitleEqualTo(String value) {
            addCriterion("step_title =", value, "stepTitle");
            return (Criteria) this;
        }

        public Criteria andStepTitleNotEqualTo(String value) {
            addCriterion("step_title <>", value, "stepTitle");
            return (Criteria) this;
        }

        public Criteria andStepTitleGreaterThan(String value) {
            addCriterion("step_title >", value, "stepTitle");
            return (Criteria) this;
        }

        public Criteria andStepTitleGreaterThanOrEqualTo(String value) {
            addCriterion("step_title >=", value, "stepTitle");
            return (Criteria) this;
        }

        public Criteria andStepTitleLessThan(String value) {
            addCriterion("step_title <", value, "stepTitle");
            return (Criteria) this;
        }

        public Criteria andStepTitleLessThanOrEqualTo(String value) {
            addCriterion("step_title <=", value, "stepTitle");
            return (Criteria) this;
        }

        public Criteria andStepTitleLike(String value) {
            addCriterion("step_title like", value, "stepTitle");
            return (Criteria) this;
        }

        public Criteria andStepTitleNotLike(String value) {
            addCriterion("step_title not like", value, "stepTitle");
            return (Criteria) this;
        }

        public Criteria andStepTitleIn(List<String> values) {
            addCriterion("step_title in", values, "stepTitle");
            return (Criteria) this;
        }

        public Criteria andStepTitleNotIn(List<String> values) {
            addCriterion("step_title not in", values, "stepTitle");
            return (Criteria) this;
        }

        public Criteria andStepTitleBetween(String value1, String value2) {
            addCriterion("step_title between", value1, value2, "stepTitle");
            return (Criteria) this;
        }

        public Criteria andStepTitleNotBetween(String value1, String value2) {
            addCriterion("step_title not between", value1, value2, "stepTitle");
            return (Criteria) this;
        }

        public Criteria andStepContentIsNull() {
            addCriterion("step_content is null");
            return (Criteria) this;
        }

        public Criteria andStepContentIsNotNull() {
            addCriterion("step_content is not null");
            return (Criteria) this;
        }

        public Criteria andStepContentEqualTo(String value) {
            addCriterion("step_content =", value, "stepContent");
            return (Criteria) this;
        }

        public Criteria andStepContentNotEqualTo(String value) {
            addCriterion("step_content <>", value, "stepContent");
            return (Criteria) this;
        }

        public Criteria andStepContentGreaterThan(String value) {
            addCriterion("step_content >", value, "stepContent");
            return (Criteria) this;
        }

        public Criteria andStepContentGreaterThanOrEqualTo(String value) {
            addCriterion("step_content >=", value, "stepContent");
            return (Criteria) this;
        }

        public Criteria andStepContentLessThan(String value) {
            addCriterion("step_content <", value, "stepContent");
            return (Criteria) this;
        }

        public Criteria andStepContentLessThanOrEqualTo(String value) {
            addCriterion("step_content <=", value, "stepContent");
            return (Criteria) this;
        }

        public Criteria andStepContentLike(String value) {
            addCriterion("step_content like", value, "stepContent");
            return (Criteria) this;
        }

        public Criteria andStepContentNotLike(String value) {
            addCriterion("step_content not like", value, "stepContent");
            return (Criteria) this;
        }

        public Criteria andStepContentIn(List<String> values) {
            addCriterion("step_content in", values, "stepContent");
            return (Criteria) this;
        }

        public Criteria andStepContentNotIn(List<String> values) {
            addCriterion("step_content not in", values, "stepContent");
            return (Criteria) this;
        }

        public Criteria andStepContentBetween(String value1, String value2) {
            addCriterion("step_content between", value1, value2, "stepContent");
            return (Criteria) this;
        }

        public Criteria andStepContentNotBetween(String value1, String value2) {
            addCriterion("step_content not between", value1, value2, "stepContent");
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