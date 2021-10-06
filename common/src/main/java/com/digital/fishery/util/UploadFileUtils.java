package com.digital.fishery.util;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

/**
 * 上传图片
 */
public class UploadFileUtils {

    public static String saveFile(MultipartFile filedata,String newFileName,String dicName, HttpServletRequest request) {
        // TODO Auto-generated method stub
        String pathval = request.getSession().getServletContext().getRealPath("/");
        // 根据配置文件获取服务器图片存放路径
        //String newFileName = String.valueOf(System.currentTimeMillis());
        Calendar cale = null;
        cale = Calendar.getInstance();
        String year = String.valueOf(cale.get(Calendar.YEAR));
        String month = String.valueOf(cale.get(Calendar.MONTH) + 1);
        String saveFilePath = "UpFile/"+dicName+"/"+year+"/"+month+"/";
        /* 构建文件目录 */
        File fileDir = new File(pathval + saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        // 上传的文件名
        String filename = filedata.getOriginalFilename();
        // 文件的扩张名
        String extensionName = filename.substring(filename.lastIndexOf(".") + 1);
        try {
            String imgPath = saveFilePath + newFileName + "." + extensionName;
            // System.out.println(pathval + imgPath);打印图片位置
            FileOutputStream out = new FileOutputStream(pathval + imgPath);
            // 写入文件
            out.write(filedata.getBytes());
            out.flush();
            out.close();
            return imgPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
