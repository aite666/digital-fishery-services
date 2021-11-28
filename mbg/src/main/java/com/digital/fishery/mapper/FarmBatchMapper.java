package com.digital.fishery.mapper;

import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.model.FarmBatch;
import com.digital.fishery.model.FarmBatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FarmBatchMapper {
    long countByExample(FarmBatchExample example);

    int deleteByExample(FarmBatchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FarmBatch record);

    int insertSelective(FarmBatch record);

    List<FarmBatch> selectByExample(FarmBatchExample example);

    FarmBatch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FarmBatch record, @Param("example") FarmBatchExample example);

    int updateByExample(@Param("record") FarmBatch record, @Param("example") FarmBatchExample example);

    int updateByPrimaryKeySelective(FarmBatch record);

    int updateByPrimaryKey(FarmBatch record);

    List<JSONObject> listProductCategory(Long blockId, List<Long> blockIdList);

    List<JSONObject> getHomeBatchData(List<Long> blockIdList, String startTime, String endTime);
}