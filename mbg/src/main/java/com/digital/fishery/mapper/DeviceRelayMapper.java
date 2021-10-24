package com.digital.fishery.mapper;

import com.digital.fishery.model.DeviceRelay;
import com.digital.fishery.model.DeviceRelayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceRelayMapper {
    long countByExample(DeviceRelayExample example);

    int deleteByExample(DeviceRelayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeviceRelay record);

    int insertSelective(DeviceRelay record);

    List<DeviceRelay> selectByExample(DeviceRelayExample example);

    DeviceRelay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeviceRelay record, @Param("example") DeviceRelayExample example);

    int updateByExample(@Param("record") DeviceRelay record, @Param("example") DeviceRelayExample example);

    int updateByPrimaryKeySelective(DeviceRelay record);

    int updateByPrimaryKey(DeviceRelay record);
}