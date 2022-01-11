package com.hcl.consumer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.hcl.consumer.customerror.ApplicationException;
import com.hcl.consumer.model.Pet;
import com.hcl.consumer.model.User;
import com.hcl.consumer.service.UserAndPetConsumerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "consumer")
public class ConsumerController {

	@Autowired
	private UserAndPetConsumerService userAndPetConsumerService;

	@PostMapping(value = "/user/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addUser(@Valid @RequestBody User user) throws ApplicationException {
		ResponseEntity<String> responseEntity = null;
		log.info(" Client Send The Requset" + " " + "URL" + "/user/add" + "addUserMethod Start");
		if (user != null) {
			responseEntity = userAndPetConsumerService.addUser(user);
			log.info("UserAndPetConsumerService Class addUser Method Return Result");
		} else {
			throw new ApplicationException("User Detials Required For Perform the Add Operation");
		}

		log.info("ConsumerController addUser Method End");
		return responseEntity;

	}

	@GetMapping(value = "/user/loginapp/{userName}/{userPassword}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> loginApp(@PathVariable("userName") String userName,
			@PathVariable("userPassword") String userPassword) throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/user/loginapp" + "loginApp Start");
		ResponseEntity<String> responseEntity = null;
		responseEntity = userAndPetConsumerService.loginApp(userName, userPassword);
		log.info("UserAndPetConsumerService Class loginApp Method Return Result");
		log.info("ConsumerController loginApp Method End");
		return responseEntity;

	}

	@DeleteMapping(value = "/delete/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteUser(@PathVariable long userId) throws ApplicationException {
		log.info("Client Send The Requset" + " " + "URL" + "/delete/" + userId + "deleteUser Method Start");
		ResponseEntity<String> responseEntity = null;
		responseEntity = userAndPetConsumerService.deleteUser(userId);
		log.info("UserAndPetConsumerService deleteUser Method Return Result");
		log.info("ConsumerController deleteUser Method End");
		return responseEntity;

	}

	@PutMapping(value = "/upadteUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/upadteUser" + "updateUser Start");
		ResponseEntity<User> responseEntity = null;
		responseEntity = userAndPetConsumerService.updateUser(user);
		log.info("UserAndPetConsumerService updatePetDetails Method Return Result");
		log.info("ConsumerController updateUser Method End");
		return responseEntity;

	}

	@GetMapping(value = "/findByUserName/{userName}")
	public ResponseEntity<User> findByUserName(@PathVariable String userName) throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/findByUserName" + "findByUserName Start");
		ResponseEntity<User> responseEntity = null;
		responseEntity = userAndPetConsumerService.findByUserName(userName);
		log.info("UserAndPetConsumerService updatePetDetails Method Return Result");
		log.info("ConsumerController findByUserName Method End");

		return responseEntity;

	}

	@GetMapping(value = "/getUsers")
	public ResponseEntity<List<User>> listUsers() throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/getUsers" + "listUsers Start");
		ResponseEntity<List<User>> responseEntity = null;
		responseEntity = userAndPetConsumerService.listUsers();
		log.info("UserAndPetConsumerService listUsers Method Return Result");
		log.info("ConsumerController listUsers Method End");

		return responseEntity;

	}

	@GetMapping(value = "/pets/buyPet/{userId}/{petId}")
	public ResponseEntity<String> buyPet(@PathVariable long userId, @PathVariable long petId)
			throws ApplicationException {
		log.info("Client Send The Requset" + " " + "URL" + "/pets/buyPet/" + userId + "/ " + petId
				+ "buyPet Method Start");
		ResponseEntity<String> responseEntity = null;
		responseEntity = userAndPetConsumerService.buyPet(userId, petId);
		log.info("UserAndPetConsumerService buyPet Method Return Result");
		log.info("ConsumerController buyPet Method End");
		return responseEntity;

	}

	@GetMapping(value = "/pets/myPets/{userId}")
	public ResponseEntity<List<Pet>> myPets(@PathVariable long userId) throws ApplicationException {
		log.info("Client Send The Requset" + " " + "URL" + "/pets/myPets/" + userId + "myPets Method Start");
		ResponseEntity<List<Pet>> responseEntity = null;
		responseEntity = userAndPetConsumerService.myPets(userId);
		if (responseEntity.getBody() == null) {
			throw new ApplicationException("Pet Details Not Found For This User Id");
		}
		log.info("UserAndPetConsumerService myPets Method Return Result");
		log.info("ConsumerController myPets Method End");
		return responseEntity;

	}

	@PostMapping(value = "/pets/addPet", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPet(@Valid @RequestBody Pet pet) throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/pets/addPet" + "addPet Start");
		ResponseEntity<String> responseEntity = null;
		responseEntity = userAndPetConsumerService.savePet(pet);
		log.info("UserAndPetConsumerService addPet Method Return Result Is");
		log.info("ConsumerController addPet Method End");
		return responseEntity;
	}

	@GetMapping(value = "/pets", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pet>> petHome() throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/pets" + "petHome Start");
		ResponseEntity<List<Pet>> responseEntity = null;
		responseEntity = userAndPetConsumerService.getAllPets();
		log.info("UserAndPetConsumerService petHome Method Return Result");
		log.info("ConsumerController petHome Method End");
		return responseEntity;

	}

	@GetMapping(value = "/pets/petDetail/{petId}")
	public ResponseEntity<Pet> petDetail(@PathVariable long petId) throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/pets/petDetail/{petId}" + "petDetail Start");
		ResponseEntity<Pet> responseEntity = null;
		responseEntity = userAndPetConsumerService.getPetById(petId);
		if (responseEntity.getBody().getId() > 0) {
			log.info("UserAndPetConsumerService petDetail Method Return Result");
			log.info("ConsumerController petDetail Method End");
			return responseEntity;
		} else {
			throw new ApplicationException("Your Passing PetId Details Not Present In DB Plz Check It");

		}

	}

	@PutMapping(value = "/pets/updatePet", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pet> updatePetDetails(@Valid @RequestBody Pet pet) throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/pets/updatePet" + "updatePetDetails Start");
		ResponseEntity<Pet> responseEntity = null;
		responseEntity = userAndPetConsumerService.updatePet(pet);
		log.info("PetServiceInterface updatePetDetails Method Return Result");
		log.info("PetController updatePet Method End");
		return responseEntity;

	}

	@DeleteMapping(value = "/pets/deletePet/{petId}")
	public ResponseEntity<String> deletePetById(@PathVariable long petId) throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/pets/deletePet/{petId}" + "deletePetById Start");
		ResponseEntity<String> responseEntity = null;
		responseEntity = userAndPetConsumerService.deletePetById(petId);
		log.info("PetServiceInterface deletePetById Method Return Result");
		log.info("PetController deletePetById Method End");
		return responseEntity;

	}

}
