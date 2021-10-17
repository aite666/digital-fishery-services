package com.digital.fishery.service.impl;

import com.digital.fishery.mapper.NewsMapper;
import com.digital.fishery.model.News;
import com.digital.fishery.model.NewsExample;
import com.digital.fishery.service.NewsService;
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
public class NewsServiceImpl implements NewsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public int create(News news) {
        news.setCreateTime(new Date());
        return newsMapper.insert(news);
    }

    @Override
    public int update(Long id, News news) {
        news.setId(id);
        return newsMapper.updateByPrimaryKeySelective(news);
    }

    @Override
    public News getItem(Long id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<News> list(String title, String content, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("news_time desc");
        if (StringUtil.isNotEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (StringUtil.isNotEmpty(content)) {
            criteria.andContentLike("%" + content + "%");
        }
        return newsMapper.selectByExampleWithBLOBs(example);
    }

}

