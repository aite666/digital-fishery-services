package com.digital.fishery.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class InfoEnterprise implements Serializable {
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "公司名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "成立时间")
    private Date creationTime;

    @ApiModelProperty(value = "经营内容")
    private String businessContent;

    @ApiModelProperty(value = "法人")
    private String legalPerson;

    @ApiModelProperty(value = "年产值")
    private Long annualOutputValue;

    @ApiModelProperty(value = "年产量")
    private Long annualYield;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getBusinessContent() {
        return businessContent;
    }

    public void setBusinessContent(String businessContent) {
        this.businessContent = businessContent;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public Long getAnnualOutputValue() {
        return annualOutputValue;
    }

    public void setAnnualOutputValue(Long annualOutputValue) {
        this.annualOutputValue = annualOutputValue;
    }

    public Long getAnnualYield() {
        return annualYield;
    }

    public void setAnnualYield(Long annualYield) {
        this.annualYield = annualYield;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", creationTime=").append(creationTime);
        sb.append(", businessContent=").append(businessContent);
        sb.append(", legalPerson=").append(legalPerson);
        sb.append(", annualOutputValue=").append(annualOutputValue);
        sb.append(", annualYield=").append(annualYield);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}