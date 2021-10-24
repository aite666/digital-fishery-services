package com.digital.fishery.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DeviceNodeResp implements Serializable {
    private Long id;

    @ApiModelProperty(value = "设备地址")
    private Integer deviceAddr;

    @ApiModelProperty(value = "记录时间")
    private Date recordTime;

    @ApiModelProperty(value = "节点id")
    private Integer nodeId;

    @ApiModelProperty(value = "经度")
    private Double lng;

    @ApiModelProperty(value = "维度")
    private Double lat;

    @ApiModelProperty(value = "历史数据id")
    private String recordId;

    @ApiModelProperty(value = "记录时间字符串")
    private String recordTimeStr;

    @ApiModelProperty(value = "寄存器数据")
    private List<RegisterData> data;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用")
    private Integer status;

    public static class RegisterData {
        @ApiModelProperty(value = "寄存器id")
        private Integer registerId;

        @ApiModelProperty(value = "寄存器名称")
        private String registerName;

        @ApiModelProperty(value = "数值")
        private String text;

        @ApiModelProperty(value = "数值")
        private Double value;

        @ApiModelProperty(value = "报警级别")
        private Integer alarmLevel;

        public Integer getRegisterId() {
            return registerId;
        }

        public void setRegisterId(Integer registerId) {
            this.registerId = registerId;
        }

        public String getRegisterName() {
            return registerName;
        }

        public void setRegisterName(String registerName) {
            this.registerName = registerName;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public Integer getAlarmLevel() {
            return alarmLevel;
        }

        public void setAlarmLevel(Integer alarmLevel) {
            this.alarmLevel = alarmLevel;
        }
    }


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

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRecordTimeStr() {
        return recordTimeStr;
    }

    public void setRecordTimeStr(String recordTimeStr) {
        this.recordTimeStr = recordTimeStr;
    }

    public List<RegisterData> getData() {
        return data;
    }

    public void setData(List<RegisterData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deviceAddr=").append(deviceAddr);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", nodeId=").append(nodeId);
        sb.append(", lng=").append(lng);
        sb.append(", lat=").append(lat);
        sb.append(", recordId=").append(recordId);
        sb.append(", recordTimeStr=").append(recordTimeStr);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }



}