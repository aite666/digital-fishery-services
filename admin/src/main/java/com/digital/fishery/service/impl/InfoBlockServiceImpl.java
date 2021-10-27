package com.digital.fishery.service.impl;

import com.alibaba.fastjson.JSON;
import com.digital.fishery.mapper.InfoBlockMapper;
import com.digital.fishery.model.InfoBlock;
import com.digital.fishery.model.InfoBlockExample;
import com.digital.fishery.model.InfoBlock;
import com.digital.fishery.service.InfoBlockService;
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
public class InfoBlockServiceImpl implements InfoBlockService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoBlockServiceImpl.class);

    @Autowired
    private InfoBlockMapper infoBlockMapper;

    @Override
    public int create(InfoBlock infoBlock) {
        infoBlock.setCreateTime(new Date());
        return infoBlockMapper.insert(infoBlock);
    }

    @Override
    public int update(Long id, InfoBlock infoBlock) {
        infoBlock.setId(id);
        return infoBlockMapper.updateByPrimaryKeySelective(infoBlock);
    }

    @Override
    public InfoBlock getItem(Long id) {
        InfoBlock infoBlock = infoBlockMapper.selectByPrimaryKey(id);
        if (StringUtil.isNotEmpty(infoBlock.getPosition())) {
            infoBlock.setPositionJson(JSON.parseArray(infoBlock.getPosition()));
        }
        return infoBlock;
    }

    @Override
    public int delete(Long id) {
        return infoBlockMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<InfoBlock> list(String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        InfoBlockExample example = new InfoBlockExample();
//        example.setOrderByClause("sort desc");
        if (StringUtil.isNotEmpty(name)) {
            example.createCriteria().andNameEqualTo(name);
        }
        List<InfoBlock> infoBlockList = infoBlockMapper.selectByExampleWithBLOBs(example);
        for (InfoBlock infoBlock : infoBlockList) {
            if (StringUtil.isNotEmpty(infoBlock.getPosition())) {
                infoBlock.setPositionJson(JSON.parseArray(infoBlock.getPosition()));
            }
        }
        return infoBlockList;
    }

}

