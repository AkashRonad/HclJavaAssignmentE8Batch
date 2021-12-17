package com.app.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Student implements Serializable {

	private int id;
	private String name;
	private String usn;

	public Student() {
		super();

	}

	public Student(int id, String name, String usn) {
		super();
		this.id = id;
		this.name = name;
		this.usn = usn;
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

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

}
