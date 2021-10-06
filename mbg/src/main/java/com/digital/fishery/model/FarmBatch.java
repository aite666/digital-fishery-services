package com.digital.fishery.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class FarmBatch implements Serializable {
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "批次号")
    private String code;

    @ApiModelProperty(value = "区块id")
    private Long blockId;

    @ApiModelProperty(value = "区块名称")
    private String blockName;

    @ApiModelProperty(value = "养殖品种id")
    private Long productCategoryId;

    @ApiModelProperty(value = "养殖品种名称")
    private String productCategoryName;

    @ApiModelProperty(value = "种养时间")
    private Date farmTime;

    @ApiModelProperty(value = "来源单位")
    private String origin;

    @ApiModelProperty(value = "数量")
    private Long quantity;

    @ApiModelProperty(value = "单价")
    private Double unitPrice;

    @ApiModelProperty(value = "金额")
    private Double amount;

    @ApiModelProperty(value = "状态，1：养殖中 0：养殖完毕")
    private Integer status;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Date getFarmTime() {
        return farmTime;
    }

    public void setFarmTime(Date farmTime) {
        this.farmTime = farmTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getBlockName() {
        return blockName;
    }

    public String getProductCategoryName() {
        return productCategoryName;
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
        sb.append(", createTime=").append(createTime);
        sb.append(", code=").append(code);
        sb.append(", blockId=").append(blockId);
        sb.append(", productCategoryId=").append(productCategoryId);
        sb.append(", farmTime=").append(farmTime);
        sb.append(", origin=").append(origin);
        sb.append(", quantity=").append(quantity);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", amount=").append(amount);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}