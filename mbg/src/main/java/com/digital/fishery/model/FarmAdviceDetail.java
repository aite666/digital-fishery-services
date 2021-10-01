package com.digital.fishery.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class FarmAdviceDetail implements Serializable {
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "建议id")
    private Long adviceId;

    @ApiModelProperty(value = "建议步骤")
    private Integer step;

    @ApiModelProperty(value = "天数")
    private Integer stepDay;

    @ApiModelProperty(value = "建议标题")
    private String stepTitle;

    @ApiModelProperty(value = "建议内容")
    private String stepContent;

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

    public Long getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Long adviceId) {
        this.adviceId = adviceId;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getStepDay() {
        return stepDay;
    }

    public void setStepDay(Integer stepDay) {
        this.stepDay = stepDay;
    }

    public String getStepTitle() {
        return stepTitle;
    }

    public void setStepTitle(String stepTitle) {
        this.stepTitle = stepTitle;
    }

    public String getStepContent() {
        return stepContent;
    }

    public void setStepContent(String stepContent) {
        this.stepContent = stepContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", adviceId=").append(adviceId);
        sb.append(", step=").append(step);
        sb.append(", stepDay=").append(stepDay);
        sb.append(", stepTitle=").append(stepTitle);
        sb.append(", stepContent=").append(stepContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}