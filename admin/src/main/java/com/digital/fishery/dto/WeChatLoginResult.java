package com.digital.fishery.dto;

import com.digital.fishery.model.UmsAdmin;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by qianhan on 2021-11-10
 */
public class WeChatLoginResult {

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "用户信息")
    private UmsAdmin umsAdmin;

    @ApiModelProperty(value = "返回信息")
    private String message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UmsAdmin getUmsAdmin() {
        return umsAdmin;
    }

    public void setUmsAdmin(UmsAdmin umsAdmin) {
        this.umsAdmin = umsAdmin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
