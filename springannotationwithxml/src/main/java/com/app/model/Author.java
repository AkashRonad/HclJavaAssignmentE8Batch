package com.app.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Author implements Serializable {

	@Value("Team")
	private String name;
	@Value("Gadag")
	private String address;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
