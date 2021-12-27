package com.digital.fishery.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InfoEnterpriseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InfoEnterpriseExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNull() {
            addCriterion("creation_time is null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNotNull() {
            addCriterion("creation_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeEqualTo(Date value) {
            addCriterion("creation_time =", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotEqualTo(Date value) {
            addCriterion("creation_time <>", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThan(Date value) {
            addCriterion("creation_time >", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creation_time >=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThan(Date value) {
            addCriterion("creation_time <", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThanOrEqualTo(Date value) {
            addCriterion("creation_time <=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIn(List<Date> values) {
            addCriterion("creation_time in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotIn(List<Date> values) {
            addCriterion("creation_time not in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeBetween(Date value1, Date value2) {
            addCriterion("creation_time between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotBetween(Date value1, Date value2) {
            addCriterion("creation_time not between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andBusinessContentIsNull() {
            addCriterion("business_content is null");
            return (Criteria) this;
        }

        public Criteria andBusinessContentIsNotNull() {
            addCriterion("business_content is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessContentEqualTo(String value) {
            addCriterion("business_content =", value, "businessContent");
            return (Criteria) this;
        }

        public Criteria andBusinessContentNotEqualTo(String value) {
            addCriterion("business_content <>", value, "businessContent");
            return (Criteria) this;
        }

        public Criteria andBusinessContentGreaterThan(String value) {
            addCriterion("business_content >", value, "businessContent");
            return (Criteria) this;
        }

        public Criteria andBusinessContentGreaterThanOrEqualTo(String value) {
            addCriterion("business_content >=", value, "businessContent");
            return (Criteria) this;
        }

        public Criteria andBusinessContentLessThan(String value) {
            addCriterion("business_content <", value, "businessContent");
            return (Criteria) this;
        }

        public Criteria andBusinessContentLessThanOrEqualTo(String value) {
            addCriterion("business_content <=", value, "businessContent");
            return (Criteria) this;
        }

        public Criteria andBusinessContentLike(String value) {
            addCriterion("business_content like", value, "businessContent");
            return (Criteria) this;
        }

        public Criteria andBusinessContentNotLike(String value) {
            addCriterion("business_content not like", value, "businessContent");
            return (Criteria) this;
        }

        public Criteria andBusinessContentIn(List<String> values) {
            addCriterion("business_content in", values, "businessContent");
            return (Criteria) this;
        }

        public Criteria andBusinessContentNotIn(List<String> values) {
            addCriterion("business_content not in", values, "businessContent");
            return (Criteria) this;
        }

        public Criteria andBusinessContentBetween(String value1, String value2) {
            addCriterion("business_content between", value1, value2, "businessContent");
            return (Criteria) this;
        }

        public Criteria andBusinessContentNotBetween(String value1, String value2) {
            addCriterion("business_content not between", value1, value2, "businessContent");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNull() {
            addCriterion("legal_person is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNotNull() {
            addCriterion("legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonEqualTo(String value) {
            addCriterion("legal_person =", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotEqualTo(String value) {
            addCriterion("legal_person <>", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThan(String value) {
            addCriterion("legal_person >", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person >=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThan(String value) {
            addCriterion("legal_person <", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("legal_person <=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLike(String value) {
            addCriterion("legal_person like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotLike(String value) {
            addCriterion("legal_person not like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIn(List<String> values) {
            addCriterion("legal_person in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotIn(List<String> values) {
            addCriterion("legal_person not in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonBetween(String value1, String value2) {
            addCriterion("legal_person between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotBetween(String value1, String value2) {
            addCriterion("legal_person not between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andAnnualOutputValueIsNull() {
            addCriterion("annual_output_value is null");
            return (Criteria) this;
        }

        public Criteria andAnnualOutputValueIsNotNull() {
            addCriterion("annual_output_value is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualOutputValueEqualTo(Long value) {
            addCriterion("annual_output_value =", value, "annualOutputValue");
            return (Criteria) this;
        }

        public Criteria andAnnualOutputValueNotEqualTo(Long value) {
            addCriterion("annual_output_value <>", value, "annualOutputValue");
            return (Criteria) this;
        }

        public Criteria andAnnualOutputValueGreaterThan(Long value) {
            addCriterion("annual_output_value >", value, "annualOutputValue");
            return (Criteria) this;
        }

        public Criteria andAnnualOutputValueGreaterThanOrEqualTo(Long value) {
            addCriterion("annual_output_value >=", value, "annualOutputValue");
            return (Criteria) this;
        }

        public Criteria andAnnualOutputValueLessThan(Long value) {
            addCriterion("annual_output_value <", value, "annualOutputValue");
            return (Criteria) this;
        }

        public Criteria andAnnualOutputValueLessThanOrEqualTo(Long value) {
            addCriterion("annual_output_value <=", value, "annualOutputValue");
            return (Criteria) this;
        }

        public Criteria andAnnualOutputValueIn(List<Long> values) {
            addCriterion("annual_output_value in", values, "annualOutputValue");
            return (Criteria) this;
        }

        public Criteria andAnnualOutputValueNotIn(List<Long> values) {
            addCriterion("annual_output_value not in", values, "annualOutputValue");
            return (Criteria) this;
        }

        public Criteria andAnnualOutputValueBetween(Long value1, Long value2) {
            addCriterion("annual_output_value between", value1, value2, "annualOutputValue");
            return (Criteria) this;
        }

        public Criteria andAnnualOutputValueNotBetween(Long value1, Long value2) {
            addCriterion("annual_output_value not between", value1, value2, "annualOutputValue");
            return (Criteria) this;
        }

        public Criteria andAnnualYieldIsNull() {
            addCriterion("annual_yield is null");
            return (Criteria) this;
        }

        public Criteria andAnnualYieldIsNotNull() {
            addCriterion("annual_yield is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualYieldEqualTo(Long value) {
            addCriterion("annual_yield =", value, "annualYield");
            return (Criteria) this;
        }

        public Criteria andAnnualYieldNotEqualTo(Long value) {
            addCriterion("annual_yield <>", value, "annualYield");
            return (Criteria) this;
        }

        public Criteria andAnnualYieldGreaterThan(Long value) {
            addCriterion("annual_yield >", value, "annualYield");
            return (Criteria) this;
        }

        public Criteria andAnnualYieldGreaterThanOrEqualTo(Long value) {
            addCriterion("annual_yield >=", value, "annualYield");
            return (Criteria) this;
        }

        public Criteria andAnnualYieldLessThan(Long value) {
            addCriterion("annual_yield <", value, "annualYield");
            return (Criteria) this;
        }

        public Criteria andAnnualYieldLessThanOrEqualTo(Long value) {
            addCriterion("annual_yield <=", value, "annualYield");
            return (Criteria) this;
        }

        public Criteria andAnnualYieldIn(List<Long> values) {
            addCriterion("annual_yield in", values, "annualYield");
            return (Criteria) this;
        }

        public Criteria andAnnualYieldNotIn(List<Long> values) {
            addCriterion("annual_yield not in", values, "annualYield");
            return (Criteria) this;
        }

        public Criteria andAnnualYieldBetween(Long value1, Long value2) {
            addCriterion("annual_yield between", value1, value2, "annualYield");
            return (Criteria) this;
        }

        public Criteria andAnnualYieldNotBetween(Long value1, Long value2) {
            addCriterion("annual_yield not between", value1, value2, "annualYield");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionIsNull() {
            addCriterion("fishery_position is null");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionIsNotNull() {
            addCriterion("fishery_position is not null");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionEqualTo(String value) {
            addCriterion("fishery_position =", value, "fisheryPosition");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionNotEqualTo(String value) {
            addCriterion("fishery_position <>", value, "fisheryPosition");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionGreaterThan(String value) {
            addCriterion("fishery_position >", value, "fisheryPosition");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionGreaterThanOrEqualTo(String value) {
            addCriterion("fishery_position >=", value, "fisheryPosition");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionLessThan(String value) {
            addCriterion("fishery_position <", value, "fisheryPosition");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionLessThanOrEqualTo(String value) {
            addCriterion("fishery_position <=", value, "fisheryPosition");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionLike(String value) {
            addCriterion("fishery_position like", value, "fisheryPosition");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionNotLike(String value) {
            addCriterion("fishery_position not like", value, "fisheryPosition");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionIn(List<String> values) {
            addCriterion("fishery_position in", values, "fisheryPosition");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionNotIn(List<String> values) {
            addCriterion("fishery_position not in", values, "fisheryPosition");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionBetween(String value1, String value2) {
            addCriterion("fishery_position between", value1, value2, "fisheryPosition");
            return (Criteria) this;
        }

        public Criteria andFisheryPositionNotBetween(String value1, String value2) {
            addCriterion("fishery_position not between", value1, value2, "fisheryPosition");
            return (Criteria) this;
        }

        public Criteria andFisheryNameIsNull() {
            addCriterion("fishery_name is null");
            return (Criteria) this;
        }

        public Criteria andFisheryNameIsNotNull() {
            addCriterion("fishery_name is not null");
            return (Criteria) this;
        }

        public Criteria andFisheryNameEqualTo(String value) {
            addCriterion("fishery_name =", value, "fisheryName");
            return (Criteria) this;
        }

        public Criteria andFisheryNameNotEqualTo(String value) {
            addCriterion("fishery_name <>", value, "fisheryName");
            return (Criteria) this;
        }

        public Criteria andFisheryNameGreaterThan(String value) {
            addCriterion("fishery_name >", value, "fisheryName");
            return (Criteria) this;
        }

        public Criteria andFisheryNameGreaterThanOrEqualTo(String value) {
            addCriterion("fishery_name >=", value, "fisheryName");
            return (Criteria) this;
        }

        public Criteria andFisheryNameLessThan(String value) {
            addCriterion("fishery_name <", value, "fisheryName");
            return (Criteria) this;
        }

        public Criteria andFisheryNameLessThanOrEqualTo(String value) {
            addCriterion("fishery_name <=", value, "fisheryName");
            return (Criteria) this;
        }

        public Criteria andFisheryNameLike(String value) {
            addCriterion("fishery_name like", value, "fisheryName");
            return (Criteria) this;
        }

        public Criteria andFisheryNameNotLike(String value) {
            addCriterion("fishery_name not like", value, "fisheryName");
            return (Criteria) this;
        }

        public Criteria andFisheryNameIn(List<String> values) {
            addCriterion("fishery_name in", values, "fisheryName");
            return (Criteria) this;
        }

        public Criteria andFisheryNameNotIn(List<String> values) {
            addCriterion("fishery_name not in", values, "fisheryName");
            return (Criteria) this;
        }

        public Criteria andFisheryNameBetween(String value1, String value2) {
            addCriterion("fishery_name between", value1, value2, "fisheryName");
            return (Criteria) this;
        }

        public Criteria andFisheryNameNotBetween(String value1, String value2) {
            addCriterion("fishery_name not between", value1, value2, "fisheryName");
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