package com.mtit.services;

import java.sql.SQLException;

import org.springframework.context.support.AbstractApplicationContext;

import com.mtit.beans.Bean;
import com.mtit.beans.Employee;

public class EmployeeSystem implements Service {
	
	public void addEmployee(String name, String dob, Double salary,AbstractApplicationContext  context){
		Bean employee = (Employee) context.getBean("employeeBean");
		CRUDService crudService = context.getBean("crudService",CRUDService.class);
		
		crudService.getEmployee().setName(name);
		crudService.getEmployee().setDob(dob);
		crudService.getEmployee().setSalary(salary);
		
		try {
			validate(crudService.getEmployee());
			crudService.getEmployeesManager().insert(employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void validate(Bean bean) throws Exception {

		if (bean instanceof Employee){
			Employee employee = (Employee) bean;
			if(employee.getName().isEmpty()){
				throw new Exception("name can not be empty");
			}
			if(employee.getDob().isEmpty()){
				throw new Exception("dob can not be empty");
			}
			if(employee.getSalary() <= 100.00){
				throw new Exception("salary can not be less than 100.00");
			}
			
		}else{
			throw new Exception("bean is not an employee type, can't cast it to employe type");
		}
	}

}
