package com.fl.handle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTxt {

	public static void main(String[] args) {

		String flPath = "C:\\Users\\envy\\Desktop\\June17th\\demo2.txt";

		try {
			FileWriter fw = new FileWriter(flPath, true); // true will append text
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("line1");
			bw.newLine();
			bw.write("line2");
			bw.newLine();
			bw.write("line3");
			bw.newLine();
			bw.write("line4");
			bw.newLine();

			bw.flush();
			bw.write("line5");

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
