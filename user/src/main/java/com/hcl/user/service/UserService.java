package com.hcl.user.service;

import java.util.List;

import com.hcl.user.customerror.ApplicationException;
import com.hcl.user.model.User;

public interface UserService {
	public abstract String addUser(User user) throws ApplicationException;

	public abstract User updateUser(User user) throws ApplicationException;

	public abstract List<User> listUsers() throws ApplicationException;

	public abstract User getUserById(long userId) throws ApplicationException;

	public abstract String removeUser(long userId) throws ApplicationException;

	public abstract String loginApp(String userName, String password) throws ApplicationException;

	public abstract User findByUserName(String username) throws ApplicationException;

	public abstract String buyPet(long userId, long petId) throws ApplicationException;

	public abstract String deleteUser(long userId) throws ApplicationException;

}
