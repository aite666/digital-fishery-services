package com.digital.fishery.util;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.collections.MapUtils;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.client.fluent.Request;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * 不带参数的get请求
     * @param url
     * @return String
     */
    public static String doGet(String url, Map<String, String> headers) {
        return doGet(url, headers, null);
    }

    /**
     * 带参数的get请求
     * @param url
     * @param params
     * @return String
     */
    public static String doGet(String url, Map<String, String> headers, Map<String, String> params) {
        try {
            url = buildGetParam(url, params);
            logger.info("url: {}", url);
            String response = Request.Get(url)
                    .setHeaders(headers.entrySet().stream()
                            .map(o -> new BasicHeader(o.getKey(), o.getValue()))
                            .toArray(Header[]::new))
                    .execute()
                    .returnContent()
                    .asString(Charset.defaultCharset());
            logger.info("response: {}", response);
            return response;
        } catch (Exception e) {
            logger.info("调用异常, ", e);
        }
        return null;
    }

    private static String buildGetParam(String url, Map<String, String> params) {
        if(MapUtils.isNotEmpty(params)) {
            List<NameValuePair> paramList = Lists.newArrayListWithCapacity(params.size());
            for (String key : params.keySet()) {
                paramList.add(new BasicNameValuePair(key, params.get(key)));
            }
            //拼接参数
            url += "?" + URLEncodedUtils.format(paramList, Consts.UTF_8);
        }
        return url;
    }

    /**
     * 不带参数的post请求
     * @param url
     * @return String
     */
    public static String doPost(String url, Map<String, String> headers) throws Exception {
        return doPost(url, headers, null);
    }

    /**
     * 带参数的post请求
     * @param url
     * @param params
     * @return String
     */
    public static String doPost(String url, Map<String, String> headers, Map<String, String> params) {
        try {
            String dataStr = JSON.toJSONString(params);
            String response = Request.Post(url)
                    .setHeaders(headers.entrySet().stream()
                            .map(o -> new BasicHeader(o.getKey(), o.getValue()))
                            .toArray(Header[]::new))
                    .bodyString(dataStr, ContentType.APPLICATION_JSON)
                    .execute()
                    .returnContent()
                    .asString();
            logger.info("url: {}, data: {}", url, dataStr);
            logger.info("response: {}", response);
            return response;
        } catch (Exception e) {
            logger.warn("调用异常，", e);
            return null;
        }
    }

}