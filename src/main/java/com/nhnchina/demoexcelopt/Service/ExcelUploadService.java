package com.nhnchina.demoexcelopt.Service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ExcelUploadService {
    void readExcel(MultipartFile multipartFile, Map<String,Object> newFile);
}
