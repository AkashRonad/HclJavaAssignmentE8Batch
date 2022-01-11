package com.hcl.pet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.pet.customerror.ApplicationException;
import com.hcl.pet.model.Pet;
import com.hcl.pet.service.PetService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/petcon")
public class PetController {

	@Autowired
	private PetService petService;

	@PostMapping(value = "/pets/addPet", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPet(@Valid @RequestBody Pet pet) throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/pets/addPet" + "addPet Start");
		ResponseEntity<String> responseEntity = null;
		String statusOfAddPets = petService.savePet(pet);
		log.info("PetServiceInterface addPet Method Return Result Is" + statusOfAddPets);
		if (statusOfAddPets != null) {
			responseEntity = new ResponseEntity<String>(statusOfAddPets, HttpStatus.CREATED);
		} else {
			log.info("Bad Request Plz Try Onces Again");
			throw new ApplicationException("Bad Request Plz Try Onces Again");

		}

		log.info("PetController addPet Method End");

		return responseEntity;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/pets", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pet>> petHome() throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/pets" + "petHome Start");
		List<Pet> pets = null;
		ResponseEntity<List<Pet>> responseEntity = null;
		pets = petService.getAllPets();
		log.info("PetServiceInterface petHome Method Return Result");
		if (pets != null && pets.size() > 0) {
			responseEntity = new ResponseEntity<List<Pet>>(pets, HttpStatus.CREATED);

		} else {
			log.info("No Pets Avalible In DB Table");

			throw new ApplicationException("No Pets Avalible In DB Table");

		}

		log.info("PetController petHome Method End");
		return responseEntity;

	}

	@GetMapping(value = "/pets/petDetail/{petId}")
	public ResponseEntity<Pet> petDetail(@PathVariable long petId) throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/pets/petDetail/{petId}" + "petDetail Start");
		Pet pet = null;
		ResponseEntity<Pet> responseEntity = null;
		pet = petService.getPetById(petId);
		log.info("PetServiceInterface petDetail Method Return Result");
		if (pet != null ) {
			responseEntity = new ResponseEntity<Pet>(pet, HttpStatus.OK);
		} else {
			log.info("Your Passing PetId Details Not Present In DB Plz Check It");
			throw new ApplicationException("Your Passing PetId Details Not Present In DB Plz Check It");

		}

		log.info("PetController petDetail Method End");
		return responseEntity;

	}

	@PutMapping(value = "/pets/updatePet", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pet> updatePetDetails(@Valid @RequestBody Pet pet) throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/pets/updatePet" + "updatePetDetails Start");
		Pet petOne = null;
		ResponseEntity<Pet> responseEntity = null;
		petOne = petService.updatePet(pet);
		log.info("PetServiceInterface updatePetDetails Method Return Result");
		if (petOne != null) {
			responseEntity = new ResponseEntity<Pet>(petOne, HttpStatus.OK);

		} else {

			log.info("Upadate Failed Check Pet Object Details");

			throw new ApplicationException("Upadate Failed Check Pet Object Details");

		}
		log.info("PetController updatePet Method End");
		return responseEntity;

	}

	@DeleteMapping(value = "/pets/deletePet/{petId}")
	public ResponseEntity<String> deletePetById(@PathVariable long petId) throws ApplicationException {
		log.info(" Client Send The Requset" + " " + "URL" + "/pets/deletePet/{petId}" + "deletePetById Start");
		ResponseEntity<String> responseEntity = null;
		String statausOfDeletePet = petService.deletePetById(petId);
		log.info("PetServiceInterface deletePetById Method Return Result");
		if (statausOfDeletePet != null) {
			responseEntity = new ResponseEntity<String>(statausOfDeletePet, HttpStatus.OK);
		} else {

			log.info("Bad Status Plz Try Onces Again");
			throw new ApplicationException("Bad Status Plz Try Onces Again");

		}

		log.info("PetController deletePetById Method End");
		return responseEntity;

	}

	@GetMapping(value = "/pets/buyPet/{userId}/{petId}")
	public ResponseEntity<String> buyPet(@PathVariable long userId, @PathVariable long petId)
			throws ApplicationException {
		log.info("Client Send The Requset" + " " + "URL" + "/pets/buyPet/" + userId + "/ " + petId
				+ "buyPet Method Start");
		ResponseEntity<String> responseEntity = null;
		int numberOfRowAffected = petService.buyPet(userId, petId);
		log.info("PetServiceInterface buyPet Method Return Result");
		if (numberOfRowAffected > 0) {
			log.info("PetServiceInterface buyPet Method Return Result Integer Data");

			responseEntity = new ResponseEntity<String>("Add the New pet to the user", HttpStatus.OK);

		} else {
			log.info("Pet is Already Sold Out");
			throw new ApplicationException("Pet is Already Sold Out");

		}

		log.info("Pet Controller buyPet Method End");
		return responseEntity;

	}

	@GetMapping(value = "/pets/myPets/{userId}")
	public ResponseEntity<List<Pet>> myPets(@PathVariable long userId) throws ApplicationException {
		log.info("Client Send The Requset" + " " + "URL" + "/pets/myPets/" + userId + "myPets Method Start");
		List<Pet> pets = null;
		ResponseEntity<List<Pet>> responseEntity = null;
		pets = petService.myPets(userId);
		log.info("PetServiceInterface myPets Method Return Result");
		if (pets != null && pets.size() > 0 && pets.isEmpty()== false) {
			log.info("PetServiceInterface myPets Method Return Result List<Pets> List Contains Data");
			responseEntity = new ResponseEntity<List<Pet>>(pets, HttpStatus.OK);
		}
		log.info("PetController myPets Method End");
		return responseEntity;

	}

}
