package com.hcl.pp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "PETS")
public class Pet implements Serializable {

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

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "PET_OWNERID")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private User owner;

	public Pet() {
		super();

	}

	public Pet(String name, int age, String place) {
		super();
		this.name = name;
		this.age = age;
		this.place = place;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
