package com.digital.fishery.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class FarmStorageRecord implements Serializable {
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "农资id")
    private Long storageId;

    @ApiModelProperty(value = "农资名称")
    private String storageName;

    @ApiModelProperty(value = "农资生产厂商")
    private String storageManufacturer;

    @ApiModelProperty(value = "农资品牌")
    private String storageBrand;

    @ApiModelProperty(value = "农资单位")
    private String storageUnit;

    @ApiModelProperty(value = "区块id")
    private Long blockId;

    @ApiModelProperty(value = "区块名称")
    private String blockName;

    @ApiModelProperty(value = "种植品类id")
    private Long productCategoryId;

    @ApiModelProperty(value = "种植品类名称")
    private String productCategoryName;

    @ApiModelProperty(value = "记录时间")
    private Date recordTime;

    @ApiModelProperty(value = "类型，1：入库，2：出库")
    private Integer type;

    @ApiModelProperty(value = "状态，0：未确认，1：确认")
    private Integer status;

    @ApiModelProperty(value = "数量")
    private Long quantity;

    @ApiModelProperty(value = "价格")
    private Long price;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "批次id")
    private Long batchId;

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

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageManufacturer() {
        return storageManufacturer;
    }

    public void setStorageManufacturer(String storageManufacturer) {
        this.storageManufacturer = storageManufacturer;
    }

    public String getStorageBrand() {
        return storageBrand;
    }

    public void setStorageBrand(String storageBrand) {
        this.storageBrand = storageBrand;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getStorageUnit() {
        return storageUnit;
    }

    public void setStorageUnit(String storageUnit) {
        this.storageUnit = storageUnit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", storageId=").append(storageId);
        sb.append(", blockId=").append(blockId);
        sb.append(", productCategoryId=").append(productCategoryId);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", remark=").append(remark);
        sb.append(", batchId=").append(batchId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}