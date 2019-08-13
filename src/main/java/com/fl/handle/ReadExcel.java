package com.fl.handle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		String flPath = "C:\\Users\\envy\\Desktop\\June17th\\Ohrm.xlsx";

		//hssf: xls ,xssf: xlsx
		
		//workbook, worksheet, row, column, cell
		
		FileInputStream fi = new FileInputStream(flPath);
		
		Workbook wb;
		if(flPath.endsWith("xlsx")) {
			wb = new XSSFWorkbook(fi);
		}else {
			wb = new HSSFWorkbook(fi);
		}
		
		Sheet sheet = wb.getSheet("Employee");
		
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();
		
		//sheet.getRow(sheet.getLastRowNum());
		
		//System.out.println(sheet.getRow(1).getCell(1).toString());
		
		for(int r=0;r<=rc;r++) {
			for(int c=0;c<cc;c++) {
				System.out.println(sheet.getRow(r).getCell(c).toString());
			}
		}
		wb.close();
	}

}
