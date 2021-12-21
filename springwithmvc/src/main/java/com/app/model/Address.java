package com.app.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Address implements Serializable {

	private String city;
	private String pincode;
	private String area;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String city, String pincode, String area) {
		super();
		this.city = city;
		this.pincode = pincode;
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
