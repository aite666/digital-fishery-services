package com.digital.fishery.model;

import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class InfoBlock implements Serializable {
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "区块名称")
    private String name;

    @ApiModelProperty(value = "区块描述")
    private String description;

    @ApiModelProperty(value = "面积(亩)")
    private Double area;

    @ApiModelProperty(value = "状态")
    private Byte status;

    @ApiModelProperty(value = "类型")
    private Byte type;

    @ApiModelProperty(value = "公司id")
    private Long enterpriseId;

    @ApiModelProperty(value = "公司名称")
    private String enterpriseName;

    @ApiModelProperty(value = "坐标数据")
    private String position;

    @ApiModelProperty(value = "坐标数据Json")
    private JSONArray positionJson;

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

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public JSONArray getPositionJson() {
        return positionJson;
    }

    public void setPositionJson(JSONArray positionJson) {
        this.positionJson = positionJson;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
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
        sb.append(", area=").append(area);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", position=").append(position);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}