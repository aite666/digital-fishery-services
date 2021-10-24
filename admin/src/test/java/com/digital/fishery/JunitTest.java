package com.digital.fishery;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.digital.fishery.model.DeviceNode;
import com.digital.fishery.model.DeviceNodeResp;
import com.digital.fishery.scheduled.domain.BaseResponse;
import com.digital.fishery.util.HttpClientUtil;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.digital.fishery.scheduled.consts.Consts.DATETIME_FORMATTER;

public class JunitTest {

    @Test
    public void test03() {
        BaseResponse baseResponse = JSON.parseObject(nodeStr2, BaseResponse.class);
        List<DeviceNodeResp> deviceNodeResp = JSON.parseObject(baseResponse.getData().toString(), new TypeReference<List<DeviceNodeResp>>() {});
        for (DeviceNodeResp node : deviceNodeResp) {
            DeviceNode deviceNode = new DeviceNode();
            BeanUtils.copyProperties(node, deviceNode);
            List<DeviceNodeResp.RegisterData> data = node.getData();
            if (CollectionUtils.isEmpty(data)) {
                System.out.println("deviceNode null: " + JSON.toJSONString(deviceNode));
                continue;
            }
            for (DeviceNodeResp.RegisterData registerData : data) {
//                deviceNode.setAlarmLevel(registerData.getAlarmLevel());
//                deviceNode.setRegisterId(registerData.getRegisterId());
//                deviceNode.setRegisterName(registerData.getRegisterName());
//                deviceNode.setText(registerData.getText());
//                deviceNode.setValue(registerData.getValue());
                BeanUtils.copyProperties(registerData, deviceNode);
                System.out.println("deviceNode: " + JSON.toJSONString(deviceNode));
            }
        }

    }

    @Test
    public void test02() {
        Map<String, String> param = new HashMap<>();
        param.put("deviceAddr", "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMATTER);
        param.put("startTime", simpleDateFormat.format(new Date(new Date().getTime() - (1000*60*30))));
        param.put("endTime", simpleDateFormat.format(new Date()));
        System.out.println("param: " + JSON.toJSONString(param));
    }

    @Test
    public void test01() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("loginName", "e1");
        params.put("password", "das");
        String s = HttpClientUtil.doGet("http://www.0531yun.com/api/getToken", new HashMap<>(), params);
        System.out.println(s);
    }

    String nodeStr = "{\n" +
            "    \"code\": 1000,\n" +
            "    \"message\": \"获取成功\",\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "                {\n" +
            "                    \"registerId\": 1,\n" +
            "                    \"registerName\": \"温度\",\n" +
            "                    \"value\": 21.7,\n" +
            "                    \"text\": \"21.7\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"registerId\": 2,\n" +
            "                    \"registerName\": \"湿度\",\n" +
            "                    \"value\": 38.8,\n" +
            "                    \"text\": \"38.8\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                }\n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634723211744,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fe58bcf87112d65876ade\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "                {\n" +
            "                    \"registerId\": 1,\n" +
            "                    \"registerName\": \"温度\",\n" +
            "                    \"value\": 21.6,\n" +
            "                    \"text\": \"21.6\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"registerId\": 2,\n" +
            "                    \"registerName\": \"湿度\",\n" +
            "                    \"value\": 35.0,\n" +
            "                    \"text\": \"35.0\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                }\n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634721411643,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fde83cf87112d6587674e\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "                {\n" +
            "                    \"registerId\": 1,\n" +
            "                    \"registerName\": \"温度\",\n" +
            "                    \"value\": 21.7,\n" +
            "                    \"text\": \"21.7\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"registerId\": 2,\n" +
            "                    \"registerName\": \"湿度\",\n" +
            "                    \"value\": 35.3,\n" +
            "                    \"text\": \"35.3\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                }\n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634719611541,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fd77bcf87112d658763bf\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "                {\n" +
            "                    \"registerId\": 1,\n" +
            "                    \"registerName\": \"温度\",\n" +
            "                    \"value\": 21.7,\n" +
            "                    \"text\": \"21.7\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"registerId\": 2,\n" +
            "                    \"registerName\": \"湿度\",\n" +
            "                    \"value\": 35.6,\n" +
            "                    \"text\": \"35.6\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                }\n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634717811440,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fd073cf87112d6587602f\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "                {\n" +
            "                    \"registerId\": 1,\n" +
            "                    \"registerName\": \"温度\",\n" +
            "                    \"value\": 21.6,\n" +
            "                    \"text\": \"21.6\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"registerId\": 2,\n" +
            "                    \"registerName\": \"湿度\",\n" +
            "                    \"value\": 36.2,\n" +
            "                    \"text\": \"36.2\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                }\n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634716011338,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fc96bcf87112d65875c9f\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "                {\n" +
            "                    \"registerId\": 1,\n" +
            "                    \"registerName\": \"温度\",\n" +
            "                    \"value\": 21.8,\n" +
            "                    \"text\": \"21.8\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"registerId\": 2,\n" +
            "                    \"registerName\": \"湿度\",\n" +
            "                    \"value\": 34.8,\n" +
            "                    \"text\": \"34.8\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                }\n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634714211236,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fc263cf87112d6587591f\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "                {\n" +
            "                    \"registerId\": 1,\n" +
            "                    \"registerName\": \"温度\",\n" +
            "                    \"value\": 22.0,\n" +
            "                    \"text\": \"22.0\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"registerId\": 2,\n" +
            "                    \"registerName\": \"湿度\",\n" +
            "                    \"value\": 34.9,\n" +
            "                    \"text\": \"34.9\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                }\n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634712411135,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fbb5bcf87112d6587559f\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "                {\n" +
            "                    \"registerId\": 1,\n" +
            "                    \"registerName\": \"温度\",\n" +
            "                    \"value\": 22.1,\n" +
            "                    \"text\": \"22.1\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"registerId\": 2,\n" +
            "                    \"registerName\": \"湿度\",\n" +
            "                    \"value\": 34.1,\n" +
            "                    \"text\": \"34.1\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                }\n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634710611033,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fb453cf87112d65875220\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    String nodeStr2 = "{\n" +
            "    \"code\": 1000,\n" +
            "    \"message\": \"获取成功\",\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "               \n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634723211744,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fe58bcf87112d65876ade\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "           \n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634721411643,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fde83cf87112d6587674e\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "                \n" +
            "                {\n" +
            "                    \"registerId\": 2,\n" +
            "                    \"registerName\": \"湿度\",\n" +
            "                    \"value\": 35.3,\n" +
            "                    \"text\": \"35.3\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                }\n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634719611541,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fd77bcf87112d658763bf\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "           \n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634717811440,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fd073cf87112d6587602f\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "                {\n" +
            "                    \"registerId\": 1,\n" +
            "                    \"registerName\": \"温度\",\n" +
            "                    \"value\": 21.6,\n" +
            "                    \"text\": \"21.6\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"registerId\": 2,\n" +
            "                    \"registerName\": \"湿度\",\n" +
            "                    \"value\": 36.2,\n" +
            "                    \"text\": \"36.2\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                }\n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634716011338,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fc96bcf87112d65875c9f\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "                {\n" +
            "                    \"registerId\": 1,\n" +
            "                    \"registerName\": \"温度\",\n" +
            "                    \"value\": 21.8,\n" +
            "                    \"text\": \"21.8\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"registerId\": 2,\n" +
            "                    \"registerName\": \"湿度\",\n" +
            "                    \"value\": 34.8,\n" +
            "                    \"text\": \"34.8\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                }\n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634714211236,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fc263cf87112d6587591f\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "                {\n" +
            "                    \"registerId\": 1,\n" +
            "                    \"registerName\": \"温度\",\n" +
            "                    \"value\": 22.0,\n" +
            "                    \"text\": \"22.0\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"registerId\": 2,\n" +
            "                    \"registerName\": \"湿度\",\n" +
            "                    \"value\": 34.9,\n" +
            "                    \"text\": \"34.9\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                }\n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634712411135,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fbb5bcf87112d6587559f\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"deviceAddr\": 40146973,\n" +
            "            \"nodeId\": 11,\n" +
            "            \"data\": [\n" +
            "                {\n" +
            "                    \"registerId\": 1,\n" +
            "                    \"registerName\": \"温度\",\n" +
            "                    \"value\": 22.1,\n" +
            "                    \"text\": \"22.1\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"registerId\": 2,\n" +
            "                    \"registerName\": \"湿度\",\n" +
            "                    \"value\": 34.1,\n" +
            "                    \"text\": \"34.1\",\n" +
            "                    \"alarmLevel\": 0\n" +
            "                }\n" +
            "            ],\n" +
            "            \"lat\": 0.0,\n" +
            "            \"lng\": 0.0,\n" +
            "            \"recordTime\": 1634710611033,\n" +
            "            \"handled\": false,\n" +
            "            \"recordId\": \"616fb453cf87112d65875220\",\n" +
            "            \"recordTimeStr\": null\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}
