package com.qa.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public  String lectExcel(String filepath, String sheetname, String celda) throws IOException {
        String datoreturn="";
        File carpeta = new File(filepath);

        if (carpeta.exists()){

            FileInputStream inputStream = new FileInputStream(new File(filepath));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(sheetname);

            CellReference ref = new CellReference(celda);

            Row fila = sheet.getRow(ref.getRow());
            if (fila !=null){
                Cell columna = fila.getCell(ref.getCol());
                datoreturn= columna.getRichStringCellValue().getString();
            }

        } else {
            System.out.println("No se encontró el dato");
        }

        return datoreturn;

    }
}
