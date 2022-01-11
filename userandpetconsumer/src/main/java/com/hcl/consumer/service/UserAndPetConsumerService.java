package com.hcl.consumer.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hcl.consumer.customerror.ApplicationException;
import com.hcl.consumer.model.Pet;
import com.hcl.consumer.model.User;

public interface UserAndPetConsumerService {
	public abstract ResponseEntity<String> addUser(User user) throws ApplicationException;

	public abstract ResponseEntity<String> loginApp(String userName, String password) throws ApplicationException;

	public abstract ResponseEntity<String> deleteUser(long userId) throws ApplicationException;

	public abstract ResponseEntity<User> updateUser(User user) throws ApplicationException;

	public abstract ResponseEntity<User> findByUserName(String username) throws ApplicationException;
	
	public abstract ResponseEntity<List<User>> listUsers() throws ApplicationException;
	
	public abstract ResponseEntity<String> buyPet(long userId, long petId) throws ApplicationException;
	
	public abstract ResponseEntity<List<Pet>> myPets(long userId) throws ApplicationException;
	
	public abstract ResponseEntity<String> savePet(Pet pet) throws ApplicationException;
	
	public abstract ResponseEntity<List<Pet>> getAllPets() throws ApplicationException;
	
	public abstract ResponseEntity<Pet> getPetById(long petId) throws ApplicationException;
	
	public abstract ResponseEntity<Pet> updatePet(Pet pet) throws ApplicationException;
	
	public abstract ResponseEntity<String> deletePetById(long petId) throws ApplicationException;
	
	

}
