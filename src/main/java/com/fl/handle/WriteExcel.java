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

public class WriteExcel {

	public static void main(String[] args) throws IOException {
		//workbook>worksheet>row>column>cell
		String flPath = "C:\\Users\\envy\\Desktop\\June17th\\Output.xlsx";
		//create new work book
		Workbook wb;
		if(flPath.endsWith("xlsx")) {
			wb = new XSSFWorkbook();
		}else {
			wb = new HSSFWorkbook();
		}
		
		Sheet sheet = wb.createSheet("demo");
		Row hRow = sheet.createRow(0);
		hRow.createCell(0).setCellValue("empId");
		hRow.createCell(1).setCellValue("empName");
		hRow.createCell(2).setCellValue("empSal");
		
		Row r1 = sheet.createRow(1);
		r1.createCell(0).setCellValue("1");
		r1.createCell(1).setCellValue("sudhakar");
		r1.createCell(2).setCellValue("897987");
		
		//write to file
		FileOutputStream fo = new FileOutputStream(flPath);
		wb.write(fo);
		
		
		wb.close();
	}

}
