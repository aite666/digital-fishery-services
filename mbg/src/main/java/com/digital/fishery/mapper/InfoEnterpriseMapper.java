package com.digital.fishery.mapper;

import com.digital.fishery.model.InfoEnterprise;
import com.digital.fishery.model.InfoEnterpriseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoEnterpriseMapper {
    long countByExample(InfoEnterpriseExample example);

    int deleteByExample(InfoEnterpriseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InfoEnterprise record);

    int insertSelective(InfoEnterprise record);

    List<InfoEnterprise> selectByExample(InfoEnterpriseExample example);

    InfoEnterprise selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InfoEnterprise record, @Param("example") InfoEnterpriseExample example);

    int updateByExample(@Param("record") InfoEnterprise record, @Param("example") InfoEnterpriseExample example);

    int updateByPrimaryKeySelective(InfoEnterprise record);

    int updateByPrimaryKey(InfoEnterprise record);
}