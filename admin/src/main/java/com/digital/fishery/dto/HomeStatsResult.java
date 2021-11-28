package com.digital.fishery.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by qianhan on 2021-11-23
 */
public class HomeStatsResult {

    @ApiModelProperty(value = "区块数")
    private Integer blockNum;

    @ApiModelProperty(value = "总批次数")
    private Integer totalBatchNum;

    @ApiModelProperty(value = "本周批次数")
    private Integer weekBatchNum;

    @ApiModelProperty(value = "上周批次数")
    private Integer lastWeekBatchNum;

    @ApiModelProperty(value = "本周养殖总数")
    private String weekBatchQuantity;

    @ApiModelProperty(value = "上周养殖总数")
    private String lastWeekBatchQuantity;

    @ApiModelProperty(value = "本周养殖总额")
    private Long weekBatchAmount;

    @ApiModelProperty(value = "上周养殖总额")
    private Long lastWeekBatchAmount;

    @ApiModelProperty(value = "本周销售总数")
    private String weekSaleQuantity;

    @ApiModelProperty(value = "上周销售总数")
    private String lastWeekSaleQuantity;

    @ApiModelProperty(value = "本周销售总额")
    private Long weekSaleAmount;

    @ApiModelProperty(value = "上周销售总额")
    private Long lastWeekSaleAmount;

    @ApiModelProperty(value = "本周告警数")
    private Integer weekAlertNum;

    @ApiModelProperty(value = "上周告警数")
    private Integer lastWeekAlertNum;

    @ApiModelProperty(value = "告警总数")
    private Integer totalAlertNum;

    @ApiModelProperty(value = "本月出库")
    private Integer outStorageNum;

    @ApiModelProperty(value = "本月入库")
    private Integer inStorageNum;

    @ApiModelProperty(value = "待确认仓库农资数")
    private Integer tbcStorageNum;

    public Integer getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(Integer blockNum) {
        this.blockNum = blockNum;
    }

    public Integer getTotalBatchNum() {
        return totalBatchNum;
    }

    public void setTotalBatchNum(Integer totalBatchNum) {
        this.totalBatchNum = totalBatchNum;
    }

    public Integer getWeekBatchNum() {
        return weekBatchNum;
    }

    public void setWeekBatchNum(Integer weekBatchNum) {
        this.weekBatchNum = weekBatchNum;
    }

    public Integer getLastWeekBatchNum() {
        return lastWeekBatchNum;
    }

    public void setLastWeekBatchNum(Integer lastWeekBatchNum) {
        this.lastWeekBatchNum = lastWeekBatchNum;
    }

    public String getWeekBatchQuantity() {
        return weekBatchQuantity;
    }

    public void setWeekBatchQuantity(String weekBatchQuantity) {
        this.weekBatchQuantity = weekBatchQuantity;
    }

    public String getLastWeekBatchQuantity() {
        return lastWeekBatchQuantity;
    }

    public void setLastWeekBatchQuantity(String lastWeekBatchQuantity) {
        this.lastWeekBatchQuantity = lastWeekBatchQuantity;
    }

    public Long getWeekBatchAmount() {
        return weekBatchAmount;
    }

    public void setWeekBatchAmount(Long weekBatchAmount) {
        this.weekBatchAmount = weekBatchAmount;
    }

    public Long getLastWeekBatchAmount() {
        return lastWeekBatchAmount;
    }

    public void setLastWeekBatchAmount(Long lastWeekBatchAmount) {
        this.lastWeekBatchAmount = lastWeekBatchAmount;
    }

    public String getWeekSaleQuantity() {
        return weekSaleQuantity;
    }

    public void setWeekSaleQuantity(String weekSaleQuantity) {
        this.weekSaleQuantity = weekSaleQuantity;
    }

    public String getLastWeekSaleQuantity() {
        return lastWeekSaleQuantity;
    }

    public void setLastWeekSaleQuantity(String lastWeekSaleQuantity) {
        this.lastWeekSaleQuantity = lastWeekSaleQuantity;
    }

    public Long getWeekSaleAmount() {
        return weekSaleAmount;
    }

    public void setWeekSaleAmount(Long weekSaleAmount) {
        this.weekSaleAmount = weekSaleAmount;
    }

    public Long getLastWeekSaleAmount() {
        return lastWeekSaleAmount;
    }

    public void setLastWeekSaleAmount(Long lastWeekSaleAmount) {
        this.lastWeekSaleAmount = lastWeekSaleAmount;
    }

    public Integer getWeekAlertNum() {
        return weekAlertNum;
    }

    public void setWeekAlertNum(Integer weekAlertNum) {
        this.weekAlertNum = weekAlertNum;
    }

    public Integer getLastWeekAlertNum() {
        return lastWeekAlertNum;
    }

    public void setLastWeekAlertNum(Integer lastWeekAlertNum) {
        this.lastWeekAlertNum = lastWeekAlertNum;
    }

    public Integer getTotalAlertNum() {
        return totalAlertNum;
    }

    public void setTotalAlertNum(Integer totalAlertNum) {
        this.totalAlertNum = totalAlertNum;
    }

    public Integer getOutStorageNum() {
        return outStorageNum;
    }

    public void setOutStorageNum(Integer outStorageNum) {
        this.outStorageNum = outStorageNum;
    }

    public Integer getInStorageNum() {
        return inStorageNum;
    }

    public void setInStorageNum(Integer inStorageNum) {
        this.inStorageNum = inStorageNum;
    }

    public Integer getTbcStorageNum() {
        return tbcStorageNum;
    }

    public void setTbcStorageNum(Integer tbcStorageNum) {
        this.tbcStorageNum = tbcStorageNum;
    }
}
