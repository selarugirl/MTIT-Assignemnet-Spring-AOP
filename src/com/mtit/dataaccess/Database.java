package com.mtit.dataaccess;

import java.sql.SQLException;

import com.mtit.beans.Bean;
import com.mtit.beans.Employee;

public interface Database {

	public void displayAllRows();
	public Employee getRow(int id) throws SQLException;
	public boolean update(Bean bean) throws SQLException;
	public boolean delete(int id) throws SQLException;
	boolean insert(Bean bean) throws SQLException;
	
}
