package com.digital.fishery.mapper;

import com.digital.fishery.model.InfoEquipmentCategory;
import com.digital.fishery.model.InfoEquipmentCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoEquipmentCategoryMapper {
    long countByExample(InfoEquipmentCategoryExample example);

    int deleteByExample(InfoEquipmentCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InfoEquipmentCategory record);

    int insertSelective(InfoEquipmentCategory record);

    List<InfoEquipmentCategory> selectByExample(InfoEquipmentCategoryExample example);

    InfoEquipmentCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InfoEquipmentCategory record, @Param("example") InfoEquipmentCategoryExample example);

    int updateByExample(@Param("record") InfoEquipmentCategory record, @Param("example") InfoEquipmentCategoryExample example);

    int updateByPrimaryKeySelective(InfoEquipmentCategory record);

    int updateByPrimaryKey(InfoEquipmentCategory record);
}