package com.app.module;

public class Deparment {

	private int departmentId;
	private String departmentName;
	private Employee employee;

	public Deparment() {
		super();

	}

	public Deparment(int departmentId, String departmentName, Employee employee) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employee = employee;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Deparment [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employee="
				+ employee + "]";
	}

}
