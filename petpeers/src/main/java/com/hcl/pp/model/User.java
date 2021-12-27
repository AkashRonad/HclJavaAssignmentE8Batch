package com.hcl.pp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PET_USER")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "USER_PASSWORD")
	private String userPassword;

	// @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
	// CascadeType.DETACH, CascadeType.REFRESH })
	@OneToMany(mappedBy = "owner", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private Set<Pet> pets;

	public User() {
		super();

	}

	public User(String userName, String userPassword, Set<Pet> pets) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.pets = pets;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
