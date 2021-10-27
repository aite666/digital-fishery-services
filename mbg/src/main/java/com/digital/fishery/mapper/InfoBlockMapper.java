package com.digital.fishery.mapper;

import com.digital.fishery.model.InfoBlock;
import com.digital.fishery.model.InfoBlockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoBlockMapper {
    long countByExample(InfoBlockExample example);

    int deleteByExample(InfoBlockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InfoBlock record);

    int insertSelective(InfoBlock record);

    List<InfoBlock> selectByExampleWithBLOBs(InfoBlockExample example);

    List<InfoBlock> selectByExample(InfoBlockExample example);

    InfoBlock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InfoBlock record, @Param("example") InfoBlockExample example);

    int updateByExampleWithBLOBs(@Param("record") InfoBlock record, @Param("example") InfoBlockExample example);

    int updateByExample(@Param("record") InfoBlock record, @Param("example") InfoBlockExample example);

    int updateByPrimaryKeySelective(InfoBlock record);

    int updateByPrimaryKeyWithBLOBs(InfoBlock record);

    int updateByPrimaryKey(InfoBlock record);
}