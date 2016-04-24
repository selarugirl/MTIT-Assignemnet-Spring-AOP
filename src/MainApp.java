
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
import com.mtit.services.EmployeeService;
//import org.springframework.test.context.ContextConfiguration;

//@ContextConfiguration("/simpleaspect.xml")
public class MainApp {

	public static void main(String args[]) throws SQLException, IOException {

		System.out.println("----------Employee Management System Menu-----------");
		System.out.println("1:Insert New Employee \n "
				+ "2:Update Employee's Salary \n 3:Calculate EPF \n 4:Delete Employee \n 5:Exit \n Enter Option: ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int option = Integer.parseInt(br.readLine());

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Bean employee = (Employee) context.getBean("employeeBean");
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService", EmployeeService.class);

		switch (option) {
		case 1: {
			System.out.println("please enter a name");
			String _name = br.readLine();
			System.out.println("please enter the birthday");
			String _bday = br.readLine();
			System.out.println("please enter the salary");
			double _salary = Double.parseDouble(br.readLine());

			String name = _name;
			String bday = _bday;
			Double salary = _salary;

			// set values for bean

			employeeService.addEmployee(employee);
			break;
		}
		case 2: {
			System.out.println("please enter the salary");
			double _salary = Double.parseDouble(br.readLine());

			employeeService.updateEmployeeSalary(employee);
			break;
		}
		case 3: {
			employeeService.calculateEPF();
			break;
		}
		case 4: {
			System.out.println("please enter employee id");
			int id = Integer.parseInt(br.readLine());

			employeeService.deleteEmployee(id);
		}
		case 5:
			break;
		}

		// AbstractApplicationContext context2 = new
		// ClassPathXmlApplicationContext("config.xml");
		// Bean employee = (Employee) context2.getBean("employeeBean");
		// Students students = (Students) context2.getBean("studentBean");
		// CRUDService crudService = (CRUDService)
		// context2.getBean("crudService");
		//
		// students.getName();
		// System.out.println("------------------------------------------");
		// //EmployeesManager employeesManager = (EmployeesManager)
		// context2.getBean("employeesManager");
		// employee.print();
		// EmployeesManager employeesManager = (EmployeesManager)
		// context2.getBean("employeesManager");
		// employeesManager.insert(employee);
		System.out.println("------------crud service-----------------------");

		// CRUDService crudService =
		// context.getBean("crudService",CRUDService.class);
		// Bean employee = (Employee) context.getBean("employeeBean");
		// EmployeeService employeeSystem =
		// context.getBean("employeeSystem",EmployeeService.class);
		// crudService.getEmployee().getName();
		// employeeSystem.addEmployee(name, bday, salary, context);
		// crudService.getEmployeesManager().insert(employee);

		// get row
		// Employee employee = EmployeeService.getRow(1);

		// Employee employee = EmployeesManager.getRow(1);

		// if(employee == null){
		// System.err.println("no rows were found");
		// }else{
		// System.out.println("name "+ employee.getName());
		// System.out.println("salary "+employee.getSalara());
		// }

		// insert row
		// Employee employee = new Employee();

		//
		// // insert row
		//// Employee employee = new Employee();
		// employee.setName("lakna");
		// employee.setDob("12-12-2015");
		// employee.setSalara(30000);
		//
		// boolean result = EmployeeService.insert(employee);
		// if(result){
		// System.out.println("New row with primary key : "+employee.getId());
		// }

		// update row
		// Employee employee = new Employee();
		// employee.setName("lakna ariyathilaka");
		// boolean result = EmployeeService.update(employee);
		// if(result){
		// System.out.println("updated");
		// }else{
		// System.err.println("not updated");
		// }

		// delete
		// EmployeesManager.delete(2);

	}

}
