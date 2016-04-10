package com.mtit.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.mtit.beans.Bean;
import com.mtit.beans.Employee;

public class EmployeesManager implements Database {

	@Override
	public void displayAllRows() {
	}

	@Override
	public Employee getRow(int id) throws SQLException {

		String sql = "SELECT * FROM employee WHERE id = ? ";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			// connection =
			// DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
			connection = DBUtil.getConnection(DatabaseType.MSSQL);
			System.out.println("Database connection established");

			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(id);
				employee.setName(resultSet.getString("name"));
				employee.setDob(resultSet.getDate("dob").toString());
				employee.setSalary(resultSet.getDouble("salary"));
				return employee;
			} else {
				System.err.println("no rows were found");
				return null;
			}
		} catch (SQLException e) {
			DBUtil.processException(e);
			return null;
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public boolean insert(Bean bean) throws SQLException {
		String sql = "INSERT INTO employee (name,dob,salary) values(?,?,?);";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet keys = null;

		try {
			Employee employee = null;
			if (bean instanceof Employee) {
				employee = (Employee) bean;

				connection = DBUtil.getConnection(DatabaseType.MSSQL);
				System.out.println("Connected");
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, employee.getName());
				statement.setString(2, employee.getDob());
				statement.setDouble(3, employee.getSalary());
				int affected = statement.executeUpdate();
				if (affected == 1) {
					keys = statement.getGeneratedKeys();
					keys.next();
					int newKey = keys.getInt(1);
					employee.setId(newKey);
					System.out.println("data inseted successful");
					return true;
				} else {
					System.err.println("no rows affected");
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			DBUtil.processException(e);
			return false;
		} finally {
			if (keys != null) {
				keys.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public boolean update(Bean bean) throws SQLException {
		String sql = "UPDATE employee SET " + "name = ?,dob = ?, salary = ? " + "WHERE id = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Employee employee = null;
			if (bean instanceof Employee) {
				employee = (Employee) bean;

				connection = DBUtil.getConnection(DatabaseType.MSSQL);
				System.out.println("Connected");
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, employee.getName());
				statement.setString(2, employee.getDob());
				statement.setDouble(3, employee.getSalary());
				statement.setInt(4, employee.getId());

				int affected = statement.executeUpdate();
				if (affected == 1) {
					System.out.println("update successful");
					return true;
				} else {
					System.err.println("no rows affected");
					return false;
				}
			}else{
				return false;
			}
		} catch (SQLException e) {
			DBUtil.processException(e);
			return false;
		} finally {

			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public boolean delete(int id) throws SQLException {
		String sql = "DELETE FROM employee WHERE id = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DBUtil.getConnection(DatabaseType.MSSQL);
			System.out.println("Connected");
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, id);

			int affected = statement.executeUpdate();
			if (affected == 1) {
				System.out.println("delete successful");
				return true;
			} else {
				System.err.println("no rows affected");
				return false;
			}
		} catch (SQLException e) {
			DBUtil.processException(e);
			return false;
		} finally {

			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}


}
