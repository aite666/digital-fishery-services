package com.digital.fishery.service;

import com.digital.fishery.model.InfoQrCode;

import java.util.List;

/**
 * 二维码管理Service
 * Created by qianhan on 2021-09-26
 */
public interface InfoQrCodeService {

    /**
     * 创建二维码
     */
    int create(InfoQrCode infoQrCode);

    /**
     * 修改二维码
     */
    int update(Long id, InfoQrCode infoQrCode);

    /**
     * 根据ID获取二维码详情
     */
    InfoQrCode getItem(Long id);

    /**
     * 根据ID删除二维码
     */
    int delete(Long id);

    /**
     * 分页查询后台二维码
     */
    List<InfoQrCode> list(String title, Integer pageSize, Integer pageNum);
}
