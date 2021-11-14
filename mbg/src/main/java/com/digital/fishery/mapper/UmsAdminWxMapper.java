package com.digital.fishery.mapper;

import com.digital.fishery.model.UmsAdminWx;
import com.digital.fishery.model.UmsAdminWxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsAdminWxMapper {
    long countByExample(UmsAdminWxExample example);

    int deleteByExample(UmsAdminWxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsAdminWx record);

    int insertSelective(UmsAdminWx record);

    List<UmsAdminWx> selectByExample(UmsAdminWxExample example);

    UmsAdminWx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsAdminWx record, @Param("example") UmsAdminWxExample example);

    int updateByExample(@Param("record") UmsAdminWx record, @Param("example") UmsAdminWxExample example);

    int updateByPrimaryKeySelective(UmsAdminWx record);

    int updateByPrimaryKey(UmsAdminWx record);
}