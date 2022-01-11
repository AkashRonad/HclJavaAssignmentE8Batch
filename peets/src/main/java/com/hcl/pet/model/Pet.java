package com.hcl.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PETS")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "PET_NAME")
	private String name;

	@Column(name = "PET_AGE")
	private int age;

	@Column(name = "PET_PLACE")
	private String place;

	@Column(name = "PET_OWNERID")
	private int petOwnerId;

}
