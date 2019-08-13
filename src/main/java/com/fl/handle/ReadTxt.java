package com.fl.handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTxt {

	public static void main(String[] args) throws IOException {
		
		String flPath ="C:\\Users\\envy\\Desktop\\June17th\\demo1.txt"; 
		//File fl = new File(flPath);
		FileReader fr = new FileReader(flPath);
		BufferedReader  br = new BufferedReader(fr);
		
		String strLn = br.readLine();
		while(strLn!=null) {
			
			System.out.println(strLn);
			strLn = br.readLine();
		}
		br.close();
		fr.close();
	}

}
