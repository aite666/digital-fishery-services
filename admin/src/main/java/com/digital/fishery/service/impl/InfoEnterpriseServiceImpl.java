package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.InfoEnterpriseMapper;
import com.digital.fishery.model.InfoEnterprise;
import com.digital.fishery.model.InfoEnterpriseExample;
import com.digital.fishery.service.InfoEnterpriseService;
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
public class InfoEnterpriseServiceImpl implements InfoEnterpriseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoEnterpriseServiceImpl.class);

    @Autowired
    private InfoEnterpriseMapper infoEnterpriseMapper;

    @Override
    public int create(InfoEnterprise infoEnterprise) {
        infoEnterprise.setCreateTime(new Date());
        return infoEnterpriseMapper.insert(infoEnterprise);
    }

    @Override
    public int update(Long id, InfoEnterprise infoEnterprise) {
        infoEnterprise.setId(id);
        return infoEnterpriseMapper.updateByPrimaryKeySelective(infoEnterprise);
    }

    @Override
    public InfoEnterprise getItem(Long id) {
        return infoEnterpriseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return infoEnterpriseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<InfoEnterprise> list(String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        InfoEnterpriseExample example = new InfoEnterpriseExample();
//        example.setOrderByClause("sort desc");
        if (StringUtil.isNotEmpty(name)) {
            example.createCriteria().andNameEqualTo(name);
        }
        return infoEnterpriseMapper.selectByExample(example);
    }

}

