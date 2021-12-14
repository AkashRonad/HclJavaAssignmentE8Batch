package com.app.model;

import java.io.Serializable;

public class Address implements Serializable {

	private int pincode;
	private String street;
	private String houseNumber;
	private String city;

	public Address() {
		System.out.println("Address Class Call");
	}

	public Address(int pincode, String street, String houseNumber, String city) {
		super();
		this.pincode = pincode;
		this.street = street;
		this.houseNumber = houseNumber;
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
