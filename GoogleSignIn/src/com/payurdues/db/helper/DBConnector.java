package com.payurdues.db.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConnector {

	public Connection conn;
	Logger logger = Logger.getLogger(DBConnector.class.getName());

	public Connection connectToDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:c:/data/SQLite/payUrDues.db");
			logger.info("=====DB Connected======");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}
	
	public void closeConnection(){
		try {
			conn.close();
			logger.info("=====DB Closed======");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DBConnector connector = new DBConnector();
		connector.connectToDB();
	}
}
