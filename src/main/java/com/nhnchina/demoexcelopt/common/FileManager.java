package com.nhnchina.demoexcelopt.common;

import javafx.scene.input.DataFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class FileManager {
    private final Log log = LogFactory.getLog(FileManager.class);

    private final String defaultExcelPath="/Users/naver/irteam/";

    public Map<String, Object> uploadFiles(MultipartFile multipartFile, Map<String, Object> params){
        Map<String,Object> newParams = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        String currentDate = sdf.format(new Date());
        String fileSuffix = currentDate;

        String fileName = multipartFile.getOriginalFilename();
        String fileExt = fileName.substring(fileName.lastIndexOf("."), fileName.length());

        String atchFileNm = fileName.substring(0,fileName.lastIndexOf("."))+ "_"+ fileSuffix+fileExt;
        String atchFilePath = defaultExcelPath;

        // 文件名
        newParams.put("atchFileNm", atchFileNm);

        // 文件路径
        newParams.put("atchFilePath", atchFilePath);

        // 文件大小
        newParams.put("fileSize", multipartFile.getSize());

        //生成文件
        File directory = new File(atchFilePath);
        File newFile = new File(atchFilePath+atchFileNm);

        if (!directory.exists()) {
            directory.mkdirs();
        }
        try {
            //转存文件
            multipartFile.transferTo(newFile);
        } catch (IOException e) {
            log.debug("[FileManager error]",e);
        }
        return newParams;
    }


}
