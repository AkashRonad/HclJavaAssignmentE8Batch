package com.app.model;

import java.io.Serializable;

public class Employee implements Serializable {

	private int id;
	private String name;
	private float salary;
	private Address address;

	

	public Employee() {
		System.out.println("Employee Class Call");
	}

	public Employee(int id, String name, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Employee(Address address) {
		this.address=address;
	}

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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public void init() {
		System.out.println("Call Api Work");
	}
	
	public void destroy() {
		System.out.println("Destroy Beans");
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
