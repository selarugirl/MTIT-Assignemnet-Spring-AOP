

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mtit.aop.lab.Students;
import com.mtit.beans.Employee;
import com.mtit.dataaccess.DBUtil;
import com.mtit.dataaccess.DatabaseType;
import com.mtit.services.EmployeeService;

public class MainApp {
	
//	private static final String USERNAME = "root";
//	private static final String PASSWORD = "";
//	private static final String DB_NAME = "mtitdb";
//	private static final String CONN_STRING = "jdbc:mysql://localhost/"+DB_NAME;
	
	public static void main (String args[]) throws SQLException{
		
//		AbstractApplicationContext context2 = new ClassPathXmlApplicationContext("config.xml");
//		Students students = (Students) context2.getBean("studentsBean");
//		students.getName();
//		students.getAge();
		
		// get row
		Employee employee = EmployeeService.getRow(1);
		if(employee == null){
			System.err.println("no rows were found");
		}else{
			System.out.println("name "+ employee.getName());
			System.out.println("salary "+employee.getSalara());
		}
		
		// insert row
//		Employee employee = new Employee();
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
		employee.setName("lakna ariyathilaka");
		boolean result = EmployeeService.update(employee);
		if(result){
			System.out.println("updated");
		}else{
			System.err.println("not updated");
		}
		
	}

}
