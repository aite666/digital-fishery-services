package com.digital.fishery.mapper;

import com.digital.fishery.model.FarmStorageRecord;
import com.digital.fishery.model.FarmStorageRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FarmStorageRecordMapper {
    long countByExample(FarmStorageRecordExample example);

    int deleteByExample(FarmStorageRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FarmStorageRecord record);

    int insertSelective(FarmStorageRecord record);

    List<FarmStorageRecord> selectByExample(FarmStorageRecordExample example);

    FarmStorageRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FarmStorageRecord record, @Param("example") FarmStorageRecordExample example);

    int updateByExample(@Param("record") FarmStorageRecord record, @Param("example") FarmStorageRecordExample example);

    int updateByPrimaryKeySelective(FarmStorageRecord record);

    int updateByPrimaryKey(FarmStorageRecord record);
}