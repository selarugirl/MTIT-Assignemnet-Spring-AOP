

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
//import org.springframework.test.context.ContextConfiguration;

//@ContextConfiguration("/simpleaspect.xml")
public class MainApp {
	
	
	public static void main (String args[]) throws SQLException{
		
		AbstractApplicationContext context2 = new ClassPathXmlApplicationContext("config.xml");
		Bean employee = (Employee) context2.getBean("employeeBean");
		Students students = (Students) context2.getBean("studentBean");
		students.getName();
		System.out.println("------------------------------------------");
		//EmployeesManager employeesManager = (EmployeesManager) context2.getBean("employeesManager");
		employee.print();
		EmployeesManager employeesManager = (EmployeesManager) context2.getBean("employeesManager");
		employeesManager.insert(employee);
		
		
	}

}
