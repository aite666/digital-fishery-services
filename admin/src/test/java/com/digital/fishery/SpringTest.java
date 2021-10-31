package com.digital.fishery;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.digital.fishery.service.DeviceService;
import com.digital.fishery.dto.DeviceNodeChartsVO;
import com.digital.fishery.mapper.DeviceNodeMapper;
import com.digital.fishery.model.Device;
import com.digital.fishery.model.DeviceFactor;
import com.digital.fishery.model.DeviceNode;
import com.digital.fishery.model.DeviceNodeExample;
import com.digital.fishery.scheduled.DeviceScheduledService;
import com.digital.fishery.scheduled.domain.BaseResponse;
import com.digital.fishery.service.RedisService;
import com.digital.fishery.dto.DeviceRealTimeVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest(classes = {DigitalFisheryApplication.class})
@RunWith(SpringRunner.class)
public class SpringTest {

    @Autowired
    private RedisService redisService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private DeviceScheduledService deviceScheduledService;

    @Test
    public void test05() {
        deviceScheduledService.insertDeviceNode();
    }

    @Test
    public void test04() {
        deviceScheduledService.insertDeviceRelay();
    }

    @Test
    public void test03() {
        deviceScheduledService.insertDevice();
    }

    @Autowired
    private DeviceNodeMapper deviceNodeMapper;

    @Test
    public void test07() {
        List<Integer> deviceAddrs = Arrays.asList(40161421,40146980,40146973);
        List<DeviceRealTimeVO> deviceRealTimeVOList = deviceService.realTimeList(deviceAddrs);
        System.out.println(JSON.toJSONString(deviceRealTimeVOList));
    }

    @Test
    public void test06() {
        List<DeviceNode> deviceNodes = deviceNodeMapper.selectByExample(new DeviceNodeExample());
        Map<String, List<DeviceNode>> map = deviceNodes.stream()
                .collect(Collectors.groupingBy(o -> (o.getDeviceAddr().toString() + "," + o.getNodeId().toString())));

        List<DeviceNodeChartsVO> result = new ArrayList<>();
        for (Map.Entry<String, List<DeviceNode>> entry : map.entrySet()) {
            String key = entry.getKey();

            DeviceNodeChartsVO vo = new DeviceNodeChartsVO();
            String[] split = key.split(",");
            vo.setDeviceAddr(Integer.parseInt(split[0]));
            vo.setNodeId(Integer.parseInt(split[1]));

            List<DeviceNodeChartsVO.NodeData> data = new ArrayList<>();
            List<DeviceNode> value = entry.getValue();
            for (DeviceNode deviceNode : value) {
                DeviceNodeChartsVO.NodeData nodeData = new DeviceNodeChartsVO.NodeData();
                BeanUtils.copyProperties(deviceNode, nodeData);
                data.add(nodeData);
            }
            vo.setData(data);
            result.add(vo);
        }
        System.out.println(JSON.toJSONString(result));

    }

    @Test
    public void test02() {
        String aa = "{\n" +
                "    \"code\": 1000,\n" +
                "    \"message\": \"获取成功\",\n" +
                "    \"data\": {\n" +
                "        \"token\": \"eyJhbGciOiJIUzI1NiJ9.eyJsb2dpbk5hbWUiOiJoMjExMDE4c3pqYyIsIm1vZHVsZSI6IkFQSSIsImV4cCI6MTYzNDgzNTIxMCwidXNlcklkIjoiMTFiYWUxZTAzZWEyZDkwOTZlOTQ4YmY5ODU4MmM0ZDMiLCJpYXQiOjE2MzQ4MjgwMTAsImp0aSI6InRva2VuSWQifQ.Qom___aF3AqQTsT9upeIkYOggLBijObaIRPEVRKX65A\",\n" +
                "        \"expiration\": 1634835210\n" +
                "    }\n" +
                "}";
        BaseResponse baseResponse = JSON.parseObject(aa, BaseResponse.class);
        JSONObject jo = (JSONObject) baseResponse.getData();
        Object token = jo.get("token");
        System.out.println(token);
    }


    @Test
    public void test01() {
        String aa = "{\n" +
                "    \"code\":1000,\n" +
                "    \"message\":\"成功\",\n" +
                "    \"data\":[\n" +
                "        {\n" +
                "            \"deviceAddr\":40135434,\n" +
                "            \"groupId\":\"53657e6e09564d41b19faec38655391b\",\n" +
                "            \"deviceName\":\"40135434\",\n" +
                "            \"offlineinterval\":30,\n" +
                "            \"savedatainterval\":30,\n" +
                "            \"alarmSwitch\":3,\n" +
                "            \"alarmRecord\":1,\n" +
                "            \"lng\":0,\n" +
                "            \"lat\":0,\n" +
                "            \"useMarkLocation\":false,\n" +
                "            \"sort\":0,\n" +
                "            \"factors\":[\n" +
                "                {\n" +
                "                    \"factorId\":\"40135434_1_3\",\n" +
                "                    \"deviceAddr\":40135434,\n" +
                "                    \"nodeId\":1,\n" +
                "                    \"registerId\":3,\n" +
                "                    \"factorName\":\"溶解氧\",\n" +
                "                    \"factorIcon\":\"0.png\",\n" +
                "                    \"coefficient\":1,\n" +
                "                    \"offset\":0,\n" +
                "                    \"alarmDelay\":0,\n" +
                "                    \"alarmRate\":5,\n" +
                "                    \"digits\":2,\n" +
                "                    \"unit\":\"mg/L\",\n" +
                "                    \"enabled\":true,\n" +
                "                    \"sort\":0,\n" +
                "                    \"maxVoiceAlarmTimes\":3,\n" +
                "                    \"maxSmsAlarmTimes\":3\n" +
                "                },\n" +
                "                {\n" +
                "                    \"factorId\":\"40135434_2_1\",\n" +
                "                    \"deviceAddr\":40135434,\n" +
                "                    \"nodeId\":2,\n" +
                "                    \"registerId\":1,\n" +
                "                    \"factorName\":\"水温\",\n" +
                "                    \"factorIcon\":\"0.png\",\n" +
                "                    \"coefficient\":0.1,\n" +
                "                    \"offset\":0,\n" +
                "                    \"alarmDelay\":0,\n" +
                "                    \"alarmRate\":5,\n" +
                "                    \"digits\":2,\n" +
                "                    \"unit\":\"℃\",\n" +
                "                    \"enabled\":true,\n" +
                "                    \"sort\":0,\n" +
                "                    \"maxVoiceAlarmTimes\":3,\n" +
                "                    \"maxSmsAlarmTimes\":3\n" +
                "                },\n" +
                "                {\n" +
                "                    \"factorId\":\"40135434_2_2\",\n" +
                "                    \"deviceAddr\":40135434,\n" +
                "                    \"nodeId\":2,\n" +
                "                    \"registerId\":2,\n" +
                "                    \"factorName\":\"PH\",\n" +
                "                    \"factorIcon\":\"0.png\",\n" +
                "                    \"coefficient\":0.01,\n" +
                "                    \"offset\":0,\n" +
                "                    \"alarmDelay\":0,\n" +
                "                    \"alarmRate\":5,\n" +
                "                    \"digits\":2,\n" +
                "                    \"unit\":\"\",\n" +
                "                    \"enabled\":true,\n" +
                "                    \"sort\":0,\n" +
                "                    \"maxVoiceAlarmTimes\":3,\n" +
                "                    \"maxSmsAlarmTimes\":3\n" +
                "                }\n" +
                "            ],\n" +
                "            \"deviceCode\":\"313e678d5e167e81a5572d8b6315aa99\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"deviceAddr\":40146973,\n" +
                "            \"groupId\":\"53657e6e09564d41b19faec38655391b\",\n" +
                "            \"deviceName\":\"40146973\",\n" +
                "            \"offlineinterval\":30,\n" +
                "            \"savedatainterval\":30,\n" +
                "            \"alarmSwitch\":3,\n" +
                "            \"alarmRecord\":1,\n" +
                "            \"lng\":0,\n" +
                "            \"lat\":0,\n" +
                "            \"useMarkLocation\":false,\n" +
                "            \"sort\":0,\n" +
                "            \"factors\":[\n" +
                "                {\n" +
                "                    \"factorId\":\"40146973_11_1\",\n" +
                "                    \"deviceAddr\":40146973,\n" +
                "                    \"nodeId\":11,\n" +
                "                    \"registerId\":1,\n" +
                "                    \"factorName\":\"温度\",\n" +
                "                    \"factorIcon\":\"0.png\",\n" +
                "                    \"coefficient\":0.1,\n" +
                "                    \"offset\":0,\n" +
                "                    \"alarmDelay\":0,\n" +
                "                    \"alarmRate\":5,\n" +
                "                    \"digits\":1,\n" +
                "                    \"unit\":\"℃\",\n" +
                "                    \"enabled\":true,\n" +
                "                    \"sort\":0,\n" +
                "                    \"maxVoiceAlarmTimes\":3,\n" +
                "                    \"maxSmsAlarmTimes\":3\n" +
                "                },\n" +
                "                {\n" +
                "                    \"factorId\":\"40146973_11_2\",\n" +
                "                    \"deviceAddr\":40146973,\n" +
                "                    \"nodeId\":11,\n" +
                "                    \"registerId\":2,\n" +
                "                    \"factorName\":\"湿度\",\n" +
                "                    \"factorIcon\":\"0.png\",\n" +
                "                    \"coefficient\":0.1,\n" +
                "                    \"offset\":0,\n" +
                "                    \"alarmDelay\":0,\n" +
                "                    \"alarmRate\":5,\n" +
                "                    \"digits\":1,\n" +
                "                    \"unit\":\"%RH\",\n" +
                "                    \"enabled\":true,\n" +
                "                    \"sort\":0,\n" +
                "                    \"maxVoiceAlarmTimes\":3,\n" +
                "                    \"maxSmsAlarmTimes\":3\n" +
                "                }\n" +
                "            ],\n" +
                "            \"deviceCode\":\"4ae7216e092598cef0dd81803038731c\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"deviceAddr\":40146980,\n" +
                "            \"groupId\":\"53657e6e09564d41b19faec38655391b\",\n" +
                "            \"deviceName\":\"40146980\",\n" +
                "            \"offlineinterval\":30,\n" +
                "            \"savedatainterval\":30,\n" +
                "            \"alarmSwitch\":3,\n" +
                "            \"alarmRecord\":1,\n" +
                "            \"lng\":0,\n" +
                "            \"lat\":0,\n" +
                "            \"useMarkLocation\":false,\n" +
                "            \"sort\":0,\n" +
                "            \"factors\":[\n" +
                "                {\n" +
                "                    \"factorId\":\"40146980_11_1\",\n" +
                "                    \"deviceAddr\":40146980,\n" +
                "                    \"nodeId\":11,\n" +
                "                    \"registerId\":1,\n" +
                "                    \"factorName\":\"温度\",\n" +
                "                    \"factorIcon\":\"0.png\",\n" +
                "                    \"coefficient\":0.1,\n" +
                "                    \"offset\":0,\n" +
                "                    \"alarmDelay\":0,\n" +
                "                    \"alarmRate\":5,\n" +
                "                    \"digits\":1,\n" +
                "                    \"unit\":\"℃\",\n" +
                "                    \"enabled\":true,\n" +
                "                    \"sort\":0,\n" +
                "                    \"maxVoiceAlarmTimes\":3,\n" +
                "                    \"maxSmsAlarmTimes\":3\n" +
                "                },\n" +
                "                {\n" +
                "                    \"factorId\":\"40146980_11_2\",\n" +
                "                    \"deviceAddr\":40146980,\n" +
                "                    \"nodeId\":11,\n" +
                "                    \"registerId\":2,\n" +
                "                    \"factorName\":\"湿度\",\n" +
                "                    \"factorIcon\":\"0.png\",\n" +
                "                    \"coefficient\":0.1,\n" +
                "                    \"offset\":0,\n" +
                "                    \"alarmDelay\":0,\n" +
                "                    \"alarmRate\":5,\n" +
                "                    \"digits\":1,\n" +
                "                    \"unit\":\"%RH\",\n" +
                "                    \"enabled\":true,\n" +
                "                    \"sort\":0,\n" +
                "                    \"maxVoiceAlarmTimes\":3,\n" +
                "                    \"maxSmsAlarmTimes\":3\n" +
                "                }\n" +
                "            ],\n" +
                "            \"deviceCode\":\"1910287784246024f64329eb43f6e7f4\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"deviceAddr\":40161421,\n" +
                "            \"groupId\":\"53657e6e09564d41b19faec38655391b\",\n" +
                "            \"deviceName\":\"40161421\",\n" +
                "            \"offlineinterval\":30,\n" +
                "            \"savedatainterval\":30,\n" +
                "            \"alarmSwitch\":3,\n" +
                "            \"alarmRecord\":1,\n" +
                "            \"lng\":0,\n" +
                "            \"lat\":0,\n" +
                "            \"useMarkLocation\":false,\n" +
                "            \"sort\":0,\n" +
                "            \"factors\":[\n" +
                "                {\n" +
                "                    \"factorId\":\"40161421_1_3\",\n" +
                "                    \"deviceAddr\":40161421,\n" +
                "                    \"nodeId\":1,\n" +
                "                    \"registerId\":3,\n" +
                "                    \"factorName\":\"溶解氧\",\n" +
                "                    \"factorIcon\":\"0.png\",\n" +
                "                    \"coefficient\":1,\n" +
                "                    \"offset\":0,\n" +
                "                    \"alarmDelay\":0,\n" +
                "                    \"alarmRate\":5,\n" +
                "                    \"digits\":2,\n" +
                "                    \"unit\":\"mg/L\",\n" +
                "                    \"enabled\":true,\n" +
                "                    \"sort\":0,\n" +
                "                    \"maxVoiceAlarmTimes\":3,\n" +
                "                    \"maxSmsAlarmTimes\":3\n" +
                "                },\n" +
                "                {\n" +
                "                    \"factorId\":\"40161421_2_1\",\n" +
                "                    \"deviceAddr\":40161421,\n" +
                "                    \"nodeId\":2,\n" +
                "                    \"registerId\":1,\n" +
                "                    \"factorName\":\"水温\",\n" +
                "                    \"factorIcon\":\"0.png\",\n" +
                "                    \"coefficient\":0.1,\n" +
                "                    \"offset\":0,\n" +
                "                    \"alarmDelay\":0,\n" +
                "                    \"alarmRate\":5,\n" +
                "                    \"digits\":2,\n" +
                "                    \"unit\":\"℃\",\n" +
                "                    \"enabled\":true,\n" +
                "                    \"sort\":0,\n" +
                "                    \"maxVoiceAlarmTimes\":3,\n" +
                "                    \"maxSmsAlarmTimes\":3\n" +
                "                },\n" +
                "                {\n" +
                "                    \"factorId\":\"40161421_2_2\",\n" +
                "                    \"deviceAddr\":40161421,\n" +
                "                    \"nodeId\":2,\n" +
                "                    \"registerId\":2,\n" +
                "                    \"factorName\":\"ph\",\n" +
                "                    \"factorIcon\":\"0.png\",\n" +
                "                    \"coefficient\":0.01,\n" +
                "                    \"offset\":0,\n" +
                "                    \"alarmDelay\":0,\n" +
                "                    \"alarmRate\":5,\n" +
                "                    \"digits\":2,\n" +
                "                    \"unit\":\"\",\n" +
                "                    \"enabled\":true,\n" +
                "                    \"sort\":0,\n" +
                "                    \"maxVoiceAlarmTimes\":3,\n" +
                "                    \"maxSmsAlarmTimes\":3\n" +
                "                }\n" +
                "            ],\n" +
                "            \"deviceCode\":\"d787423f06ca4da21ab1e3d6ed34aae9\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        BaseResponse baseResponse = JSONObject.parseObject(aa, BaseResponse.class);
        List<Device> deviceList = JSON.parseObject(baseResponse.getData().toString(), new TypeReference<List<Device>>() {});
        for (Device device : deviceList) {
            List<DeviceFactor> factors = device.getFactors();
            for (DeviceFactor factor : factors) {
                System.out.println(factor.getAlarmDelay());
            }
        }
    }
}
