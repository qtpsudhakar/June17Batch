package com.fl.handle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UpdateExcel {

	public static void main(String[] args) throws IOException {
		//workbook>worksheet>row>column>cell
		String flPath = "C:\\Users\\envy\\Desktop\\June17th\\Output.xlsx";
		
		FileInputStream fis = new FileInputStream(flPath);
		//create new work book
		Workbook wb;
		if(flPath.endsWith("xlsx")) {
			wb = new XSSFWorkbook(fis);
		}else {
			wb = new HSSFWorkbook(fis);
		}
		
		Sheet sheet = wb.getSheet("demo");
				
		Row r2 = sheet.createRow(sheet.getLastRowNum()+1);
		r2.createCell(0).setCellValue("2");
		r2.createCell(1).setCellValue("balu");
		r2.createCell(2).setCellValue("765767");
		
		//write to file
		FileOutputStream fo = new FileOutputStream(flPath);
		wb.write(fo);
		
		
		wb.close();
	}

}
