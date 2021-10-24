package com.digital.fishery.mapper;

import com.digital.fishery.model.DeviceFactor;
import com.digital.fishery.model.DeviceFactorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceFactorMapper {
    long countByExample(DeviceFactorExample example);

    int deleteByExample(DeviceFactorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeviceFactor record);

    int insertSelective(DeviceFactor record);

    List<DeviceFactor> selectByExample(DeviceFactorExample example);

    DeviceFactor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeviceFactor record, @Param("example") DeviceFactorExample example);

    int updateByExample(@Param("record") DeviceFactor record, @Param("example") DeviceFactorExample example);

    int updateByPrimaryKeySelective(DeviceFactor record);

    int updateByPrimaryKey(DeviceFactor record);
}