package com.hcl.app.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.app.dao.UserRepository;
import com.hcl.app.model.User;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUserRecordService(User user) {
		LOGGER.info("Method Start with Create");

		if (user != null && user.getUserName() != null && user.getPassword() != null) {
			String passwordEncoded = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
			user.setPassword(passwordEncoded);
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> saveAllUserService(List<User> userList) {
		List<User> users = new ArrayList<User>();

		if (userList.size() > 0) {
			for (User user : userList) {
				String passwordEncoded = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
				user.setPassword(passwordEncoded);
				users.add(user);
			}

			Iterable<User> usersList = userRepository.saveAll(users);
			boolean data = users.removeAll(users);
			if (data) {
				for (User user : usersList) {
					users.add(user);
				}

			}

		}

		return users;
	}

	@Override
	public User findByNameService(String userName) {
		User user = null;
		if (userName != null) {
			user = userRepository.findByName(userName);
			byte[] actualBytePassword = Base64.getDecoder().decode(user.getPassword());
			String actualPassword = new String(actualBytePassword);
			user.setPassword(actualPassword);

		}
		return user;
	}

	@Override
	public User findByNameAndPasswordService(String userName, String password) {
		User user = null;
		if (userName != null && password != null) {
			String passwordEncoded = Base64.getEncoder().encodeToString(password.getBytes());
			user = userRepository.findByNameAndPassword(userName, passwordEncoded);
			byte[] actualBytePassword = Base64.getDecoder().decode(user.getPassword());
			String actualPassword = new String(actualBytePassword);
			user.setPassword(actualPassword);

		}
		return user;
	}

	@Override
	public User findByNameOrPasswordService(String userName, String password) {
		User user = null;
		if (userName != null || password != null) {
			String passwordEncoded = Base64.getEncoder().encodeToString(password.getBytes());
			user = userRepository.findByNameAndPassword(userName, passwordEncoded);
			byte[] actualBytePassword = Base64.getDecoder().decode(user.getPassword());
			String actualPassword = new String(actualBytePassword);
			user.setPassword(actualPassword);

		}
		return user;
	}

	@Override
	public List<User> findAllService() {
		return userRepository.findAll();
	}

	@Override
	public User findOneService(int id) {
		User user = null;
		if (id > 0) {
			Optional<User> userOptional = userRepository.findById(id);
			if (userOptional.isPresent()) {
				user = userOptional.get();
				byte[] actualBytePassword = Base64.getDecoder().decode(user.getPassword());
				String actualPassword = new String(actualBytePassword);
				user.setPassword(actualPassword);
			}

		}

		return user;
	}

	@Override
	public User upadteUserRecordService(User user) {
		User userTwo = null;
		if (user != null && user.getUserId() > 0 && user.getUserName() != null && user.getPassword() != null) {
			Optional<User> userOptional = userRepository.findById(user.getUserId());
			if (userOptional.isPresent()) {
				User userThree = userOptional.get();
				String passwordEncoded = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
				userThree.setUserName(user.getUserName());
				userThree.setPassword(passwordEncoded);
				userTwo = userRepository.save(userThree);
				byte[] actualBytePassword = Base64.getDecoder().decode(userTwo.getPassword());
				String actualPassword = new String(actualBytePassword);
				userTwo.setPassword(actualPassword);

			}

		}
		return userTwo;
	}

	@Override
	public long countNumberOfUsers() {
		return userRepository.count();
	}

	@Override
	public boolean deleteUserRecordById(int id) {
		boolean data = false;
		if (id > 0) {
			Optional<User> userOptional = userRepository.findById(id);
			if (userOptional.isPresent()) {
				userRepository.deleteById(id);
				data = true;

			}

		}
		return data;
	}

	@Override
	public boolean deleteAllUserRecord() {
		userRepository.deleteAll();
		return true;
	}

}
