package com.mtit.beans;

import java.io.Serializable;

public class Employee implements Bean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2904610859091606360L;
	private int id;
	private String name;
	private String dob;
	private double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		System.out.println("name : "+this.name);
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salara) {
		this.salary = salara;
	}
	@Override
	public void print(){
		System.out.println("nane : "+this.name+" saralay : "+this.salary);
	}
	
}
