package com.hcl.pp.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.hcl.pp.model.Pet;
import com.hcl.pp.service.PetService;

@RestController
public class PetsController {

	@Autowired
	private PetService petService;

	@PostMapping(value = "/pets/addPet", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPet(@RequestBody Pet pet) {
		ResponseEntity<String> responseEntity = null;
		String statusOfAddPets = petService.savePet(pet);

		if (statusOfAddPets != null) {
			responseEntity = new ResponseEntity<String>(statusOfAddPets, HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<String>("Bad Status Plz Try Onces Again", HttpStatus.BAD_REQUEST);

		}

		return responseEntity;
	}

	@GetMapping(value = "/pets", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> petHome() {

		List<Pet> pets = null;
		List<Object> errorMessageObject = null;
		pets = petService.getAllPets();
		if (pets != null) {
			List<Object> petObjects = new ArrayList<Object>();
			petObjects.addAll(pets);
			return petObjects;
		} else {
			errorMessageObject = new ArrayList<Object>();
			errorMessageObject.add("No Pets Avalible In DB Table");

		}

		return errorMessageObject;

	}

	@GetMapping(value = "/pets/petDetail/{petId}")
	public ResponseEntity<Object> petDetail(@PathVariable long petId) {
		Pet pet = null;
		ResponseEntity<Object> responseEntity = null;
		pet = petService.getPetById(petId);
		if (pet != null) {
			responseEntity = new ResponseEntity<Object>(pet, HttpStatus.FOUND);

		} else {

			responseEntity = new ResponseEntity<Object>("Your Passing PetId Details Not Present In DB Plz Check It",
					HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}

	@PutMapping(value = "/pets/updatePet")
	public ResponseEntity<Object> updatePetDetails(@RequestBody Pet pet) {
		Pet petOne = null;
		ResponseEntity<Object> responseEntity = null;
		petOne = petService.updatePet(pet);
		if (petOne != null) {
			responseEntity = new ResponseEntity<Object>(pet, HttpStatus.ACCEPTED);

		} else {
			responseEntity = new ResponseEntity<Object>("Upadate Failed Check Pet Object Details",
					HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}

	@DeleteMapping(value = "/pets/deletePet/{petId}")
	public ResponseEntity<String> deletePetById(@PathVariable long petId) {
		ResponseEntity<String> responseEntity = null;
		String statausOfDeletePet = petService.deletePetById(petId);

		if (statausOfDeletePet != null) {
			responseEntity = new ResponseEntity<String>(statausOfDeletePet, HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<String>("Bad Status Plz Try Onces Again", HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}

}
