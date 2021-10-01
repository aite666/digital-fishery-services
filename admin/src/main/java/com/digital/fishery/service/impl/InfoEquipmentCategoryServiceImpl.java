package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.InfoEquipmentCategoryMapper;
import com.digital.fishery.model.InfoEquipmentCategory;
import com.digital.fishery.model.InfoEquipmentCategoryExample;
import com.digital.fishery.service.InfoEquipmentCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by qianhan on 2021-09-19
 */
@Service
public class InfoEquipmentCategoryServiceImpl implements InfoEquipmentCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoEquipmentCategoryServiceImpl.class);

    @Autowired
    private InfoEquipmentCategoryMapper infoEquipmentCategoryMapper;

    @Override
    public int create(InfoEquipmentCategory infoEquipmentCategory) {
        infoEquipmentCategory.setCreateTime(new Date());
        return infoEquipmentCategoryMapper.insert(infoEquipmentCategory);
    }

    @Override
    public int update(Long id, InfoEquipmentCategory infoEquipmentCategory) {
        infoEquipmentCategory.setId(id);
        return infoEquipmentCategoryMapper.updateByPrimaryKeySelective(infoEquipmentCategory);
    }

    @Override
    public InfoEquipmentCategory getItem(Long id) {
        return infoEquipmentCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return infoEquipmentCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<InfoEquipmentCategory> list(String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        InfoEquipmentCategoryExample example = new InfoEquipmentCategoryExample();
//        example.setOrderByClause("sort desc");
        if (StringUtil.isNotEmpty(name)) {
            example.createCriteria().andNameEqualTo(name);
        }
        return infoEquipmentCategoryMapper.selectByExample(example);
    }

}

