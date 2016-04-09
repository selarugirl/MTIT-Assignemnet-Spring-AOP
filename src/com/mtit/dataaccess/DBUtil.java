package com.mtit.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DATABASE_NAME = "mtitdb";
	private static final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost/"+DATABASE_NAME;
	private static final String H_MYSQL_CONNECTION_STRING = "jdbc:hsqldb:data://localhost/"+DATABASE_NAME;
	private static final String MS_MYSQL_CONNECTION_STRING = "jdbc:mssql://localhost/"+DATABASE_NAME;// this should be changed
	
	public static Connection getConnection(DatabaseType databaseType) throws SQLException{
		switch (databaseType) {
		case MYSQL:
			return DriverManager.getConnection(MYSQL_CONNECTION_STRING,USERNAME,PASSWORD);
		case HSQLDB:
			return DriverManager.getConnection(MYSQL_CONNECTION_STRING,USERNAME,PASSWORD);
		case MSSQL:
			return DriverManager.getConnection(MYSQL_CONNECTION_STRING,USERNAME,PASSWORD);
		default:
			return null;
		}
	}
	
	public static void processException(SQLException e){
		System.err.println("Error Message : "+e.getMessage());
		System.err.println("Error code : "+e.getErrorCode());
		System.err.println("SQL state : "+e.getSQLState());
	}
}
