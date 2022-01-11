package com.hcl.consumer.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class User implements Serializable {

	private long id;

	@NotNull
	@NotEmpty(message = "UserName Feild Is Required")
	private String userName;

	@NotNull
	@NotEmpty(message = "UserPassword Feild Is Required")
	private String userPassword;

	@NotNull
	@NotEmpty(message = "UserConfirmPassword Feild Is Required")
	private String userConfirmPassword;

	//private List<Pet> pets;

}
