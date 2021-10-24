package com.digital.fishery.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class DeviceRelay implements Serializable {
    private Long id;

    @ApiModelProperty(value = "设备地址")
    private Integer deviceAddr;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "是否启用")
    private String enabled;

    @ApiModelProperty(value = "继电器名称")
    private String relayName;

    @ApiModelProperty(value = "继电器编号")
    private Integer relayNo;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用")
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeviceAddr() {
        return deviceAddr;
    }

    public void setDeviceAddr(Integer deviceAddr) {
        this.deviceAddr = deviceAddr;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getRelayName() {
        return relayName;
    }

    public void setRelayName(String relayName) {
        this.relayName = relayName;
    }

    public Integer getRelayNo() {
        return relayNo;
    }

    public void setRelayNo(Integer relayNo) {
        this.relayNo = relayNo;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deviceAddr=").append(deviceAddr);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", enabled=").append(enabled);
        sb.append(", relayName=").append(relayName);
        sb.append(", relayNo=").append(relayNo);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}