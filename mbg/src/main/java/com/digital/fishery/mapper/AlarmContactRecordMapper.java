package com.digital.fishery.mapper;

import com.digital.fishery.model.AlarmContactRecord;
import com.digital.fishery.model.AlarmContactRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmContactRecordMapper {
    long countByExample(AlarmContactRecordExample example);

    int deleteByExample(AlarmContactRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AlarmContactRecord record);

    int insertSelective(AlarmContactRecord record);

    List<AlarmContactRecord> selectByExample(AlarmContactRecordExample example);

    AlarmContactRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AlarmContactRecord record, @Param("example") AlarmContactRecordExample example);

    int updateByExample(@Param("record") AlarmContactRecord record, @Param("example") AlarmContactRecordExample example);

    int updateByPrimaryKeySelective(AlarmContactRecord record);

    int updateByPrimaryKey(AlarmContactRecord record);
}