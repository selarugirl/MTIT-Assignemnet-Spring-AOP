package com.mtit.services;

import java.sql.SQLException;

import org.springframework.context.support.AbstractApplicationContext;

import com.mtit.beans.Bean;
import com.mtit.beans.Employee;

public class EmployeeService implements Service {

	public void addEmployee(Bean bean, AbstractApplicationContext context) {

		CRUDService crudService =  context.getBean("crudService",CRUDService.class);
		Employee employee;
		if (bean instanceof Employee) {
			employee = (Employee) bean;
		
			// CRUDService crudService = bean;

			crudService.getEmployee().setName(employee.getName());
			crudService.getEmployee().setDob(employee.getDob());
			crudService.getEmployee().setSalary(employee.getSalary());

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
		} else {
			System.err.println("Bean object type is not employee type");
		}
	}

	public Employee getEmployeeDetails(int id,AbstractApplicationContext context) throws SQLException{
		CRUDService crudService =  context.getBean("crudService",CRUDService.class);
		return crudService.getEmployeesManager().getRow(id);
	}
	public void updateEmployeeSalary(Bean bean,AbstractApplicationContext context) throws SQLException {
		CRUDService crudService =  context.getBean("crudService",CRUDService.class);
		crudService.getEmployeesManager().update(bean);
	}

	public void deleteEmployee(int id,AbstractApplicationContext context) throws SQLException {
		CRUDService crudService =  context.getBean("crudService",CRUDService.class);
		crudService.getEmployeesManager().delete(id);
	}

	public void calculateEPF() {
	}

	@Override
	public void validate(Bean bean) throws Exception {

		if (bean instanceof Employee) {
			Employee employee = (Employee) bean;
			if (employee.getName().isEmpty()) {
				throw new Exception("name can not be empty");
			}
			if (employee.getDob().isEmpty()) {
				throw new Exception("dob can not be empty");
			}
			if (employee.getSalary() <= 100.00) {
				throw new Exception("salary can not be less than 100.00");
			}

		} else {
			throw new Exception("bean is not an employee type, can't cast it to employe type");
		}
	}


}
