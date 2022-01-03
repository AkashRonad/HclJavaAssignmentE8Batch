package com.hcl.pp.service;

import java.util.List;

import com.hcl.exception.AppliactionException;
import com.hcl.pp.model.Pet;

public interface PetService {

	public abstract String savePet(Pet pet) throws AppliactionException;

	public abstract List<Pet> getAllPets() throws AppliactionException;

	public abstract Pet getPetById(long petId) throws AppliactionException;

	public abstract Pet updatePet(Pet pet) throws AppliactionException;

	public abstract String deletePetById(long petId) throws AppliactionException;

}
