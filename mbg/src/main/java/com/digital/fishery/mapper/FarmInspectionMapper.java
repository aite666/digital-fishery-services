package com.digital.fishery.mapper;

import com.digital.fishery.model.FarmInspection;
import com.digital.fishery.model.FarmInspectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FarmInspectionMapper {
    long countByExample(FarmInspectionExample example);

    int deleteByExample(FarmInspectionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FarmInspection record);

    int insertSelective(FarmInspection record);

    List<FarmInspection> selectByExampleWithBLOBs(FarmInspectionExample example);

    List<FarmInspection> selectByExample(FarmInspectionExample example);

    FarmInspection selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FarmInspection record, @Param("example") FarmInspectionExample example);

    int updateByExampleWithBLOBs(@Param("record") FarmInspection record, @Param("example") FarmInspectionExample example);

    int updateByExample(@Param("record") FarmInspection record, @Param("example") FarmInspectionExample example);

    int updateByPrimaryKeySelective(FarmInspection record);

    int updateByPrimaryKeyWithBLOBs(FarmInspection record);

    int updateByPrimaryKey(FarmInspection record);
}