package com.hcl.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.app.model.User;
import com.hcl.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	@PostMapping(value = "/saveAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> saveAllUser(@RequestBody List<User> userList) {
		LOGGER.info("SaveAll Method Start With Parameter List Size is" + userList.size());
		List<User> UserResponse = (List<User>) userService.saveAllUserService(userList);
		LOGGER.info("SerivceImpl Class Return the Result With List Size is" + UserResponse.size());

		return UserResponse;
	}

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> create(@RequestBody User user) {
		User userTwo = userService.createUserRecordService(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(userTwo, HttpStatus.CREATED);
		return responseEntity;

	}

	@GetMapping(value = "/findByName/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findByName(@PathVariable String userName) {
		User user = userService.findByNameService(userName);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(user, HttpStatus.FOUND);
		return responseEntity;
	}

	@GetMapping(value = "/findByNameAndPassword/{userName}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findByNameAndPassword(@PathVariable String userName, @PathVariable String password) {
		User user = userService.findByNameAndPasswordService(userName, password);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(user, HttpStatus.FOUND);

		return responseEntity;

	}

	@GetMapping(value = "/findByNameOrPassword/{userName}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findByNameOrPassword(@PathVariable String userName, @PathVariable String password) {
		User user = userService.findByNameOrPasswordService(userName, password);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(user, HttpStatus.FOUND);
		return responseEntity;
	}

	@GetMapping(value = "/getUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUser() {
		List<User> users = userService.findAllService();
		return users;
	}

	@PutMapping(value = "/upadteUserRecord", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> upadteUserRecord(@RequestBody User user) {
		User userTwo = userService.upadteUserRecordService(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(userTwo, HttpStatus.OK);
		return responseEntity;

	}

	@GetMapping(value = "/countUserRecord", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> coustUserRecord() {
		long countUserRecord = userService.countNumberOfUsers();
		ResponseEntity<Long> responseEntity = new ResponseEntity<Long>(new Long(countUserRecord), HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(value = "/deleteUserRecord/{userId}")
	public ResponseEntity<String> deleteUserRecord(@PathVariable int userId) {
		ResponseEntity<String> responseEntity;
		boolean deleteStatus = userService.deleteUserRecordById(userId);
		if (deleteStatus) {
			responseEntity = new ResponseEntity<String>("User Record Is Deleted With Id: " + " " + userId,
					HttpStatus.GONE);

		} else {
			responseEntity = new ResponseEntity<String>("User Record Not Deleted With Id: " + " " + userId,
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;

	}

	@DeleteMapping(value = "/deleteAllUserRecord")
	public ResponseEntity<String> deleteAllUserRecord() {
		ResponseEntity<String> responseEntity;
		boolean deleteStatus = userService.deleteAllUserRecord();
		if (deleteStatus) {
			responseEntity = new ResponseEntity<String>("User Records Is Deleted,", HttpStatus.GONE);

		} else {
			responseEntity = new ResponseEntity<String>("User Records Not Deleted ", HttpStatus.BAD_REQUEST);
		}

		return responseEntity;

	}

}
