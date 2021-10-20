package com.digital.fishery.mapper;

import com.digital.fishery.model.BigscreenConfig;
import com.digital.fishery.model.BigscreenConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BigscreenConfigMapper {
    long countByExample(BigscreenConfigExample example);

    int deleteByExample(BigscreenConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BigscreenConfig record);

    int insertSelective(BigscreenConfig record);

    List<BigscreenConfig> selectByExampleWithBLOBs(BigscreenConfigExample example);

    List<BigscreenConfig> selectByExample(BigscreenConfigExample example);

    BigscreenConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BigscreenConfig record, @Param("example") BigscreenConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") BigscreenConfig record, @Param("example") BigscreenConfigExample example);

    int updateByExample(@Param("record") BigscreenConfig record, @Param("example") BigscreenConfigExample example);

    int updateByPrimaryKeySelective(BigscreenConfig record);

    int updateByPrimaryKeyWithBLOBs(BigscreenConfig record);

    int updateByPrimaryKey(BigscreenConfig record);
}