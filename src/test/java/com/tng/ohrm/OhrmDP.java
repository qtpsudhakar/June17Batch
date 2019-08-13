package com.tng.ohrm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import com.fl.handle.ReadJson;

public class OhrmDP {
	
	@DataProvider(name="getEmpData")
	public String[][] getData() {
		//1st dimension controls iterations
		//2nd dimension controls number of parameters in target test method
		String[][] tData = new String[2][2];

		// 1st time
		tData[0][0] = "Selenium";
		tData[0][1] = "Hq";

		// 2nd time
		tData[1][0] = "web";
		tData[1][1] = "driver";

		return tData;
	}
	
	@DataProvider(name="getEmpDataMap")
	public Object[][] getDataMap() {
		//1st dimension controls iterations
		//2nd dimension controls number of parameters in target test method
		Object[][] tData = new Object[2][1];

		HashMap<String, String> dataMap1 = new HashMap<String, String>();
		dataMap1.put("fname", "selenium");
		dataMap1.put("lname", "hq");
		
		HashMap<String, String> dataMap2 = new HashMap<String, String>();
		dataMap2.put("fname", "web");
		dataMap2.put("lname", "driver");	
		
		// 1st time
		tData[0][0] = dataMap1;

		// 2nd time
		tData[1][0] = dataMap2;

		return tData;
	}

	@DataProvider(name="getEmpDataMapJson")
	public Object[][] getDataMapFromJson(Method method) throws FileNotFoundException, IOException, ParseException {
		//1st dimension controls iterations
		//2nd dimension controls number of parameters in target test method
		
		String tcName = method.getName();
		System.out.println(tcName);
	
		Object[][] tData =ReadJson.getDataFromTc(tcName);				
				
		return tData;
	}
	
	@DataProvider(name="getEmpDataMapExcel")
	public Object[][] getDataMapFromExcel(Method method) throws IOException{
		//1st dimension controls iterations
		//2nd dimension controls number of parameters in target test method
		
		String tcName = method.getName();
		System.out.println(tcName);				
			
		String flPath = "src\\test\\resources\\data\\Ohrm.xlsx";

		//hssf: xls ,xssf: xlsx
		
		//workbook, worksheet, row, column, cell
		
		FileInputStream fi = new FileInputStream(flPath);
		
		Workbook wb;
		if(flPath.endsWith("xlsx")) {
			wb = new XSSFWorkbook(fi);
		}else {
			wb = new HSSFWorkbook(fi);
		}
		
		Sheet sheet = wb.getSheet(tcName);
		
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();
		
		
		Object[][] tData =new Object[rc][1];
		for(int r=1;r<=rc;r++) {
			HashMap<String, String> tcMap = new HashMap<String, String>();
			for(int c=0;c<cc;c++) {
				String kName = sheet.getRow(0).getCell(c).toString();
				String kVal = sheet.getRow(r).getCell(c).toString();
				tcMap.put(kName, kVal);
			}
			tData[r-1][0]=tcMap;
		}
		wb.close();

		return tData;
	}
}
