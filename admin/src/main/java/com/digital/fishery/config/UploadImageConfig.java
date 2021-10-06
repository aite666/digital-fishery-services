package com.digital.fishery.config;

import com.digital.fishery.api.CommonResult;
import com.digital.fishery.util.UploadFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class UploadImageConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadImageConfig.class);

    @RequestMapping(value = "/upload")
    @ResponseBody
    public CommonResult upload(@RequestParam("file") MultipartFile files,HttpServletRequest request) {
        String dicName="UpFile";//服务器上传文件夹名称
        String newFileName=files.getOriginalFilename();
        newFileName=newFileName.substring(0, newFileName.lastIndexOf("."));
        String picurl = UploadFileUtils.saveFile(files, newFileName, dicName, request);
        return CommonResult.success(picurl);
    }

}
