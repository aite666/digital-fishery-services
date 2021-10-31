package com.digital.fishery.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class DeviceFactor implements Serializable {
    private Long id;

    @ApiModelProperty(value = "因子图标")
    private String factorIcon;

    @ApiModelProperty(value = "因子id")
    private String factorId;

    @ApiModelProperty(value = "因子名称")
    private String factorName;

    @ApiModelProperty(value = "节点id")
    private Integer nodeId;

    @ApiModelProperty(value = "偏差")
    private Double offset;

    @ApiModelProperty(value = "寄存器id")
    private Integer registerId;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "报警延时(分钟)")
    private Integer alarmDelay;

    @ApiModelProperty(value = "报警频率")
    private Integer alarmRate;

    @ApiModelProperty(value = "系数")
    private Integer coefficient;

    @ApiModelProperty(value = "设备地址")
    private Integer deviceAddr;

    @ApiModelProperty(value = "小数位数")
    private String digits;

    @ApiModelProperty(value = "是否启用")
    private Integer enabled;

    @ApiModelProperty(value = "排序权重")
    private Integer sort;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用")
    private Integer status;

    @ApiModelProperty(value = "区块Id")
    private Long blockId;

    @ApiModelProperty(value = "区块名称")
    private String blockName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFactorIcon() {
        return factorIcon;
    }

    public void setFactorIcon(String factorIcon) {
        this.factorIcon = factorIcon;
    }

    public String getFactorId() {
        return factorId;
    }

    public void setFactorId(String factorId) {
        this.factorId = factorId;
    }

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Double getOffset() {
        return offset;
    }

    public void setOffset(Double offset) {
        this.offset = offset;
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getAlarmDelay() {
        return alarmDelay;
    }

    public void setAlarmDelay(Integer alarmDelay) {
        this.alarmDelay = alarmDelay;
    }

    public Integer getAlarmRate() {
        return alarmRate;
    }

    public void setAlarmRate(Integer alarmRate) {
        this.alarmRate = alarmRate;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public Integer getDeviceAddr() {
        return deviceAddr;
    }

    public void setDeviceAddr(Integer deviceAddr) {
        this.deviceAddr = deviceAddr;
    }

    public String getDigits() {
        return digits;
    }

    public void setDigits(String digits) {
        this.digits = digits;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", factorIcon=").append(factorIcon);
        sb.append(", factorId=").append(factorId);
        sb.append(", factorName=").append(factorName);
        sb.append(", nodeId=").append(nodeId);
        sb.append(", offset=").append(offset);
        sb.append(", registerId=").append(registerId);
        sb.append(", unit=").append(unit);
        sb.append(", alarmDelay=").append(alarmDelay);
        sb.append(", alarmRate=").append(alarmRate);
        sb.append(", coefficient=").append(coefficient);
        sb.append(", deviceAddr=").append(deviceAddr);
        sb.append(", digits=").append(digits);
        sb.append(", enabled=").append(enabled);
        sb.append(", sort=").append(sort);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}