package com.app.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TWO_WHEELER")
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
	
	@Column(name="STEERING_TYPE")
	private String steeringTWOWheeler;

	public String getSteeringTWOWheeler() {
		return steeringTWOWheeler;
	}

	public void setSteeringTWOWheeler(String steeringTWOWheeler) {
		this.steeringTWOWheeler = steeringTWOWheeler;
	}
	
	

}
