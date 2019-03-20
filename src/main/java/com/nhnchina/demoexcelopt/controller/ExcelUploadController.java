package com.nhnchina.demoexcelopt.controller;

import com.nhnchina.demoexcelopt.Service.ExcelUploadService;
import com.nhnchina.demoexcelopt.Service.MyBookService;
import com.nhnchina.demoexcelopt.common.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/excelUpload")
public class ExcelUploadController {
    @Autowired
    public FileManager fileManager;
    @Resource
    public ExcelUploadService excelUploadService;
    @Resource
    public MyBookService myBookService;

    @RequestMapping(value = "/getMybookList",method = RequestMethod.GET)
    public String importExcel(){
        return "importExcel";
    }

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public List getMybookList(){
        return myBookService.getMybookList();
    }

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(Model model, HttpServletRequest request, @RequestParam Map<String, Object> params,@RequestParam("input-folder-2[]") MultipartFile[] multipartfiles, HttpServletResponse response){
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String res = null;
        Map<String, Object> uploadFile = new HashMap<>();
        Map<String, MultipartFile> filesMap = multipartRequest.getFileMap();
        Iterator<Map.Entry<String, MultipartFile>> entries = filesMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, MultipartFile> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().getOriginalFilename());
            uploadFile = fileManager.uploadFiles(entry.getValue(),params);//上传Excel到服务器
           // ImportExcelUtil.getWorkBook(entry.getValue(),uploadFile);
            excelUploadService.readExcel(entry.getValue(),uploadFile);//解析Excel中的数据
        }
        res = uploadFile.get("atchFileNm").toString();
        return res;
    }

}
