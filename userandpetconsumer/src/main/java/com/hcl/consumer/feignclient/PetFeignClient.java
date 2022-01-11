package com.hcl.consumer.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.hcl.consumer.model.Pet;

@FeignClient(name = "PEETS-SERVICE/petcon")
public interface PetFeignClient {

	@GetMapping(value = "/pets/myPets/{userId}")
	public abstract ResponseEntity<List<Pet>> myPets(@PathVariable long userId);

	@PostMapping(value = "/pets/addPet")
	public abstract ResponseEntity<String> addPet(Pet pet);

	@GetMapping(value = "/pets")
	public abstract ResponseEntity<List<Pet>> getAllPets();

	@GetMapping(value = "/pets/petDetail/{petId}")
	public abstract ResponseEntity<Pet> getPetById(@PathVariable long petId);

	@PutMapping(value = "/pets/updatePet")
	public abstract ResponseEntity<Pet> updatePet(Pet pet);

	@DeleteMapping(value = "/pets/deletePet/{petId}")
	public abstract ResponseEntity<String> deletePetById(@PathVariable long petId);

}
