

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mtit.aop.lab.Students;

public class MainApp {
	
	public static void main (String args[]){
		
		AbstractApplicationContext context2 = new ClassPathXmlApplicationContext("config.xml");
		Students students = (Students) context2.getBean("studentsBean");
		students.getName();
		students.getAge();
	}

}
