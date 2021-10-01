package com.digital.fishery.mapper;

import com.digital.fishery.model.InfoProductCategory;
import com.digital.fishery.model.InfoProductCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoProductCategoryMapper {
    long countByExample(InfoProductCategoryExample example);

    int deleteByExample(InfoProductCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InfoProductCategory record);

    int insertSelective(InfoProductCategory record);

    List<InfoProductCategory> selectByExample(InfoProductCategoryExample example);

    InfoProductCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InfoProductCategory record, @Param("example") InfoProductCategoryExample example);

    int updateByExample(@Param("record") InfoProductCategory record, @Param("example") InfoProductCategoryExample example);

    int updateByPrimaryKeySelective(InfoProductCategory record);

    int updateByPrimaryKey(InfoProductCategory record);
}