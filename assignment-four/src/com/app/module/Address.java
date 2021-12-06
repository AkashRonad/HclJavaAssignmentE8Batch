package com.app.module;

public class Address {

	private String StreeName;
	private String houseNo;
	private String dist;
	private String state;
	private int pincode;

	public Address() {
		super();

	}

	public Address(String streeName, String houseNo, String dist, String state, int pincode) {
		super();
		StreeName = streeName;
		this.houseNo = houseNo;
		this.dist = dist;
		this.state = state;
		this.pincode = pincode;
	}

	public String getStreeName() {
		return StreeName;
	}

	public void setStreeName(String streeName) {
		StreeName = streeName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [StreeName=" + StreeName + ", houseNo=" + houseNo + ", dist=" + dist + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}

}
