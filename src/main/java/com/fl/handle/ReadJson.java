package com.fl.handle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ReadJson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Object[] mapArr = getDataFromTc("AddEmployeeTest")[0];
		HashMap<String, String> map = (HashMap<String, String>) mapArr[0];
		System.out.println(map.get("firstName"));
	}

	public static Object[][] getDataFromTc(String tcName) throws FileNotFoundException, IOException, ParseException  {
		String flPath = "src\\test\\resources\\data\\TestData.json";
		
		JSONParser jo = new JSONParser();
		JSONObject json= (JSONObject) jo.parse(new FileReader(flPath));
				
		JSONArray tcDataArray = (JSONArray) json.get(tcName);		
		Object [][] tcData = new Object[tcDataArray.size()][1];
		
		for (int r = 0; r < tcDataArray.size(); r++) {
			JSONObject tcRows = (JSONObject) tcDataArray.get(r);

			 HashMap<String, String> tcMap = (HashMap<String, String>) tcRows.clone();
			//System.out.println(tcMap);
			tcData[r][0]=tcMap;
		}
		
		return tcData;
	}

	
}
