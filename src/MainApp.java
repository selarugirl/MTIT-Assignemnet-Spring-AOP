

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
//import org.springframework.test.context.ContextConfiguration;

//@ContextConfiguration("/simpleaspect.xml")
public class MainApp {
	
	
	public static void main (String args[]) throws SQLException{
		
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
		CRUDService crudService = context.getBean("crudService",CRUDService.class);
		Bean employee = (Employee) context.getBean("employeeBean");
//		crudService.getEmployee().getName();
		
		crudService.getEmployeesManager().insert(employee);
		
		
	}

}
