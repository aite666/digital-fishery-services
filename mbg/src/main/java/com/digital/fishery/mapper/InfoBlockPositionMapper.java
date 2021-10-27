package com.digital.fishery.mapper;

import com.digital.fishery.model.InfoBlockPosition;
import com.digital.fishery.model.InfoBlockPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoBlockPositionMapper {
    long countByExample(InfoBlockPositionExample example);

    int deleteByExample(InfoBlockPositionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InfoBlockPosition record);

    int insertSelective(InfoBlockPosition record);

    List<InfoBlockPosition> selectByExampleWithBLOBs(InfoBlockPositionExample example);

    List<InfoBlockPosition> selectByExample(InfoBlockPositionExample example);

    InfoBlockPosition selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InfoBlockPosition record, @Param("example") InfoBlockPositionExample example);

    int updateByExampleWithBLOBs(@Param("record") InfoBlockPosition record, @Param("example") InfoBlockPositionExample example);

    int updateByExample(@Param("record") InfoBlockPosition record, @Param("example") InfoBlockPositionExample example);

    int updateByPrimaryKeySelective(InfoBlockPosition record);

    int updateByPrimaryKeyWithBLOBs(InfoBlockPosition record);

    int updateByPrimaryKey(InfoBlockPosition record);
}