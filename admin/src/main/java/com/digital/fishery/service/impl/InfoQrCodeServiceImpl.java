package com.digital.fishery.service.impl;

import cn.hutool.json.JSONUtil;
import com.digital.fishery.dto.BucketPolicyConfigDto;
import com.digital.fishery.dto.ConvertToMultipartFile;
import com.digital.fishery.mapper.InfoQrCodeMapper;
import com.digital.fishery.model.InfoQrCode;
import com.digital.fishery.model.InfoQrCodeExample;
import com.digital.fishery.service.InfoQrCodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import io.minio.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qianhan on 2021-09-26
 */
@Service
public class InfoQrCodeServiceImpl implements InfoQrCodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoQrCodeServiceImpl.class);

    @Autowired
    private InfoQrCodeMapper infoQrCodeMapper;

    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.bucketName}")
    private String BUCKET_NAME;
    @Value("${minio.accessKey}")
    private String ACCESS_KEY;
    @Value("${minio.secretKey}")
    private String SECRET_KEY;
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;
    private static final String OpeningPromotionUrl = "http://120.27.195.95/#/opening/promotion?id=";

    @Override
    public int create(InfoQrCode infoQrCode) {
        infoQrCode.setCreateTime(new Date());
        int count = infoQrCodeMapper.insert(infoQrCode);
        if (count == 1) {
            String url = OpeningPromotionUrl + infoQrCode.getId().toString();
            String fileName = "OpeningPromotion" + infoQrCode.getId().toString() + ".jpg";
            String monioImageUrl = createQrCode(url, fileName);
            infoQrCode.setUrl(url);
            infoQrCode.setImage(monioImageUrl);
            infoQrCodeMapper.updateByPrimaryKeySelective(infoQrCode);
        }
        return count;
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

    private String createQrCode(String url, String fileName) {
        String monioImageUrl = "";
        try {
            Map<EncodeHintType, String> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 400, 400, hints);
            BufferedImage image = toBufferedImage(bitMatrix);
            //BufferedImage 转化为 ByteArrayOutputStream
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", out);
            //ByteArrayOutputStream 转化为 byte[]
            byte[] imageByte = out.toByteArray();
            //将 byte[] 转为 MultipartFile
            MultipartFile file = new ConvertToMultipartFile(imageByte, "newQrCodePic", fileName, "jpg", imageByte.length);

            //创建一个MinIO的Java客户端
            MinioClient minioClient =MinioClient.builder()
                    .endpoint(ENDPOINT)
                    .credentials(ACCESS_KEY,SECRET_KEY)
                    .build();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            // 设置存储对象名称
            String objectName = sdf.format(new Date()) + "/" + fileName;
            // 使用putObject上传一个文件到存储桶中
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .bucket(BUCKET_NAME)
                    .object(objectName)
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(), file.getSize(), ObjectWriteArgs.MIN_MULTIPART_SIZE).build();
            minioClient.putObject(putObjectArgs);
            monioImageUrl = ENDPOINT + "/" + BUCKET_NAME + "/" + objectName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monioImageUrl;
    }

    private BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }
}
