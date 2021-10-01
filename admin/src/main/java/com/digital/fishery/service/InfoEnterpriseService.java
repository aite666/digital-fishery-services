package com.digital.fishery.service;

import com.digital.fishery.model.InfoEnterprise;

import java.util.List;

/**
 * 企业信息管理Service
 * Created by qianhan on 2021-09-19
 */
public interface InfoEnterpriseService {

    /**
     * 创建企业信息
     */
    int create(InfoEnterprise infoEnterprise);

    /**
     * 修改企业信息
     */
    int update(Long id, InfoEnterprise infoEnterprise);

    /**
     * 根据ID获取企业信息详情
     */
    InfoEnterprise getItem(Long id);

    /**
     * 根据ID删除企业信息
     */
    int delete(Long id);

    /**
     * 分页查询后台企业信息
     */
    List<InfoEnterprise> list(String name, Integer pageSize, Integer pageNum);
}
