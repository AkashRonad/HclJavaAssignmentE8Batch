package com.model;

public class Student {

	private int id;
	private String name;
	private String usn;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", usn=" + usn + "]";
	}

}
