package com.nhnchina.demoexcelopt.common;

import com.nhnchina.demoexcelopt.model.AllTypeRaxVO;
import com.nhnchina.demoexcelopt.model.ChildrenVO;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.in;

public class ImportExcelUtil {
    private static final String defaultExcelPath="/Users/naver/irteam/";

    public static Workbook getWorkBook(MultipartFile multipartFile,Map<String,Object> newParam) {
        Workbook  workbook = null;
        //寻找目录读取文件
       // String fileName = multipartFile.getOriginalFilename();
        InputStream is = null;

        CommonsMultipartFile cFile = (CommonsMultipartFile) multipartFile;
//        DiskFileItem fileItem = (DiskFileItem) cFile.getFileItem();

        try {
            File excelFile = new File(newParam.get("atchFilePath").toString() + newParam.get("atchFileNm").toString());
            is = new FileInputStream(excelFile);

            if (newParam.get("atchFileNm").toString().toLowerCase().endsWith(".xlsx")) {//toLowerCase 区分大小写
                workbook = new XSSFWorkbook(is);// Excel 2007
            } else {
                workbook = (Workbook) new HSSFWorkbook(is);// Excel 2003
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    /**
     * 读取Excel文件(按类型返回)
     */
    public static List<AllTypeRaxVO> readExcel(MultipartFile excelFile, Map<String,Object> newFile) {
        Workbook workBook = getWorkBook(excelFile,newFile);
        if(workBook != null){
            for(int sheetNum = 0;sheetNum < workBook.getNumberOfSheets();sheetNum++){
                //获取当前sheet工作表
                Sheet sheet = workBook.getSheetAt(sheetNum);
                if(null == sheet){
                    continue;
                }
                int lastRowNum = sheet.getLastRowNum();
                //遍历Excel的每一行的第一列 取出申报免税的条目
                for(int rowNum =0; rowNum < lastRowNum; rowNum++){
                    Row row = sheet.getRow(rowNum);
                    //获得当前行的列数
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    if(lastCellNum == 1){//独占一行的单元格
                        Cell cell = row.getCell(0);

                        String title = getCellValue(cell);
                        //getExcelList

                    }
                }

            }
        }

        List<AllTypeRaxVO> allTypeRaxVOList = new ArrayList<AllTypeRaxVO>();
        return allTypeRaxVOList;
    }

    /**
     *  创建excel
     */
    public static String getCellValue(Cell cell){
        String cellValue = "";

        if(cell == null){
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        cellValue = String.valueOf(cell.getStringCellValue());

        return cellValue;
    }

    /**
     * 合并单元格处理,获取合并行
     * @param sheet
     * @return List<CellRangeAddress>
     */
    public List<CellRangeAddress> getCombineCell(Sheet sheet)
    {
        List<CellRangeAddress> list = new ArrayList<CellRangeAddress>();
        //获得一个 sheet 中合并单元格的数量
        int sheetmergerCount = sheet.getNumMergedRegions();
        //遍历所有的合并单元格
        for(int i = 0; i<sheetmergerCount;i++)
        {
            //获得合并单元格保存进list中
            CellRangeAddress ca = sheet.getMergedRegion(i);
            list.add(ca);
        }
        return list;
    }

    private int getRowNum(List<CellRangeAddress> listCombineCell,Cell cell,Sheet sheet){
        int xr = 0;
        int firstC = 0;
        int lastC = 0;
        int firstR = 0;
        int lastR = 0;
        for(CellRangeAddress ca:listCombineCell)
        {
            //获得合并单元格的起始行, 结束行, 起始列, 结束列
            firstC = ca.getFirstColumn();
            lastC = ca.getLastColumn();
            firstR = ca.getFirstRow();
            lastR = ca.getLastRow();
            if(cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR)
            {
                if(cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC)
                {
                    xr = lastR;
                }
            }

        }
        return xr;

    }
    /**
     * 判断单元格是否为合并单元格，是的话则将单元格的值返回
     * @param listCombineCell 存放合并单元格的list
     * @param cell 需要判断的单元格
     * @param sheet sheet
     * @return
     */
    public String isCombineCell(List<CellRangeAddress> listCombineCell,Cell cell,Sheet sheet)
            throws Exception{
        int firstC = 0;
        int lastC = 0;
        int firstR = 0;
        int lastR = 0;
        String cellValue = null;
        for(CellRangeAddress ca:listCombineCell)
        {
            //获得合并单元格的起始行, 结束行, 起始列, 结束列
            firstC = ca.getFirstColumn();
            lastC = ca.getLastColumn();
            firstR = ca.getFirstRow();
            lastR = ca.getLastRow();
            if(cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR)
            {
                if(cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC)
                {
                    Row fRow = sheet.getRow(firstR);
                    Cell fCell = fRow.getCell(firstC);
                    cellValue = getCellValue(fCell);
                    break;
                }
            }
            else
            {
                cellValue = "";
            }
        }
        return cellValue;
    }

    /**
     * 获取合并单元格的值
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public String getMergedRegionValue(Sheet sheet ,int row , int column){
        int sheetMergeCount = sheet.getNumMergedRegions();

        for(int i = 0 ; i < sheetMergeCount ; i++){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell) ;
                }
            }
        }

        return null ;
    }


    /**
     * 判断指定的单元格是否是合并单元格
     * @param sheet
     * @param row 行下标
     * @param column 列下标
     * @return
     */
    private boolean isMergedRegion(Sheet sheet,int row ,int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true;
                }
            }
        }
        return false;
    }

}
