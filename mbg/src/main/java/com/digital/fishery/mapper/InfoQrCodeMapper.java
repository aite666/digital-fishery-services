package com.digital.fishery.mapper;

import com.digital.fishery.model.InfoQrCode;
import com.digital.fishery.model.InfoQrCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoQrCodeMapper {
    long countByExample(InfoQrCodeExample example);

    int deleteByExample(InfoQrCodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InfoQrCode record);

    int insertSelective(InfoQrCode record);

    List<InfoQrCode> selectByExampleWithBLOBs(InfoQrCodeExample example);

    List<InfoQrCode> selectByExample(InfoQrCodeExample example);

    InfoQrCode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InfoQrCode record, @Param("example") InfoQrCodeExample example);

    int updateByExampleWithBLOBs(@Param("record") InfoQrCode record, @Param("example") InfoQrCodeExample example);

    int updateByExample(@Param("record") InfoQrCode record, @Param("example") InfoQrCodeExample example);

    int updateByPrimaryKeySelective(InfoQrCode record);

    int updateByPrimaryKeyWithBLOBs(InfoQrCode record);

    int updateByPrimaryKey(InfoQrCode record);
}