package com.digital.fishery.scheduled.consts;

public interface Consts {

    String DATETIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    int SUCCESS_CODE = 1000;

    String DEVICE_BASE_URL = "http://www.0531yun.com/";

    String DEVICE_TOKEN_URL = "api/getToken";
    String DEVICE_GROUP_URL = "api/device/getGroupList";
    String DEVICE_URL = "api/device/getDeviceList";
    String DEVICE_RELAY_URL = "api/device/getRelayList";
    String DEVICE_HISTORY_URL = "api/data/historyList";
    String DEVICE_REAL_TIME_URL = "api/data/getRealTimeData";
    String DEVICE_REAL_TIME_BY_ADDR_RL = "api/data/getRealTimeDataByDeviceAddr";


}
