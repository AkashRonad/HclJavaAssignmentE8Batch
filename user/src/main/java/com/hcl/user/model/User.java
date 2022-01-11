package com.hcl.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import lombok.Data;

@Data
@Entity
@Table(name = "PET_USER")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "USER_NAME")
	@NotNull
	@NotEmpty(message = "User Name Is Required")
	private String userName;

	@Column(name = "USER_PASSWORD")
	@NotNull
	@NotEmpty(message = "User Password Is Required")
	private String userPassword;

	@Transient
	private String userConfirmPassword;

}
