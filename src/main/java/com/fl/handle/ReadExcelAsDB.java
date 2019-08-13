package com.fl.handle;

import java.util.ArrayList;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReadExcelAsDB {

	public static void main(String[] args) throws FilloException {

		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("C:\\Users\\envy\\Desktop\\June17th\\Ohrm.xlsx");
		String strQuery = "Select * from Employee";
		Recordset recordset = connection.executeQuery(strQuery);

		ArrayList<String> columnNames = recordset.getFieldNames();
		
		while (recordset.next()) {
			for (String col : columnNames) {
				System.out.println(recordset.getField(col));
			}
		}

		recordset.close();
		connection.close();

	}

}
