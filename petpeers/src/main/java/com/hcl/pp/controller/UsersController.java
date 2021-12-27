package com.hcl.pp.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;
import com.hcl.pp.service.UserService;

@RestController
public class UsersController {

	private static final Logger LOGGER = LogManager.getLogger(UsersController.class);

	@Autowired
	UserService userService;

	@PostMapping(value = "/user/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addUser(@RequestBody User user) {
		LOGGER.info(" Client Send The Requset" + " " + "URL" + "/user/add" + "addUserMethod Start");
		String addStatus = userService.addUser(user);
		LOGGER.info("UserServiceInterface addUser Method Return Result Is" + addStatus);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(addStatus, HttpStatus.CREATED);
		LOGGER.info("UsersController addUser Method End");
		return responseEntity;

	}

	@GetMapping(value = "/user/login/{userName}/{userPassword}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> loginUser(@PathVariable String userName, @PathVariable String userPassword) {
		LOGGER.info(" Client Send The Requset" + " " + "URL" + "/user/login/" + userName + "/" + userPassword
				+ "loginUser Start");
		List<Pet> pets = null;
		List<Object> errorMessageObject = null;
		pets = userService.authenticateUser(userName, userPassword);
		LOGGER.info("UserServiceInterface loginUser Method Return Result");
		if (pets != null) {
			LOGGER.info("UserServiceInterface loginUser Method Return Result List<Pet> Not Null Its Contains Data");
			List<Object> petObjects = new ArrayList<Object>();
			petObjects.addAll(pets);
			return petObjects;
		} else {
			errorMessageObject = new ArrayList<Object>();
			errorMessageObject.add("Login Failed Check Your User Name And Password");
			LOGGER.info("Login Failed Check Your User Name And Password");

		}

		LOGGER.info("UsersController loginUser Method End");

		return errorMessageObject;

	}

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> listUsers() {
		LOGGER.info("Client Send The Requset" + " " + "URL" + "/users" + "listUsers Method Start");
		List<User> users = null;
		List<Object> errorMessageObject = null;
		users = userService.listUsers();
		LOGGER.info("UserServiceInterface listUsers Method Return Result");
		if (users != null) {
			LOGGER.info("UserServiceInterface listUsers Method Return Result List<User>  List Contains Data");
			List<Object> userObject = new ArrayList<Object>();
			userObject.addAll(users);
			return userObject;
		} else {
			errorMessageObject = new ArrayList<Object>();
			errorMessageObject.add("Cureently User Table Is Empty");
			LOGGER.info("Login Failed Check Your User Name And Password");

		}

		LOGGER.info("UsersController listUsers Method End");

		return errorMessageObject;
	}

	@DeleteMapping(value = "/delete/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteUser(@PathVariable long userId) {
		LOGGER.info("Client Send The Requset" + " " + "URL" + "/delete/" + userId + "deleteUser Method Start");
		String deleteStatus = userService.deleteUser(userId);
		LOGGER.info("UserServiceInterface deleteUser Method Return Result");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(deleteStatus, HttpStatus.GONE);
		LOGGER.info("UsersController deleteUser Method End");
		return responseEntity;

	}

	@GetMapping(value = "/pets/myPets/{userId}")
	public List<Object> myPets(@PathVariable long userId) {
		LOGGER.info("Client Send The Requset" + " " + "URL" + "/pets/myPets/" + userId + "myPets Method Start");
		List<Pet> pets = null;
		List<Object> errorMessageObject = null;
		pets = userService.getMyPets(userId);
		LOGGER.info("UserServiceInterface myPets Method Return Result");
		if (pets != null && pets.size() > 0) {
			LOGGER.info("UserServiceInterface myPets Method Return Result List<Pets> List Contains Data");
			List<Object> petsObjects = new ArrayList<Object>();
			petsObjects.addAll(pets);
			return petsObjects;

		} else {
			errorMessageObject = new ArrayList<Object>();
			errorMessageObject.add("No pets Avalible in DB for this user id");
			LOGGER.info("No pets Avalible in DB for this user id");

		}
		LOGGER.info("UsersController myPets Method End");
		return errorMessageObject;

	}

	@GetMapping(value = "/pets/buyPet/{userId}/{petId}")
	public ResponseEntity<Object> buyPet(@PathVariable long userId, @PathVariable long petId) {
		LOGGER.info("Client Send The Requset" + " " + "URL" + "/pets/buyPet/" + userId + "/ " + petId
				+ "buyPet Method Start");
		ResponseEntity<Object> responseEntity = null;
		int numberOfRowAffected = userService.buyPet(userId, petId);
		LOGGER.info("UserServiceInterface buyPet Method Return Result");
		if (numberOfRowAffected > 0) {
			LOGGER.info("UserServiceInterface buyPet Method Return Result integer Data");
			return responseEntity = new ResponseEntity<Object>("Add the New pet to the user", HttpStatus.FOUND);

		} else {
			responseEntity = new ResponseEntity<Object>(
					"Check Your User Id And Pet Id One Of This Record Not Present In DB", HttpStatus.BAD_REQUEST);
			LOGGER.info("Check Your User Id And Pet Id One Of This Record Not Present In DB");
		}

		LOGGER.info("UsersController buyPet Method End");
		return responseEntity;

	}

}
