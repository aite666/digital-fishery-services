package com.digital.fishery.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by qianhan on 2021-11-10
 */
public class WeChatLoginVO {

    @ApiModelProperty(value = "微信小程序code")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
