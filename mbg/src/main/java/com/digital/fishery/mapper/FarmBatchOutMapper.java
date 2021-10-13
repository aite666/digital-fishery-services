package com.digital.fishery.mapper;

import com.digital.fishery.model.FarmBatchOut;
import com.digital.fishery.model.FarmBatchOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FarmBatchOutMapper {
    long countByExample(FarmBatchOutExample example);

    int deleteByExample(FarmBatchOutExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FarmBatchOut record);

    int insertSelective(FarmBatchOut record);

    List<FarmBatchOut> selectByExample(FarmBatchOutExample example);

    FarmBatchOut selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FarmBatchOut record, @Param("example") FarmBatchOutExample example);

    int updateByExample(@Param("record") FarmBatchOut record, @Param("example") FarmBatchOutExample example);

    int updateByPrimaryKeySelective(FarmBatchOut record);

    int updateByPrimaryKey(FarmBatchOut record);
}