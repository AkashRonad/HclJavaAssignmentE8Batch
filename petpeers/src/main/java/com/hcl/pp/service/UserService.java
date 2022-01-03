package com.hcl.pp.service;

import java.util.List;

import com.hcl.exception.AppliactionException;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

public interface UserService {

	public abstract String addUser(User user) throws AppliactionException;

	public abstract User updateUser(User user) throws AppliactionException;

	public abstract List<User> listUsers() throws AppliactionException;

	public abstract User getUserById(long userId) throws AppliactionException;

	public abstract String removeUser(long userId) throws AppliactionException;

	public abstract List<Pet> authenticateUser(String userName, String password) throws AppliactionException;

	public abstract User findByUserName(String username) throws AppliactionException;

	public abstract int buyPet(long userId, long petId) throws AppliactionException;

	public abstract String deleteUser(long userId) throws AppliactionException;

	public abstract List<Pet> getMyPets(long userId) throws AppliactionException;
	
	public abstract String loginApp(String userName, String password) throws AppliactionException;

}
