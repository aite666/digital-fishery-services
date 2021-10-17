package com.digital.fishery.service;

import com.digital.fishery.model.News;

import java.util.List;

/**
 * 新闻管理Service
 * Created by qianhan on 2021-09-19
 */
public interface NewsService {

    /**
     * 创建新闻
     */
    int create(News news);

    /**
     * 修改新闻
     */
    int update(Long id, News news);

    /**
     * 根据ID获取新闻详情
     */
    News getItem(Long id);

    /**
     * 根据ID删除新闻
     */
    int delete(Long id);

    /**
     * 分页查询后台新闻
     */
    List<News> list(String title, String content, Integer pageSize, Integer pageNum);
}
