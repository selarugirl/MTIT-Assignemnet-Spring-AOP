
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.openmbean.OpenDataException;

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
import com.mtit.services.EmployeeService;
//import org.springframework.test.context.ContextConfiguration;

//@ContextConfiguration("/simpleaspect.xml")
public class MainApp {

	public static String name;
	public static String bday;
	public static Double salary;

	public static void main(String args[]) throws SQLException, IOException {

		System.out.println("----------Application STARTED-----------");
		System.out.println("----------Employee Management System Menu-----------");

		System.out.println("1:Insert New Employee");
		System.out.println("2:Update Employee's Salary");
		System.out.println("3:Calculate EPF");
		System.out.println("4:Delete Employee");
		System.out.println("5:Exit");
		System.out.println("Enter Option: ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int option = Integer.parseInt(br.readLine());

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Bean empBean = (Employee) context.getBean("employeeBean");
		Employee employee;
		if (empBean instanceof Employee) {
			employee = (Employee) empBean;

			EmployeeService employeeService = (EmployeeService) context.getBean("employeeService",
					EmployeeService.class);


			switch (option) {
			case 1: {
				menu(br);
				addEmployee(context, employee, employeeService);
				break;
			}
			case 2: {
				updateEmployee(br, context, employeeService);
				break;
			}
			case 3: {
				employeeService.calculateEPF();
				break;
			}
			case 4: {
				deleteEmployee(br, context, employeeService);
				break;
			}
			case 5:
				break;
			}

		}

		System.out.println("------------Application ENDED-----------------------");

	}

	private static void deleteEmployee(BufferedReader br, AbstractApplicationContext context,
			EmployeeService employeeService) throws IOException, SQLException {
		System.out.println("please enter employee id");
		int id = Integer.parseInt(br.readLine());

		employeeService.deleteEmployee(id,context);
	}

	private static void updateEmployee(BufferedReader br, AbstractApplicationContext context,
			EmployeeService employeeService) throws IOException, SQLException {
		Employee employee;
		System.out.println("please enter the fields to update");
		System.out.println("please enter the employee ID");
		int id = Integer.parseInt(br.readLine());
		employee = employeeService.getEmployeeDetails(id,context);
		System.out.println("Current Employee Details");
		System.out.println(employee.toString());
		menu(br);
		if(!MainApp.name.isEmpty())
			employee.setName(MainApp.name);
		if(!MainApp.bday.isEmpty())
			employee.setDob(MainApp.bday);
		if(MainApp.salary != null)
			employee.setSalary(MainApp.salary);
		
		employeeService.updateEmployeeSalary(employee,context);
	}

	private static void addEmployee(AbstractApplicationContext context, Employee employee,
			EmployeeService employeeService) {
		employee.setName(MainApp.name);
		employee.setDob(MainApp.bday);
		employee.setSalary(MainApp.salary);

		employeeService.addEmployee(employee, context);
	}

	private static void menu(BufferedReader br) throws IOException {
		System.out.println("please enter a name");
		MainApp.name = br.readLine();
		System.out.println("please enter the birthday");
		MainApp.bday = br.readLine();
		System.out.println("please enter the salary");
		MainApp.salary = Double.parseDouble(br.readLine());
	}

}
