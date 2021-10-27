package com.digital.fishery.service.impl;

import com.alibaba.fastjson.JSON;
import com.digital.fishery.mapper.InfoBlockPositionMapper;
import com.digital.fishery.model.InfoBlockPosition;
import com.digital.fishery.model.InfoBlockPositionExample;
import com.digital.fishery.service.InfoBlockPositionService;
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
public class InfoBlockPositionServiceImpl implements InfoBlockPositionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoBlockPositionServiceImpl.class);

    @Autowired
    private InfoBlockPositionMapper infoBlockPositionMapper;

    @Override
    public int create(InfoBlockPosition infoBlockPosition) {
        infoBlockPosition.setCreateTime(new Date());
        return infoBlockPositionMapper.insert(infoBlockPosition);
    }

    @Override
    public int update(Long id, InfoBlockPosition infoBlockPosition) {
        infoBlockPosition.setId(id);
        return infoBlockPositionMapper.updateByPrimaryKeySelective(infoBlockPosition);
    }

    @Override
    public InfoBlockPosition getItem(Long id) {
        return infoBlockPositionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return infoBlockPositionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<InfoBlockPosition> list(Long blockId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        InfoBlockPositionExample example = new InfoBlockPositionExample();
//        example.setOrderByClause("sort desc");
        if (blockId != null) {
            example.createCriteria().andBlockIdEqualTo(blockId);
        }
        List<InfoBlockPosition> infoBlockPositionList = infoBlockPositionMapper.selectByExampleWithBLOBs(example);
        for (InfoBlockPosition infoBlockPosition : infoBlockPositionList) {
            infoBlockPosition.setPositionJson(JSON.parseObject(infoBlockPosition.getPosition()));
        }
        return infoBlockPositionList;
    }

}

