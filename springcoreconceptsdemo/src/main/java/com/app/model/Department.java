package com.app.model;

import java.io.Serializable;
import java.util.List;

public class Department implements Serializable {

	private int id;
	private String dname;
	private List<Employee> employees;

	public Department() {
		super();

	}

	public Department(int id, String dname) {
		super();
		this.id = id;
		this.dname = dname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
