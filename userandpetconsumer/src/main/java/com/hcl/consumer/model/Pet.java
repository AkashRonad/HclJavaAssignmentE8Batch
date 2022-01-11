package com.hcl.consumer.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Pet {

	private long id;

	@NotNull
	@NotEmpty(message = "Pet Name Is Required")
	private String name;

	@Min(1)
	private int age;

	@NotNull
	@NotEmpty(message = "Pet Place Is Required")
	private String place;

	private int petOwnerId;

	//private User user;

}
