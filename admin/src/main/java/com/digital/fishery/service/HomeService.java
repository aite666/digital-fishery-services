package com.digital.fishery.service;

import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.dto.HomeStatsResult;
import com.digital.fishery.model.InfoBlock;

import java.util.List;

/**
 * 首页管理Service
 * Created by qianhan on 2021-09-19
 */
public interface HomeService {

    /**
     * 首页统计信息
     */
    HomeStatsResult stats(String blockIds);

    /**
     * 首页图表数据
     */
    List<JSONObject> chart(String blockIds, String startTime, String endTime);
}
