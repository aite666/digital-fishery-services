package com.digital.fishery.dto;

import com.digital.fishery.model.InfoProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by qianhan on 2021-09-21
 */
public class InfoProductCategoryWithChildrenItem extends InfoProductCategory {
    @Getter
    @Setter
    @ApiModelProperty("子级分类")
    private List<InfoProductCategory> children;
}
