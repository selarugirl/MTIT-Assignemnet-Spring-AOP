package com.mtit.aspects;

import java.sql.SQLException;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class ServiceAspect {
	
	@Pointcut("execution(* com.mtit.services.EmployeeService.addEmployee(..))")
	private void serviceAddEmployee() {
		System.err.println("is this work----------->>>>>>>>");
	}
	
	@Before("serviceAddEmployee()")
	public void serviceAddEmployeeBeforeAdvice(){
		System.out.println("Before Executing addEmployee() in Employee Service Class");
	}
	
	@After("serviceAddEmployee()")
	public void serviceAddEmployeeAfterAdvice(){
		System.out.println("After Executing addEmployee() in Employee Service Class");
	}

	@AfterThrowing(pointcut = "serviceAddEmployee()", throwing = "ex")
	public void serviceAddEmployeeAfterThrowing(SQLException ex) {
		System.out.println("Afetr throwing advice " + ex.toString());
	}

	
	//Point cut for update employee
	@Pointcut("execution(* com.mtit.services.EmployeeService.updateEmployee(..))")
	private void serviceUpdateEmployee() {
		System.err.println("is this work----------->>>>>>>>");
	}
	
	@Before("serviceUpdateEmployee()")
	public void serviceUpdateEmployeeBeforeAdvice(){
		System.out.println("Before Executing updateEmployee() in Employee Service Class");
	}
	
	@After("serviceUpdateEmployee()")
	public void serviceUpdateEmployeeAfterAdvice(){
		System.out.println("After Executing updateEmployee() in Employee Service Class");
	}

	@AfterThrowing(pointcut = "serviceUpdateEmployee()", throwing = "ex")
	public void serviceUpdateEmployeeAfterThrowing(SQLException ex) {
		System.out.println("Afetr throwing advice " + ex.toString());
	}
	
	//Point cut for calculate epf
		@Pointcut("execution(* com.mtit.services.EmployeeService.calculateEPF(..))")
		private void serviceCalculateEpf() {
			System.err.println("is this work----------->>>>>>>>");
		}
		
		@Before("serviceCalculateEpf()")
		public void serviceCalculateEpfBeforeAdvice(){
			System.out.println("Before Executing CalculateEpf() in Employee Service Class");
		}
		
		@After("serviceCalculateEpf()")
		public void serviceCalculateEpfAfterAdvice(){
			System.out.println("After Executing CalculateEpf() in Employee Service Class");
		}

		@AfterThrowing(pointcut = "serviceCalculateEpf()", throwing = "ex")
		public void serviceCalculateEpfAfterThrowing(SQLException ex) {
			System.out.println("Afetr throwing advice " + ex.toString());
		}
		
		
		//Point cut for calculate epf
				@Pointcut("execution(* com.mtit.services.EmployeeService.deleteEmployee(..))")
				private void serviceDeleteEmployee() {
					System.err.println("is this work----------->>>>>>>>");
				}
				
				@Before("serviceDeleteEmployee()")
				public void serviceDeleteEmployeeBeforeAdvice(){
					System.out.println("Before Executing deleteEmployee() in Employee Service Class");
				}
				
				@After("serviceDeleteEmployee()")
				public void serviceDeleteEmployeeAfterAdvice(){
					System.out.println("After Executing deleteEmployee() in Employee Service Class");
				}

				@AfterThrowing(pointcut = "serviceDeleteEmployee()", throwing = "ex")
				public void serviceDeleteEmployeeAfterThrowing(SQLException ex) {
					System.out.println("Afetr throwing advice " + ex.toString());
				}
}
