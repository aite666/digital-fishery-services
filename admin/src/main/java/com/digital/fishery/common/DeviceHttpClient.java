package com.digital.fishery.common;

import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.scheduled.domain.BaseResponse;
import com.digital.fishery.service.RedisService;
import com.digital.fishery.util.HttpClientUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.digital.fishery.scheduled.consts.Consts.*;

@Service
public class DeviceHttpClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceHttpClient.class);

    private static final String AUTHORIZATION = "Authorization";

    private static final int REDIS_AUTHORIZATION_TIME = 360*15;

    @Value("${device.login.name:h211018szjc}")
    private String deviceLoginName;
    @Value("${device.password:h211018szjc}")
    private String devicePassword;

    @Autowired
    private RedisService redisService;

    public BaseResponse doGet(String url, Map<String, String> param) {
        String authorization = getAuthorization();
        if (StringUtils.isBlank(authorization)) {
            return null;
        }
        Map<String, String> headers = new HashMap<>();
        headers.put(AUTHORIZATION, authorization);

        String response = HttpClientUtil.doGet(url, headers, param);
        BaseResponse baseResponse = JSONObject.parseObject(response, BaseResponse.class);
        if (baseResponse == null || SUCCESS_CODE != baseResponse.getCode() || baseResponse.getData() == null) {
            LOGGER.warn("接口异常 error, {}", baseResponse.getMessage());
            return null;
        }
        return baseResponse;
    }



    private String getAuthorization() {
        String authorization = redisService.get(AUTHORIZATION) == null ? StringUtils.EMPTY : redisService.get(AUTHORIZATION).toString();
        if (StringUtils.isNotBlank(authorization)) {
            return authorization;
        }
        Map<String, String> params = new HashMap<>();
        params.put("loginName", deviceLoginName);
        params.put("password", devicePassword);
        String response = HttpClientUtil.doGet(DEVICE_BASE_URL + DEVICE_TOKEN_URL, new HashMap<>(), params);
        BaseResponse baseResponse = JSONObject.parseObject(response, BaseResponse.class);
        if (baseResponse == null || SUCCESS_CODE != baseResponse.getCode() || baseResponse.getData() == null) {
            LOGGER.warn("接口异常 error, {}", baseResponse.getMessage());
            return null;
        }
        JSONObject jo = (JSONObject) baseResponse.getData();
        String token = jo.getString("token");
        redisService.set(AUTHORIZATION, token, REDIS_AUTHORIZATION_TIME);
        LOGGER.info("getAuthorization finish token: {}", jo.getString("token"));
        return token;
    }
}
