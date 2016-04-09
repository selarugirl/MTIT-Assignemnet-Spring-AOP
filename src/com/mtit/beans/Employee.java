package com.mtit.beans;

import java.io.Serializable;

public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2904610859091606360L;
	private int id;
	private String name;
	private String dob;
	private double salara;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
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
	public double getSalara() {
		return salara;
	}
	public void setSalara(double salara) {
		this.salara = salara;
	}
	
}