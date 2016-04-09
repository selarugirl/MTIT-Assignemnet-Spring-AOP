package com.mtit.aop.lab;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopLogging {

	/**
	 * Following is the definition for a pointcut to select all the methods
	 * available. So advice will be called for all the methods.
	 */
	@Pointcut("execution(* com.mtit.aop.lab.*.*(..))")
	private void selectAll() {
		System.out.println("selectAll()");
	}

	/**
	 * This is the method which I would like to execute before a selected method
	 * execution.
	 */
	@Before("selectAll()")
	public void beforeAdvice() {
		System.out.println("start before advice");
	}

	/**
	 * This is the method which I would like to execute after a selected method
	 * execution.
	 */
	@After("selectAll()")
	public void afterAdvice() {
		System.out.println("start after advice");
	}

	/**
	 * This is the method which I would like to execute wh en any method
	 * returns.
	 */
	@AfterReturning(pointcut = "selectAll()", returning = "retVal")
	public void afterReturnAdvice(Object retVal) {
		System.out.println("After sucessfull returning. = " + retVal.toString());
	}

	/**
	 * This is the method which I would like to execute if there is an exception
	 * raised by any method.
	 */
	@AfterThrowing(pointcut = "selectAll()", throwing = "ex")
	public void afterThrowing(IllegalArgumentException ex) {
		System.out.println("Afetr throwing advice " + ex.toString());
	}

}
