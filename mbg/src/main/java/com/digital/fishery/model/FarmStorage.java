package com.digital.fishery.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class FarmStorage implements Serializable {
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "企业id")
    private Long enterpriseId;

    @ApiModelProperty(value = "农资名称")
    private String name;

    @ApiModelProperty(value = "农资种类id")
    private Long productCategoryId;

    @ApiModelProperty(value = "农资种类名称")
    private String productCategoryName;

    @ApiModelProperty(value = "数量单位")
    private String unit;

    @ApiModelProperty(value = "品牌")
    private String brand;

    @ApiModelProperty(value = "生产厂商")
    private String manufacturer;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "最大阈值")
    private Long maxThreshold;

    @ApiModelProperty(value = "最小阈值")
    private Long minThreshold;

    @ApiModelProperty(value = "现存数量")
    private Long quantity;

    @ApiModelProperty(value = "许可证号")
    private String license;

    @ApiModelProperty(value = "生产日期")
    private Date productionDate;

    @ApiModelProperty(value = "供货主体及联系人、联系电话")
    private String contacts;

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

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getMaxThreshold() {
        return maxThreshold;
    }

    public void setMaxThreshold(Long maxThreshold) {
        this.maxThreshold = maxThreshold;
    }

    public Long getMinThreshold() {
        return minThreshold;
    }

    public void setMinThreshold(Long minThreshold) {
        this.minThreshold = minThreshold;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", name=").append(name);
        sb.append(", productCategoryId=").append(productCategoryId);
        sb.append(", unit=").append(unit);
        sb.append(", brand=").append(brand);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", remark=").append(remark);
        sb.append(", maxThreshold=").append(maxThreshold);
        sb.append(", minThreshold=").append(minThreshold);
        sb.append(", quantity=").append(quantity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}