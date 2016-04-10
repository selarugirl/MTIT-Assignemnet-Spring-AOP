package com.mtit.services;

import com.mtit.beans.Employee;
import com.mtit.dataaccess.EmployeesManager;

public class CRUDService {
	
	private EmployeesManager employeesManager;

	private Employee employee;
	
	
	public EmployeesManager getEmployeesManager() {
		return employeesManager;
	}

	public void setEmployeesManager(EmployeesManager employeesManager) {
		this.employeesManager = employeesManager;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
