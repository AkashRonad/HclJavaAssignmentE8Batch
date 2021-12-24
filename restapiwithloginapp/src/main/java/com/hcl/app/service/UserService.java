package com.hcl.app.service;

import java.util.List;

import com.hcl.app.model.User;

public interface UserService {

	
	public abstract User createUserRecordService(User user);

	public abstract List<User> saveAllUserService(List<User> userList);

	public abstract User findByNameService(String userName);

	public abstract User findByNameAndPasswordService(String userName, String password);

	public abstract User findByNameOrPasswordService(String userName, String password);

	public abstract List<User> findAllService();

	public abstract User findOneService(int id);

	public abstract User upadteUserRecordService(User user);

	public abstract long countNumberOfUsers();

	public abstract boolean deleteUserRecordById(int id);

	public abstract boolean deleteAllUserRecord();

}
