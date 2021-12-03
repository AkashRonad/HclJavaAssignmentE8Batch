package com.app.module;

public class Employee {

	private int employeeUserId;
	private String employeeName;
	private String employeePassword;

	public Employee() {
		super();

	}

	public Employee(int employeeUserId, String employeeName, String employeePassword) {
		super();
		this.employeeUserId = employeeUserId;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
	}

	public int getEmployeeUserId() {
		return employeeUserId;
	}

	public void setEmployeeUserId(int employeeUserId) {
		this.employeeUserId = employeeUserId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

}
