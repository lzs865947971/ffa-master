package com.ffa.utils;

import com.ffa.po.KeyUnit;
import com.ffa.service.KeyUnitService;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import com.ffa.po.FireRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class POIUtils {


    public static ResponseEntity<byte[]> fireRecord2Excel(List<FireRecord> list) {
        //1. 创建一个 Excel 文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2. 创建文档摘要
        workbook.createInformationProperties();
        //3. 获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("火灾记录");
        //文档管理员
        docInfo.setManager("管理员");
        //设置公司信息
        docInfo.setCompany("管理员");
        //4. 获取文档摘要信息
        SummaryInformation summInfo = workbook.getSummaryInformation();
        //文档标题
        summInfo.setTitle("火灾记录表");
        //文档作者
        summInfo.setAuthor("管理员");
        // 文档备注
        summInfo.setComments("本文档由 管理员 提供");
        //5. 创建样式
        //创建标题行的样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        HSSFSheet sheet = workbook.createSheet("历史火灾信息表");
        //设置列的宽度
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 10 * 256);
        sheet.setColumnWidth(3, 5 * 256);
        sheet.setColumnWidth(4, 12 * 256);
        sheet.setColumnWidth(5, 20 * 256);
        sheet.setColumnWidth(6, 10 * 256);
        sheet.setColumnWidth(7, 10 * 256);
        sheet.setColumnWidth(8, 16 * 256);
        sheet.setColumnWidth(9, 12 * 256);
        sheet.setColumnWidth(10, 15 * 256);
        sheet.setColumnWidth(11, 20 * 256);
        sheet.setColumnWidth(12, 16 * 256);
        sheet.setColumnWidth(13, 14 * 256);
        sheet.setColumnWidth(14, 14 * 256);
        sheet.setColumnWidth(15, 12 * 256);
        sheet.setColumnWidth(16, 8 * 256);
        sheet.setColumnWidth(17, 20 * 256);
        sheet.setColumnWidth(18, 20 * 256);
        sheet.setColumnWidth(19, 15 * 256);
        sheet.setColumnWidth(20, 8 * 256);
        sheet.setColumnWidth(21, 25 * 256);
        sheet.setColumnWidth(22, 14 * 256);
        sheet.setColumnWidth(23, 15 * 256);
        sheet.setColumnWidth(24, 15 * 256);
        //6. 创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("编号");
        c0.setCellStyle(headerStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("发生单位");
        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("火灾名称");
        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("火灾日期");
        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("直接财产损失");
        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("死亡人数");
        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("受伤人数");
        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("火灾登记人");
        HSSFCell c8 = r0.createCell(8);
        c8.setCellStyle(headerStyle);
        c8.setCellValue("描述");
        for (int i = 0; i < list.size(); i++) {
            FireRecord fr = list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(fr.getFireId());
            row.createCell(1).setCellValue(fr.getUnitName());
            row.createCell(2).setCellValue(fr.getFireName());
            HSSFCell cell3 = row.createCell(3);
            cell3.setCellStyle(dateCellStyle);
            cell3.setCellValue(fr.getFireTime());
            row.createCell(4).setCellValue(fr.getFireCost());
            row.createCell(5).setCellValue(fr.getDeathNum());
            row.createCell(6).setCellValue(fr.getInjuredNum());
            row.createCell(7).setCellValue(fr.getFireRecordPersonName());
            row.createCell(8).setCellValue(fr.getDescription());
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment", new String("火灾信息表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    /**
     * Excel 解析成 火灾数据集合
     */
    public static List<FireRecord> excel2FireRecord(MultipartFile file, List<KeyUnit> allUnits) {
        List<FireRecord> list = new ArrayList<>();
        FireRecord fr = null;
        try {
            //1. 创建一个 workbook 对象
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            //2. 获取 workbook 中表单的数量
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //3. 获取表单
                HSSFSheet sheet = workbook.getSheetAt(i);
                //4. 获取表单中的行数
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    //5. 跳过标题行
                    if (j == 0) {
                        continue;//跳过标题行
                    }
                    //6. 获取行
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//防止数据中间有空行
                    }
                    //7. 获取列数
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    fr = new FireRecord();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellType()) {
                            case STRING:
                                String cellValue = cell.getStringCellValue();
                                switch (k) {
                                    case 1:
                                        KeyUnit ku = new KeyUnit();
                                        ku.setUnitName(cellValue.toString());
                                        KeyUnitService kus = new KeyUnitService();
                                        fr.setUnitName(cellValue);
                                        //fr.setUnitId(kus.getAllKeyUnit(ku).get(0).getUnitId());
                                        break;
                                    case 2:
                                        fr.setFireName(cellValue);
                                        break;
                                    case 3:
                                        fr.setFireTime(cellValue);
                                        break;

                                    case 7:
                                        fr.setDescription(cellValue);
                                        fr.setFireRecordPersonName(UserInfUtils.getCurrentUser().getName());
                                        break;
                                }
                                break;
                            default: {
                                switch (k) {
                                    case 4:
                                        fr.setFireCost((int)(cell.getNumericCellValue()));
                                        break;
                                    case 5:
                                        fr.setDeathNum((int)(cell.getNumericCellValue()));
                                        break;
                                    case 6:
                                        fr.setInjuredNum((int)(cell.getNumericCellValue()));
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    list.add(fr);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
