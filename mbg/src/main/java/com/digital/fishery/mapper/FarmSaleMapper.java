package com.digital.fishery.mapper;

import com.alibaba.fastjson.JSONObject;
import com.digital.fishery.model.FarmSale;
import com.digital.fishery.model.FarmSaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FarmSaleMapper {
    long countByExample(FarmSaleExample example);

    int deleteByExample(FarmSaleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FarmSale record);

    int insertSelective(FarmSale record);

    List<FarmSale> selectByExample(FarmSaleExample example);

    FarmSale selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FarmSale record, @Param("example") FarmSaleExample example);

    int updateByExample(@Param("record") FarmSale record, @Param("example") FarmSaleExample example);

    int updateByPrimaryKeySelective(FarmSale record);

    int updateByPrimaryKey(FarmSale record);

    List<JSONObject> getHomeSaleData(List<Long> blockIdList, String startTime, String endTime);
}