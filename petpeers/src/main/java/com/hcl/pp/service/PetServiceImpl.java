package com.hcl.pp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.exception.AppliactionException;
import com.hcl.pp.dao.PetDAO;
import com.hcl.pp.model.Pet;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetDAO petDAO;

	@Override
	public String savePet(Pet pet) throws AppliactionException {

		String statusSavePet = null;
		if (pet != null && pet.getName() != null && pet.getPlace() != null && pet.getAge() > 0) {

			statusSavePet = petDAO.savePet(pet);

		}else {
			throw new AppliactionException("Pets Details Required");
		}

		return statusSavePet;
	}

	@Override
	public List<Pet> getAllPets() throws AppliactionException {

		return petDAO.getAllPets();
	}

	@Override
	public Pet getPetById(long petId) throws AppliactionException {
		Pet pet = null;
		if (petId > 0) {
			pet = petDAO.getPetById(petId);
		}else {
			throw new AppliactionException("PetId Is Required");
		}
		return pet;
	}

	@Override
	public Pet updatePet(Pet pet) throws AppliactionException {
		Pet petTwo = null;
		if (pet != null && pet.getId() > 0) {

			petTwo = petDAO.updatePet(pet);

		}else {
			throw new AppliactionException("Pet Details Required");
		}
		return petTwo;
	}

	@Override
	public String deletePetById(long petId) throws AppliactionException {
		String statusOfRemovePet = null;
		if (petId > 0) {
			statusOfRemovePet = petDAO.deletePetById(petId);
		}else {
			throw new AppliactionException("Pet id Is Required");
		}
		return statusOfRemovePet;
	}

}
