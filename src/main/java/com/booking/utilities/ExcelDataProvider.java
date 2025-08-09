package com.booking.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {

    @DataProvider(name = "searchData")
    public Object[][] readExcelData() throws IOException {
        String excelFilePath = System.getProperty("user.dir") + "/test-data/searchData.xlsx";
        FileInputStream fis = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();
        //int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        int colCount = 3;

        // count valid (non-empty) rows
        int validRows = 0;
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row != null && row.getCell(0) != null && !row.getCell(0).toString().trim().isEmpty()) {
                validRows++;
            }
        }

        Object[][] data = new Object[validRows][colCount];

        int dataRowIndex = 0;
        for (int i = 1; i < rowCount; i++) { // skip header
            Row row = sheet.getRow(i);
            if (row == null || row.getCell(0) == null || row.getCell(0).toString().trim().isEmpty()) {
                continue; // skip empty rows
            }
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                data[dataRowIndex][j] = getCellValue(cell);
            }
            dataRowIndex++;
        }

        workbook.close();
        fis.close();

        return data;
    }

    private Object getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            default:
                return "";
        }
    }
}
