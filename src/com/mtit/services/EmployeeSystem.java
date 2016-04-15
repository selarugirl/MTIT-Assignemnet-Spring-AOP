package com.mtit.services;

import java.sql.SQLException;

import org.springframework.context.support.AbstractApplicationContext;

import com.mtit.beans.Bean;
import com.mtit.beans.Employee;

public class EmployeeSystem {
	
	public void addEmployee(String name, String dob, Double salary,AbstractApplicationContext context){
		Bean employee = (Employee) context.getBean("employeeBean");
		CRUDService crudService = context.getBean("crudService",CRUDService.class);
		
		crudService.getEmployee().setName(name);
		crudService.getEmployee().setDob(dob);
		crudService.getEmployee().setSalary(salary);
		
		try {
			crudService.getEmployeesManager().insert(employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
