package com.digital.fishery.mapper;

import com.digital.fishery.model.FarmStorage;
import com.digital.fishery.model.FarmStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FarmStorageMapper {
    long countByExample(FarmStorageExample example);

    int deleteByExample(FarmStorageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FarmStorage record);

    int insertSelective(FarmStorage record);

    List<FarmStorage> selectByExample(FarmStorageExample example);

    FarmStorage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FarmStorage record, @Param("example") FarmStorageExample example);

    int updateByExample(@Param("record") FarmStorage record, @Param("example") FarmStorageExample example);

    int updateByPrimaryKeySelective(FarmStorage record);

    int updateByPrimaryKey(FarmStorage record);
}