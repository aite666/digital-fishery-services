package com.digital.fishery.mapper;

import com.digital.fishery.model.FarmAdvice;
import com.digital.fishery.model.FarmAdviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FarmAdviceMapper {
    long countByExample(FarmAdviceExample example);

    int deleteByExample(FarmAdviceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FarmAdvice record);

    int insertSelective(FarmAdvice record);

    List<FarmAdvice> selectByExample(FarmAdviceExample example);

    FarmAdvice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FarmAdvice record, @Param("example") FarmAdviceExample example);

    int updateByExample(@Param("record") FarmAdvice record, @Param("example") FarmAdviceExample example);

    int updateByPrimaryKeySelective(FarmAdvice record);

    int updateByPrimaryKey(FarmAdvice record);
}