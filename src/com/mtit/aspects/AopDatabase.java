package com.mtit.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopDatabase {
	
	@Pointcut("execution(* com.mtit.dataaccess.EmployeesManager.*(..))")
	private void selectAll() {
	}

	@Before("selectAll()")
	public void beforeAdvice() {
		System.out.println("start before advice");
	}

	@After("selectAll()")
	public void afterAdvice() {
		System.out.println("start after advice");
	}

	@AfterReturning(pointcut = "selectAll()", returning = "retVal")
	public void afterReturnAdvice(Object retVal) {
		System.out.println("After sucessfull returning. = " + retVal.toString());
	}

	@AfterThrowing(pointcut = "selectAll()", throwing = "ex")
	public void afterThrowing(IllegalArgumentException ex) {
		System.out.println("Afetr throwing advice " + ex.toString());
	}

}
