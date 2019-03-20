package com.nhnchina.demoexcelopt.Service.impl;

import com.nhnchina.demoexcelopt.Service.ExcelUploadService;
import com.nhnchina.demoexcelopt.common.ImportExcelUtil;
import com.nhnchina.demoexcelopt.model.AllTypeRaxVO;
import com.nhnchina.demoexcelopt.model.ChildrenVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExcelUploadServiceImpl implements ExcelUploadService {
    private final Log log = LogFactory.getLog(ExcelUploadService.class);
    @Override
    public void readExcel(MultipartFile multipartFile, Map<String, Object> uploadFile) {
        //检查文件
        if(multipartFile.isEmpty()){
            try {
                log.error("文件不存在！");
                throw new FileNotFoundException("文件不存在！");


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //获得Workbook工作簿对象
        //ImportExcelUtil.getWorkBook(multipartFile);
        //readExcel

        ImportExcelUtil.readExcel(multipartFile,uploadFile);
        //获得当前sheet中的cell内容，遍历A列中包含六个对象

        AllTypeRaxVO allTypeRaxVO = new AllTypeRaxVO();

        // 判断每个sheet包含哪些个免税种类
        // ImportExcelUtil类返回格式为Map[RaxTitle:{attr1,attr2,att3,attr4...}]


    }
    /**
     * 获取子女教育扣除税信息
     */
    public List<ChildrenVO> getChildrenTaxInfo(){
        List<ChildrenVO> childrenVOList = new ArrayList<>();



        return childrenVOList;

    }
}
