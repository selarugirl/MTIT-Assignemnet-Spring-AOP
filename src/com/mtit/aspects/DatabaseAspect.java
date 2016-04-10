package com.mtit.aspects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.mtit.dataaccess.DBUtil;
import com.mtit.dataaccess.DatabaseType;


@Aspect
public class DatabaseAspect {
	
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	@Pointcut("execution(* com.mtit.dataaccess.Database.*(..))")
	private void selectAll() {
		System.err.println("is this work----------->>>>>>>>");
	}

	@Before("selectAll()")
	public void beforeAdvice() throws SQLException {
		connection = DBUtil.getConnection(DatabaseType.MSSQL);
		System.out.println("Database connection established");
		
		
	}


	@After("selectAll()")
	public void afterAdvice() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
		System.out.println("all the open connections are closed");
	}

/*	@AfterReturning(pointcut = "selectAll()", returning = "retVal")
	public void afterReturnAdvice(Object retVal) {
		System.out.println("After sucessfull returning. = " + retVal.toString());
	}*/

	@AfterThrowing(pointcut = "selectAll()", throwing = "ex")
	public void afterThrowing(IllegalArgumentException ex) {
		System.out.println("Afetr throwing advice " + ex.toString());
	}

}
