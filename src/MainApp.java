

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;

import com.mtit.aop.lab.Students;
import com.mtit.beans.Bean;
import com.mtit.beans.Employee;
import com.mtit.dataaccess.DBUtil;
import com.mtit.dataaccess.DatabaseType;
import com.mtit.dataaccess.EmployeesManager;
import com.mtit.services.CRUDService;
import com.mtit.services.EmployeeSystem;
//import org.springframework.test.context.ContextConfiguration;

//@ContextConfiguration("/simpleaspect.xml")
public class MainApp {
	
	
	public static void main (String args[]) throws SQLException, IOException{
		
		System.out.println("Employee Management System");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("please enter a name");
		String _name = br.readLine();
		System.out.println("please enter the birthday");
		String _bday = br.readLine();
		System.out.println("please enter the salary");
		double _salary = Double.parseDouble(br.readLine());
		
		String name = _name;
		String bday = _bday;
		Double salary = _salary;
		
		
		
//		AbstractApplicationContext context2 = new ClassPathXmlApplicationContext("config.xml");
//		Bean employee = (Employee) context2.getBean("employeeBean");
//		Students students = (Students) context2.getBean("studentBean");
//		CRUDService crudService = (CRUDService) context2.getBean("crudService");
//		
//		students.getName();
//		System.out.println("------------------------------------------");
//		//EmployeesManager employeesManager = (EmployeesManager) context2.getBean("employeesManager");
//		employee.print();
//		EmployeesManager employeesManager = (EmployeesManager) context2.getBean("employeesManager");
//		employeesManager.insert(employee);
		System.out.println("------------crud service-----------------------");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		//CRUDService crudService = context.getBean("crudService",CRUDService.class);
		//Bean employee = (Employee) context.getBean("employeeBean");
		EmployeeSystem employeeSystem = context.getBean("employeeSystem",EmployeeSystem.class);
//		crudService.getEmployee().getName();
		employeeSystem.addEmployee(name, bday, salary, context);
		//crudService.getEmployeesManager().insert(employee);
		

		
		
		// get row
//		Employee employee = EmployeeService.getRow(1);

//		Employee employee = EmployeesManager.getRow(1);

//		if(employee == null){
//			System.err.println("no rows were found");
//		}else{
//			System.out.println("name "+ employee.getName());
//			System.out.println("salary "+employee.getSalara());
//		}

		
		// insert row
//		Employee employee = new Employee();

//		
//		// insert row
////		Employee employee = new Employee();
//		employee.setName("lakna");
//		employee.setDob("12-12-2015");
//		employee.setSalara(30000);
//		
//		boolean result = EmployeeService.insert(employee);
//		if(result){
//			System.out.println("New row with primary key : "+employee.getId());
//		}
		
		//update row
//		Employee employee = new Employee();
//		employee.setName("lakna ariyathilaka");
//		boolean result = EmployeeService.update(employee);
//		if(result){
//			System.out.println("updated");
//		}else{
//			System.err.println("not updated");
//		}

		
		//delete
//		EmployeesManager.delete(2);


	}

}
