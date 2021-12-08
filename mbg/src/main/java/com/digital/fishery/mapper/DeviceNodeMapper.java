package com.digital.fishery.mapper;

import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.model.DeviceNode;
import com.digital.fishery.model.DeviceNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceNodeMapper {
    long countByExample(DeviceNodeExample example);

    int deleteByExample(DeviceNodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeviceNode record);

    int insertSelective(DeviceNode record);

    List<DeviceNode> selectByExample(DeviceNodeExample example);

    DeviceNode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeviceNode record, @Param("example") DeviceNodeExample example);

    int updateByExample(@Param("record") DeviceNode record, @Param("example") DeviceNodeExample example);

    int updateByPrimaryKeySelective(DeviceNode record);

    int updateByPrimaryKey(DeviceNode record);

    List<JSONObject> getDeviceNodeDailyData(List<String> registerNameList, Long blockId, List<Long> blockIdList, String startTime, String endTime);
}