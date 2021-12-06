package com.hcl.module;

public class Employee {

	private int id;
	private int age;
	private String name;
	private String designation;
	private Long mobileNumber;

	public Employee() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(int id, int age, String name, String designation, Long mobileNumber) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.designation = designation;
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", age=" + age + ", designation=" + designation + ", mobileNumber=" + mobileNumber
				+ "]";
	}

}
