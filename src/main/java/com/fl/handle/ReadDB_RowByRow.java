package com.fl.handle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDB_RowByRow {

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

		// get column count
		ResultSetMetaData rsm = rs.getMetaData();
		int cc = rsm.getColumnCount();

		// verify if next row data exist and loop through it
		while (rs.next()) {

			// loop through colmn and print data
			for (int c = 1; c <= cc; c++) {
				// print column data
				System.out.print(rs.getString(c)+"\t");
				
			}
			System.out.println("");
		}

		db.close();
	}

}
