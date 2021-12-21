package com.app.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Student implements Serializable {

	private int id;
	private String userName;
	private String password;
	private Address address;

	public Student() {
		super();
		
	}

	public Student(int id, String userName, String password, Address address) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
