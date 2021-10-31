package com.digital.fishery.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Device implements Serializable {
    private Long id;

    @ApiModelProperty(value = "是否保存报警数据    0:不保存 1:保存")
    private Integer alarmRecord;

    @ApiModelProperty(value = "报警开关  1:离线报警 2:超限报警")
    private Integer alarmSwitch;

    @ApiModelProperty(value = "设备地址码")
    private Integer deviceAddr;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "分组id")
    private String groupId;

    @ApiModelProperty(value = "纬度")
    private Double lat;

    @ApiModelProperty(value = "经度")
    private Double lng;

    @ApiModelProperty(value = "离线判断间隔")
    private Integer offlineinterval;

    @ApiModelProperty(value = "保存数据间隔")
    private Integer savedatainterval;

    @ApiModelProperty(value = "排序权重")
    private Integer sort;

    @ApiModelProperty(value = "使用标记经纬度")
    private Integer useMarkLocation;

    private Integer maxVoiceAlarmTimes;

    private Integer maxSmsAlarmTimes;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用")
    private Integer status;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "区块id")
    private Long blockId;

    @ApiModelProperty(value = "区块名称")
    private String blockName;

    @ApiModelProperty(value = "因子")
    private List<DeviceFactor> factors;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAlarmRecord() {
        return alarmRecord;
    }

    public void setAlarmRecord(Integer alarmRecord) {
        this.alarmRecord = alarmRecord;
    }

    public Integer getAlarmSwitch() {
        return alarmSwitch;
    }

    public void setAlarmSwitch(Integer alarmSwitch) {
        this.alarmSwitch = alarmSwitch;
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Integer getOfflineinterval() {
        return offlineinterval;
    }

    public void setOfflineinterval(Integer offlineinterval) {
        this.offlineinterval = offlineinterval;
    }

    public Integer getSavedatainterval() {
        return savedatainterval;
    }

    public void setSavedatainterval(Integer savedatainterval) {
        this.savedatainterval = savedatainterval;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getUseMarkLocation() {
        return useMarkLocation;
    }

    public void setUseMarkLocation(Integer useMarkLocation) {
        this.useMarkLocation = useMarkLocation;
    }

    public Integer getMaxVoiceAlarmTimes() {
        return maxVoiceAlarmTimes;
    }

    public void setMaxVoiceAlarmTimes(Integer maxVoiceAlarmTimes) {
        this.maxVoiceAlarmTimes = maxVoiceAlarmTimes;
    }

    public Integer getMaxSmsAlarmTimes() {
        return maxSmsAlarmTimes;
    }

    public void setMaxSmsAlarmTimes(Integer maxSmsAlarmTimes) {
        this.maxSmsAlarmTimes = maxSmsAlarmTimes;
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

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public List<DeviceFactor> getFactors() {
        return factors;
    }

    public void setFactors(List<DeviceFactor> factors) {
        this.factors = factors;
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
        sb.append(", alarmRecord=").append(alarmRecord);
        sb.append(", alarmSwitch=").append(alarmSwitch);
        sb.append(", deviceAddr=").append(deviceAddr);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", groupId=").append(groupId);
        sb.append(", lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append(", offlineinterval=").append(offlineinterval);
        sb.append(", savedatainterval=").append(savedatainterval);
        sb.append(", sort=").append(sort);
        sb.append(", useMarkLocation=").append(useMarkLocation);
        sb.append(", maxVoiceAlarmTimes=").append(maxVoiceAlarmTimes);
        sb.append(", maxSmsAlarmTimes=").append(maxSmsAlarmTimes);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", blockId=").append(blockId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}