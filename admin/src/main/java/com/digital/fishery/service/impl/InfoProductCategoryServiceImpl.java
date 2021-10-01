package com.digital.fishery.service.impl;

import com.digital.fishery.dao.InfoProductCategoryDao;
import com.digital.fishery.dto.InfoProductCategoryWithChildrenItem;
import com.digital.fishery.mapper.InfoProductCategoryMapper;
import com.digital.fishery.model.InfoProductCategory;
import com.digital.fishery.model.InfoProductCategoryExample;
import com.digital.fishery.service.InfoProductCategoryService;
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
public class InfoProductCategoryServiceImpl implements InfoProductCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoProductCategoryServiceImpl.class);

    @Autowired
    private InfoProductCategoryMapper infoProductCategoryMapper;

    @Autowired
    private InfoProductCategoryDao productCategoryDao;

    @Override
    public int create(InfoProductCategory infoProductCategory) {
        infoProductCategory.setCreateTime(new Date());
        setCategoryLevel(infoProductCategory);
        return infoProductCategoryMapper.insert(infoProductCategory);
    }

    @Override
    public int update(Long id, InfoProductCategory infoProductCategory) {
        infoProductCategory.setId(id);
        setCategoryLevel(infoProductCategory);
        return infoProductCategoryMapper.updateByPrimaryKeySelective(infoProductCategory);
    }

    @Override
    public InfoProductCategory getItem(Long id) {
        return infoProductCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return infoProductCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<InfoProductCategory> list(Long parentId, String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        InfoProductCategoryExample example = new InfoProductCategoryExample();
//        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        if (StringUtil.isNotEmpty(name)) {
            example.createCriteria().andNameEqualTo(name);
        }
        return infoProductCategoryMapper.selectByExample(example);
    }

    @Override
    public List<InfoProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryDao.listWithChildren();
    }

    /**
     * 根据分类的parentId设置分类的level
     */
    private void setCategoryLevel(InfoProductCategory infoProductCategory) {
        //没有父分类时为一级分类
        if (infoProductCategory.getParentId() == 0) {
            infoProductCategory.setLevel(0);
        } else {
            //有父分类时选择根据父分类level设置
            InfoProductCategory parentCategory = infoProductCategoryMapper.selectByPrimaryKey(infoProductCategory.getParentId());
            if (parentCategory != null) {
                infoProductCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                infoProductCategory.setLevel(0);
            }
        }
    }
}

