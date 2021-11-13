package com.digital.fishery.mapper;

import com.digital.fishery.model.AlarmRule;
import com.digital.fishery.model.AlarmRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmRuleMapper {
    long countByExample(AlarmRuleExample example);

    int deleteByExample(AlarmRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AlarmRule record);

    int insertSelective(AlarmRule record);

    List<AlarmRule> selectByExample(AlarmRuleExample example);

    AlarmRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AlarmRule record, @Param("example") AlarmRuleExample example);

    int updateByExample(@Param("record") AlarmRule record, @Param("example") AlarmRuleExample example);

    int updateByPrimaryKeySelective(AlarmRule record);

    int updateByPrimaryKey(AlarmRule record);
}