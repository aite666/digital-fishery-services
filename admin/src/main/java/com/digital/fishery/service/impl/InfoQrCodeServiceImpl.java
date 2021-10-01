package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.InfoQrCodeMapper;
import com.digital.fishery.model.InfoQrCode;
import com.digital.fishery.model.InfoQrCodeExample;
import com.digital.fishery.service.InfoQrCodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by qianhan on 2021-09-26
 */
@Service
public class InfoQrCodeServiceImpl implements InfoQrCodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoQrCodeServiceImpl.class);

    @Autowired
    private InfoQrCodeMapper infoQrCodeMapper;

    @Override
    public int create(InfoQrCode infoQrCode) {
        infoQrCode.setCreateTime(new Date());
        return infoQrCodeMapper.insert(infoQrCode);
    }

    @Override
    public int update(Long id, InfoQrCode infoQrCode) {
        infoQrCode.setId(id);
        return infoQrCodeMapper.updateByPrimaryKeySelective(infoQrCode);
    }

    @Override
    public InfoQrCode getItem(Long id) {
        return infoQrCodeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return infoQrCodeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<InfoQrCode> list(String title, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        InfoQrCodeExample example = new InfoQrCodeExample();
//        example.setOrderByClause("sort desc");
        if (StringUtil.isNotEmpty(title)) {
            example.createCriteria().andTitleEqualTo(title);
        }
        return infoQrCodeMapper.selectByExampleWithBLOBs(example);
    }
}
