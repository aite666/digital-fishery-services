package com.digital.fishery.mapper;

import com.digital.fishery.model.FarmAdviceDetail;
import com.digital.fishery.model.FarmAdviceDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FarmAdviceDetailMapper {
    long countByExample(FarmAdviceDetailExample example);

    int deleteByExample(FarmAdviceDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FarmAdviceDetail record);

    int insertSelective(FarmAdviceDetail record);

    List<FarmAdviceDetail> selectByExample(FarmAdviceDetailExample example);

    FarmAdviceDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FarmAdviceDetail record, @Param("example") FarmAdviceDetailExample example);

    int updateByExample(@Param("record") FarmAdviceDetail record, @Param("example") FarmAdviceDetailExample example);

    int updateByPrimaryKeySelective(FarmAdviceDetail record);

    int updateByPrimaryKey(FarmAdviceDetail record);
}