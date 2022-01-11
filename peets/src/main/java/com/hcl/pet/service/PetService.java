package com.hcl.pet.service;

import java.util.List;

import com.hcl.pet.customerror.ApplicationException;
import com.hcl.pet.model.Pet;

public interface PetService {

	public abstract String savePet(Pet pet) throws ApplicationException;

	public abstract List<Pet> getAllPets() throws ApplicationException;

	public abstract Pet getPetById(long petId) throws ApplicationException;

	public abstract Pet updatePet(Pet pet) throws ApplicationException;

	public abstract String deletePetById(long petId) throws ApplicationException;
	
	public abstract int buyPet(long userId, long petId) throws ApplicationException;
	
	public abstract List<Pet> myPets(long userId) throws ApplicationException;
	

}
