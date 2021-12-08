package com.digital.fishery.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.dto.HomeStatsResult;
import com.digital.fishery.mapper.*;
import com.digital.fishery.model.*;
import com.digital.fishery.service.HomeService;
import com.digital.fishery.service.InfoBlockService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.digital.fishery.scheduled.consts.Consts.DATETIME_FORMATTER;

/**
 * Created by qianhan on 2021-09-19
 */
@Service
public class HomeServiceImpl implements HomeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeServiceImpl.class);

    @Autowired
    private InfoBlockMapper infoBlockMapper;

    @Autowired
    private FarmBatchMapper farmBatchMapper;

    @Autowired
    private FarmSaleMapper farmSaleMapper;

    @Autowired
    private AlarmRecordMapper alarmRecordMapper;

    @Autowired
    private AlarmRuleMapper alarmRuleMapper;

    @Autowired
    private FarmStorageRecordMapper farmStorageRecordMapper;

    @Override
    public HomeStatsResult stats(String blockIds) {
        List<Long> blockIdList = new ArrayList<>();
        if (StringUtil.isNotEmpty(blockIds)) {
            blockIdList = Arrays.stream(blockIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
        }

        InfoBlockExample infoBlockExample = new InfoBlockExample();
        if (blockIdList.size() > 0) {
            infoBlockExample.createCriteria().andIdIn2(blockIdList);
        }
        long blockNum = infoBlockMapper.countByExample(infoBlockExample);

        FarmBatchExample farmBatchExample = new FarmBatchExample();
        FarmBatchExample.Criteria FarmBatchCriteria = farmBatchExample.createCriteria();
        FarmBatchCriteria.andStatusEqualTo(1);
        if (blockIdList.size() > 0) {
            FarmBatchCriteria.andBlockIdIn(blockIdList);
        }
        long totalBatchNum = farmBatchMapper.countByExample(farmBatchExample);

        Date weekStartTime = this.getWeekStart();
        Date now = new Date();
        Date lastweekStartTime = new Date(weekStartTime.getTime() - 7 * 24 * 60 * 60 * 1000);
        Date monthStartTime = this.getMonthStart();

        FarmBatchExample farmBatchExample2 = new FarmBatchExample();
        FarmBatchExample.Criteria farmBatchCriteria2 = farmBatchExample2.createCriteria();
        farmBatchCriteria2.andFarmTimeGreaterThanOrEqualTo(weekStartTime);
        farmBatchCriteria2.andFarmTimeLessThanOrEqualTo(now);
        if (blockIdList.size() > 0) {
            farmBatchCriteria2.andBlockIdIn(blockIdList);
        }
        long weekBatchNum = farmBatchMapper.countByExample(farmBatchExample2);
        List<FarmBatch> weekBatchList = farmBatchMapper.selectByExample(farmBatchExample2);
        Map<String, Object> weekBatchMap = this.getBatchStats(weekBatchList);

        FarmBatchExample farmBatchExample3 = new FarmBatchExample();
        FarmBatchExample.Criteria farmBatchCriteria3 = farmBatchExample3.createCriteria();
        farmBatchCriteria3.andFarmTimeGreaterThanOrEqualTo(lastweekStartTime);
        farmBatchCriteria3.andFarmTimeLessThanOrEqualTo(weekStartTime);
        if (blockIdList.size() > 0) {
            farmBatchCriteria3.andBlockIdIn(blockIdList);
        }
        long lastWeekBatchNum = farmBatchMapper.countByExample(farmBatchExample3);
        List<FarmBatch> lastweekBatchList = farmBatchMapper.selectByExample(farmBatchExample3);
        Map<String, Object> lastweekBatchMap = this.getBatchStats(lastweekBatchList);

        FarmSaleExample farmSaleExample = new FarmSaleExample();
        FarmSaleExample.Criteria farmSaleCriteria = farmSaleExample.createCriteria();
        farmSaleCriteria.andSaleTimeGreaterThanOrEqualTo(weekStartTime);
        farmSaleCriteria.andSaleTimeLessThanOrEqualTo(now);
        if (blockIdList.size() > 0) {
            farmSaleCriteria.andBlockIdIn(blockIdList);
        }
        List<FarmSale> weekFarmSales = farmSaleMapper.selectByExample(farmSaleExample);
        Map<String, Object> weekSaleMap = this.getSaleStats(weekFarmSales);

        FarmSaleExample farmSaleExample2 = new FarmSaleExample();
        FarmSaleExample.Criteria farmSaleCriteria2 = farmSaleExample2.createCriteria();
        farmSaleCriteria2.andSaleTimeGreaterThanOrEqualTo(lastweekStartTime);
        farmSaleCriteria2.andSaleTimeLessThanOrEqualTo(weekStartTime);
        if (blockIdList.size() > 0) {
            farmSaleCriteria2.andBlockIdIn(blockIdList);
        }
        List<FarmSale> lastweekFarmSales = farmSaleMapper.selectByExample(farmSaleExample2);
        Map<String, Object> lastweekSaleMap = this.getSaleStats(lastweekFarmSales);

        AlarmRecordExample alarmRecordExample = new AlarmRecordExample();
        AlarmRecordExample.Criteria alarmRecordCriteria = alarmRecordExample.createCriteria();
        List<Long> ruleIds = new ArrayList<>();
        if (blockIdList.size() > 0) {
            AlarmRuleExample alarmRuleExample = new AlarmRuleExample();
            AlarmRuleExample.Criteria alarmRuleCriteria = alarmRuleExample.createCriteria();
            alarmRuleCriteria.andBlockIdIn(blockIdList);
            List<AlarmRule> alarmRules = alarmRuleMapper.selectByExample(alarmRuleExample);
            ruleIds = alarmRules.stream().map(AlarmRule::getId).collect(Collectors.toList());
        }
        if (ruleIds.size() > 0) {
            alarmRecordCriteria.andRuleIdIn2(ruleIds);
        }
        long totalAlertNum = alarmRecordMapper.countByExample(alarmRecordExample);

        AlarmRecordExample alarmRecordExample2 = new AlarmRecordExample();
        AlarmRecordExample.Criteria alarmRecordCriteria2 = alarmRecordExample2.createCriteria();
        if (ruleIds.size() > 0) {
            alarmRecordCriteria2.andRuleIdIn2(ruleIds);
        }
        alarmRecordCriteria2.andAlarmTimeGreaterThanOrEqualTo2(weekStartTime);
        alarmRecordCriteria2.andAlarmTimeLessThanOrEqualTo2(now);
        long weekAlertNum = alarmRecordMapper.countByExample(alarmRecordExample2);

        AlarmRecordExample alarmRecordExample3 = new AlarmRecordExample();
        AlarmRecordExample.Criteria alarmRecordCriteria3 = alarmRecordExample3.createCriteria();
        if (ruleIds.size() > 0) {
            alarmRecordCriteria3.andRuleIdIn2(ruleIds);
        }
        alarmRecordCriteria3.andAlarmTimeGreaterThanOrEqualTo2(weekStartTime);
        alarmRecordCriteria3.andAlarmTimeLessThanOrEqualTo2(now);
        long lastWeekAlertNum = alarmRecordMapper.countByExample(alarmRecordExample3);

        FarmStorageRecordExample farmStorageRecordExample = new FarmStorageRecordExample();
        FarmStorageRecordExample.Criteria farmStorageRecordCriteria =  farmStorageRecordExample.createCriteria();
        farmStorageRecordCriteria.andStatusEqualTo(0);
//        if (blockIdList.size() > 0) {
//            farmStorageRecordCriteria.andBlockIdIn(blockIdList);
//        }
        long tbcStorageNum = farmStorageRecordMapper.countByExample(farmStorageRecordExample);

        FarmStorageRecordExample farmStorageRecordExample2 = new FarmStorageRecordExample();
        FarmStorageRecordExample.Criteria farmStorageRecordCriteria2 = farmStorageRecordExample2.createCriteria();
        farmStorageRecordCriteria2.andTypeEqualTo(2);
        farmStorageRecordCriteria2.andRecordTimeGreaterThanOrEqualTo(monthStartTime);
        farmStorageRecordCriteria2.andRecordTimeLessThanOrEqualTo(now);
//        if (blockIdList.size() > 0) {
//            farmStorageRecordCriteria2.andBlockIdIn(blockIdList);
//        }
        long outStorageNum = farmStorageRecordMapper.countByExample(farmStorageRecordExample2);

        FarmStorageRecordExample farmStorageRecordExample3 = new FarmStorageRecordExample();
        FarmStorageRecordExample.Criteria farmStorageRecordCriteria3 =  farmStorageRecordExample3.createCriteria();
        farmStorageRecordCriteria3.andTypeEqualTo(1);
        farmStorageRecordCriteria3.andStatusEqualTo(0);
        farmStorageRecordCriteria3.andRecordTimeGreaterThanOrEqualTo(monthStartTime);
        farmStorageRecordCriteria3.andRecordTimeLessThanOrEqualTo(now);
        long inStorageNum = farmStorageRecordMapper.countByExample(farmStorageRecordExample3);

        HomeStatsResult result = new HomeStatsResult();
        result.setBlockNum((int)blockNum);
        result.setTotalBatchNum((int)totalBatchNum);
        result.setWeekBatchNum((int)weekBatchNum);
        result.setLastWeekBatchNum((int)lastWeekBatchNum);
        result.setWeekBatchAmount((long)weekBatchMap.get("weekBatchAmount"));
        result.setWeekBatchQuantity(String.valueOf(weekBatchMap.get("weekBatchQuantity")));
        result.setLastWeekBatchAmount((long)lastweekBatchMap.get("weekBatchAmount"));
        result.setLastWeekBatchQuantity(String.valueOf(lastweekBatchMap.get("weekBatchQuantity")));

        result.setWeekSaleAmount((long)weekSaleMap.get("weekSaleAmount"));
        result.setWeekSaleQuantity(String.valueOf(weekSaleMap.get("weekSaleQuantity")));
        result.setLastWeekSaleAmount((long)lastweekSaleMap.get("weekSaleAmount"));
        result.setLastWeekSaleQuantity(String.valueOf(lastweekSaleMap.get("weekSaleQuantity")));
        result.setTotalAlertNum((int)totalAlertNum);
        result.setWeekAlertNum((int)weekAlertNum);
        result.setLastWeekAlertNum((int)lastWeekAlertNum);
        result.setInStorageNum((int)inStorageNum);
        result.setOutStorageNum((int)outStorageNum);
        result.setTbcStorageNum((int)tbcStorageNum);
        return result;
    }

    private Map<String, Object> getBatchStats(List<FarmBatch> weekBatchList) {
        Map<String, Object> map = new HashMap<String, Object>();
        Long weekBatchAmount = 0L;
        Map<String, Long> unitQuantityMap = new HashMap<String, Long>();
        for (FarmBatch farmBatch : weekBatchList) {
            weekBatchAmount += farmBatch.getAmount().longValue();;
            if (unitQuantityMap.get(farmBatch.getUnit()) == null) {
                unitQuantityMap.put(farmBatch.getUnit(), farmBatch.getQuantity());
            } else {
                long quantity = unitQuantityMap.get(farmBatch.getUnit());
                unitQuantityMap.put(farmBatch.getUnit(), quantity + farmBatch.getQuantity());
            }
        }
        List<String> unitQuantityList = new ArrayList<>();
        for (Map.Entry<String, Long> entry : unitQuantityMap.entrySet()) {
            String unit = entry.getKey();
            long quantity = entry.getValue();
            unitQuantityList.add(String.valueOf(quantity) + unit);
        }
        map.put("weekBatchAmount", weekBatchAmount);
        map.put("weekBatchQuantity", String.join("+", unitQuantityList));
        return map;
    }

    private Map<String, Object> getSaleStats(List<FarmSale> weekFarmSales) {
        Map<String, Object> map = new HashMap<String, Object>();
        Long weekSaleAmount = 0L;
        Map<String, Long> unitQuantityMap = new HashMap<String, Long>();
        for (FarmSale farmSale : weekFarmSales) {
            weekSaleAmount += farmSale.getAmount().longValue();;
            if (unitQuantityMap.get(farmSale.getUnit()) == null) {
                unitQuantityMap.put(farmSale.getUnit(), farmSale.getQuantity());
            } else {
                long quantity = unitQuantityMap.get(farmSale.getUnit());
                unitQuantityMap.put(farmSale.getUnit(), quantity + farmSale.getQuantity());
            }
        }
        List<String> unitQuantityList = new ArrayList<>();
        for (Map.Entry<String, Long> entry : unitQuantityMap.entrySet()) {
            String unit = entry.getKey();
            long quantity = entry.getValue();
            unitQuantityList.add(String.valueOf(quantity) + unit);
        }
        map.put("weekSaleAmount", weekSaleAmount);
        map.put("weekSaleQuantity", String.join("+", unitQuantityList));
        return map;
    }

    /**
     * 获取本周的第一天
     * @return Date
     * **/
    private Date getWeekStart(){
        int num;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 1) {
            num = 0;
        } else if (dayOfWeek == 0){
            num = -6;
        }else {
            num = 1 - dayOfWeek;
        }
        calendar.add(Calendar.DATE, num);
        Date monday = calendar.getTime();
        return monday;
    }

    /**
     * 获取本月的第一天
     * @return Date
     * **/
    private Date getMonthStart(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date time = calendar.getTime();
        return time;
    }

    @Override
    public List<JSONObject> chart(Long blockId, String blockIds, Integer detail, String startTime, String endTime) {
        List<JSONObject> result = new ArrayList<>();
        List<Long> blockIdList = new ArrayList<>();
        if (StringUtil.isNotEmpty(blockIds)) {
            blockIdList = Arrays.stream(blockIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
        }
        List<JSONObject> batchData = farmBatchMapper.getHomeBatchData(blockId, blockIdList, startTime, endTime);
        Map<String, Integer> batchMap = new HashMap<>();
        for(JSONObject item: batchData) {
            batchMap.put(item.getString("farmDate"), item.getInteger("batchNum"));
        }
        Map<String, Integer> batchDetailMap1 = new HashMap<>();
        Map<String, Integer> batchDetailMap2 = new HashMap<>();
        if (detail == 1) {
            List<JSONObject> batchDetailData = farmBatchMapper.getHomeBatchDetailData(blockId, blockIdList, startTime, endTime);
            for(JSONObject item: batchDetailData) {
                if (item.getString("unit").equals("公斤")) {
                    batchDetailMap1.put(item.getString("farmDate"), item.getInteger("quantityTotal"));
                } else if (item.getString("unit").equals("尾")) {
                    batchDetailMap2.put(item.getString("farmDate"), item.getInteger("quantityTotal"));
                }
            }
        }
        List<JSONObject> saleData = farmSaleMapper.getHomeSaleData(blockId, blockIdList, startTime, endTime);
        Map<String, Long> saleMap = new HashMap<>();
        for(JSONObject item: saleData) {
            saleMap.put(item.getString("saleDate"), item.getLong("saleAmount"));
        }
        Map<String, Integer> saleDetailMap1 = new HashMap<>();
        Map<String, Integer> saleDetailMap2 = new HashMap<>();
        if (detail == 1) {
            List<JSONObject> saleDetailData = farmSaleMapper.getHomeSaleDetailData(blockId, blockIdList, startTime, endTime);
            for(JSONObject item: saleDetailData) {
                if (item.getString("unit").equals("公斤")) {
                    saleDetailMap1.put(item.getString("saleDate"), item.getInteger("quantityTotal"));
                } else if (item.getString("unit").equals("尾")) {
                    saleDetailMap2.put(item.getString("saleDate"), item.getInteger("quantityTotal"));
                }
            }
        }
        List<String> allDateList = this.getAllDate(startTime, endTime);
        for (String date: allDateList) {
            JSONObject o = new JSONObject();
            o.put("date", date);
            if (batchMap.get(date) != null){
                o.put("batchNum", batchMap.get(date));
            } else {
                o.put("batchNum", 0);
            }
            if (saleMap.get(date) != null){
                o.put("saleAmount", saleMap.get(date));
            } else {
                o.put("saleAmount", 0);
            }
            if (detail == 1) {
                if (batchDetailMap1.get(date) != null){
                    o.put("batchQuantity1", batchDetailMap1.get(date));
                } else {
                    o.put("batchQuantity1", 0);
                }
                if (batchDetailMap2.get(date) != null){
                    o.put("batchQuantity2", batchDetailMap2.get(date));
                } else {
                    o.put("batchQuantity2", 0);
                }
                if (saleDetailMap1.get(date) != null){
                    o.put("saleQuantity1", saleDetailMap1.get(date));
                } else {
                    o.put("saleQuantity1", 0);
                }
                if (saleDetailMap2.get(date) != null){
                    o.put("saleQuantity2", saleDetailMap2.get(date));
                } else {
                    o.put("saleQuantity2", 0);
                }
            }
            result.add(o);
        }
        return result;
    }

    private List<String> getAllDate(String startTime, String endTime) {
        List<String> allDateList = new ArrayList<>();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMATTER);
            Date start = simpleDateFormat.parse(startTime);
            Date end = simpleDateFormat.parse(endTime);
            Long startTimestamp = start.getTime();
            Long endTimestamp = end.getTime();
            Long oneDay = 1000 * 60 * 60 * 24L;

            Long time = startTimestamp;
            while (time <= endTimestamp) {
                Date d = new Date(time);
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                allDateList.add(df.format(d));
                time += oneDay;
            }
        } catch (ParseException e) {
            LOGGER.warn("ParseException, ", e);
        }
        return allDateList;
    }
}

