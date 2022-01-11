package com.hcl.user.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.user.customerror.ApplicationException;
import com.hcl.user.model.User;
import com.hcl.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/usercon")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/user/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addUser(@Valid @RequestBody User user) throws ApplicationException {
		String addStatus = null;
		ResponseEntity<String> responseEntity = null;
		log.info(" Client Send The Requset" + " " + "URL" + "/user/add" + "addUserMethod Start");
		addStatus = userService.addUser(user);
		if (addStatus != null) {
			log.info("UserServiceInterface addUser Method Return Result Is" + addStatus);
			responseEntity = new ResponseEntity<String>(addStatus, HttpStatus.CREATED);
		} else {
			throw new ApplicationException("User Details Failed To Stored");
		}

		log.info("UsersController addUser Method End");
		return responseEntity;

	}

	@GetMapping(value = "/user/loginapp/{userName}/{userPassword}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> loginApp(@PathVariable String userName, @PathVariable String userPassword)
			throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/user/loginapp" + "loginApp Start");
		String loginStatus = null;
		ResponseEntity<String> responseEntity = null;
		loginStatus = userService.loginApp(userName, userPassword);
		if (loginStatus != null) {
			log.info("UserServiceInterface loginApp Method Return Result Is\" + loginApp");
			responseEntity = new ResponseEntity<String>(loginStatus, HttpStatus.OK);

		} else {
			loginStatus = "Login Failed Check Your User Name And Password";
			log.info("Login Failed Check Your User Name And Password");
			throw new ApplicationException(loginStatus);
		}
		log.info("UsersController loginApp Method End");
		return responseEntity;

	}

	@DeleteMapping(value = "/delete/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteUser(@PathVariable long userId) throws ApplicationException {
		log.info("Client Send The Requset" + " " + "URL" + "/delete/" + userId + "deleteUser Method Start");
		String deleteStatus = userService.deleteUser(userId);
		log.info("UserServiceInterface deleteUser Method Return Result");
		ResponseEntity<String> responseEntity = null;
		if (deleteStatus != null) {
			responseEntity = new ResponseEntity<String>(deleteStatus, HttpStatus.OK);

		} else {
			throw new ApplicationException("User Record Not Deleted");

		}

		log.info("UsersController deleteUser Method End");
		return responseEntity;

	}

	@PutMapping(value = "/upadteUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) throws ApplicationException {

		log.info(" Client Send The Requset" + " " + "URL" + "/upadteUser" + "updateUser Start");
		User userOne = null;
		ResponseEntity<User> responseEntity = null;
		userOne = userService.updateUser(user);
		log.info("UserServiceInterface updatePetDetails Method Return Result");
		if (userOne != null) {
			responseEntity = new ResponseEntity<User>(userOne, HttpStatus.OK);
		} else {
			log.info("Upadate Failed Check User Object Details");
			throw new ApplicationException("Upadate Failed Check User Object Details");

		}
		log.info("UserController updateUser Method End");
		return responseEntity;

	}

	@GetMapping(value = "/findByUserName/{userName}")
	public ResponseEntity<User> findByUserName(@PathVariable String userName) throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/findByUserName" + "findByUserName Start");
		ResponseEntity<User> responseEntity = null;
		User user = null;
		user = userService.findByUserName(userName);
		log.info("UserServiceInterface updatePetDetails Method Return Result");
		if (user != null) {
			responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			throw new ApplicationException("Data Not Found this UserName");
		}

		log.info("UserController findByUserName Method End");

		return responseEntity;

	}

	@GetMapping(value = "/getUsers")
	public ResponseEntity<List<User>> listUsers() throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/getUsers" + "listUsers Start");
		ResponseEntity<List<User>> responseEntity = null;
		List<User> users = null;
		users = userService.listUsers();
		if (users.size() > 0) {
			responseEntity = new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} else {
			throw new ApplicationException("No Data Present In User Table");
		}

		return responseEntity;

	}

	@GetMapping(value = "/pets/buyPet/{userId}/{petId}")
	public ResponseEntity<String> buyPet(@PathVariable long userId, @PathVariable long petId)
			throws ApplicationException {
		log.info("Client Send The Requset" + " " + "URL" + "/pets/buyPet/" + userId + "/ " + petId
				+ "buyPet Method Start");
		ResponseEntity<String> responseEntity = null;
		String statusOfBuyPet = userService.buyPet(userId, petId);
		log.info("UserServiceInterface buyPet Method Return Result");
		if (statusOfBuyPet != null) {
			log.info("UserServiceInterface buyPet Method Return Result integer Data");
			responseEntity = new ResponseEntity<String>(statusOfBuyPet, HttpStatus.OK);
		}

		log.info("UsersController buyPet Method End");
		return responseEntity;

	}

}
