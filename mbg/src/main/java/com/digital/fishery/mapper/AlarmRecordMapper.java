package com.digital.fishery.mapper;

import com.digital.fishery.model.AlarmRecord;
import com.digital.fishery.model.AlarmRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmRecordMapper {
    long countByExample(AlarmRecordExample example);

    int deleteByExample(AlarmRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AlarmRecord record);

    int insertSelective(AlarmRecord record);

    List<AlarmRecord> selectByExample(AlarmRecordExample example);

    AlarmRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AlarmRecord record, @Param("example") AlarmRecordExample example);

    int updateByExample(@Param("record") AlarmRecord record, @Param("example") AlarmRecordExample example);

    int updateByPrimaryKeySelective(AlarmRecord record);

    int updateByPrimaryKey(AlarmRecord record);
}