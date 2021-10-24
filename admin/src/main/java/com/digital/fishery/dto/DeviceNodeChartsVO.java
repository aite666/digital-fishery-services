package com.digital.fishery.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class DeviceNodeChartsVO {

    @ApiModelProperty(value = "设备地址")
    private Integer deviceAddr;

    @ApiModelProperty(value = "节点id")
    private Integer nodeId;

    private List<NodeData> data;

    public static class NodeData {
        @ApiModelProperty(value = "寄存器id")
        private Integer registerId;

        @ApiModelProperty(value = "寄存器名称")
        private String registerName;

        @ApiModelProperty(value = "经度")
        private Double lng;

        @ApiModelProperty(value = "维度")
        private Double lat;

        @ApiModelProperty(value = "记录时间")
        private Date recordTime;

        @ApiModelProperty(value = "数值")
        private Double value;

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

        public Date getRecordTime() {
            return recordTime;
        }

        public void setRecordTime(Date recordTime) {
            this.recordTime = recordTime;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }
    }

    public Integer getDeviceAddr() {
        return deviceAddr;
    }

    public void setDeviceAddr(Integer deviceAddr) {
        this.deviceAddr = deviceAddr;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public List<NodeData> getData() {
        return data;
    }

    public void setData(List<NodeData> data) {
        this.data = data;
    }
}
