package com.fl.handle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDB_ColumnByColumn {

	public static void main(String[] args) throws SQLException {

		String sqldb_url = "jdbc:mysql://localhost:3307/company";
		// Use your database username here. It Is "root" for root account.
		String sqldb_uname = "root";
		String sqldb_pass = "admin";
		// To Create database connection.
		Connection db = DriverManager.getConnection(sqldb_url, sqldb_uname, sqldb_pass);

		// execute query
		Statement st = db.createStatement();
		ResultSet rs = st.executeQuery("select * from emp");

		// extract data
		
		//get column count
		ResultSetMetaData rsm = rs.getMetaData();
		int cc = rsm.getColumnCount();
		
		//loop through colmn and print data
		for (int c = 1; c <= cc; c++) {
			//print column name
			System.out.println(rsm.getColumnName(c));
			
			//verify if next row data exist and loop through it
			while (rs.next()) {
				//print row data of that column
				System.out.println(rs.getString(c));
			}
			//go to before first row to get data for next column  
			rs.beforeFirst();
		}

		db.close();
	}

}
