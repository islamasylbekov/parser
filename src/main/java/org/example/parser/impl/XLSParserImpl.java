package org.example.parser.impl;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.example.util.Util;
import org.example.models.xls.XLSModel;
import org.example.parser.XLSParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XLSParserImpl implements XLSParser {

    private List<XLSModel> xlsModelList = new ArrayList<>();

    @Override
    public synchronized List<XLSModel> parse(String path) {
        xlsModelList.clear();
        FileInputStream fis;
        HSSFWorkbook wb;
        try {
            fis = new FileInputStream(path);
            wb=new HSSFWorkbook(fis);

            HSSFSheet sheet=wb.getSheetAt(0);
            for(Row row: sheet)
            {
                XLSModel xlsModel = new XLSModel();
                Double temp = null;
                for(Cell cell: row) {
                    if (cell.getCellType().equals(CellType.NUMERIC)){
                        xlsModel = null;
                        break;
                    }
                    String currentBox = cell.getStringCellValue();
                    int currentColumn = cell.getAddress().getColumn();
                    if (currentColumn == 0) {
                        if (currentBox.length() < 12){
                            xlsModel = null;
                            break;
                        }
                        Pattern p = Pattern.compile(Util.DATE_PATTERN);
                        Matcher matcher = p.matcher(currentBox.substring(0,11));
                        if (!matcher.find()) {
                            xlsModel = null;
                            break;
                        }
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Util.DATE_FORMAT);
                        xlsModel.setDate(LocalDate.parse(matcher.group(), formatter));
                    }
                    else if (currentColumn == 1) {
                        xlsModel.setRecipient(currentBox.replaceAll("\\u00a0",""));
                    }
                    else if (currentColumn == 2) {
                        temp = doubeleParse(currentBox);
                    }
                    else if(currentColumn == 3) {
                        Double current = doubeleParse(currentBox);
                        xlsModel.setSum(current + Optional.of(temp).orElse(0.0));
                    }
                    else if (currentColumn == 4) {
                        xlsModel.setOperation(currentBox.replaceAll("\\u00a0",""));
                        xlsModel.setOperationId(getOperationId(currentBox));
                    }
                }
                if (xlsModel != null){
                    xlsModelList.add(xlsModel);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return xlsModelList;
    }

    private Double doubeleParse(String value){
        Pattern p = Pattern.compile(Util.DOUBLE_PATTERN);
        Matcher matcher = p.matcher(value.replaceAll(",",""));
        while (matcher.find()){
           return Double.parseDouble(matcher.group());
        }
        return 0d;
    }

    private String getOperationId(String value){
        Pattern p = Pattern.compile(Util.OPERATION_ID_PATTERN);
        Matcher matcher = p.matcher(value);
        return  matcher.find() ? matcher.group() : "";
    }
}
