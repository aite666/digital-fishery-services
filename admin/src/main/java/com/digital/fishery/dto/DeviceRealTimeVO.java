package com.digital.fishery.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class DeviceRealTimeVO {


    @ApiModelProperty(value = "设备地址码")
    private Integer deviceAddr;
    @ApiModelProperty(value = "设备名")
    private String deviceName;
    @ApiModelProperty(value = "设备状态")
    private String deviceStatus;
    @ApiModelProperty(value = "纬度")
    private double lat;
    @ApiModelProperty(value = "经度")
    private double lng;
    @ApiModelProperty(value = "继电器状态 0:断开  1:开启")
    private String relayStatus;
    @ApiModelProperty(value = "系统编码")
    private String systemCode;
    @ApiModelProperty(value = "数据时间戳")
    private long timeStamp;

    private List<DataItem> dataItem;

    public static class DataItem {
        @ApiModelProperty(value = "节点id")
        private int nodeId;
        private List<RegisterItem> registerItem;

        public int getNodeId() {
            return nodeId;
        }

        public void setNodeId(int nodeId) {
            this.nodeId = nodeId;
        }

        public List<RegisterItem> getRegisterItem() {
            return registerItem;
        }

        public void setRegisterItem(List<RegisterItem> registerItem) {
            this.registerItem = registerItem;
        }
    }

    public static class RegisterItem {
        @ApiModelProperty(value = "报警颜色")
        private String alarmColor;
        @ApiModelProperty(value = "报警消息")
        private String alarmInfo;
        @ApiModelProperty(value = "报警等级")
        private int alarmLevel;
        @ApiModelProperty(value = "数据")
        private String data;
        @ApiModelProperty(value = "寄存器id")
        private int registerId;
        @ApiModelProperty(value = "单位")
        private String unit;
        @ApiModelProperty(value = "实际值")
        private double value;

        public String getAlarmColor() {
            return alarmColor;
        }

        public void setAlarmColor(String alarmColor) {
            this.alarmColor = alarmColor;
        }

        public String getAlarmInfo() {
            return alarmInfo;
        }

        public void setAlarmInfo(String alarmInfo) {
            this.alarmInfo = alarmInfo;
        }

        public int getAlarmLevel() {
            return alarmLevel;
        }

        public void setAlarmLevel(int alarmLevel) {
            this.alarmLevel = alarmLevel;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getRegisterId() {
            return registerId;
        }

        public void setRegisterId(int registerId) {
            this.registerId = registerId;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
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

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getRelayStatus() {
        return relayStatus;
    }

    public void setRelayStatus(String relayStatus) {
        this.relayStatus = relayStatus;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<DataItem> getDataItem() {
        return dataItem;
    }

    public void setDataItem(List<DataItem> dataItem) {
        this.dataItem = dataItem;
    }
}
