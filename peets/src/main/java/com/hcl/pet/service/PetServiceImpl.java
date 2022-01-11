package com.hcl.pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.pet.customerror.ApplicationException;
import com.hcl.pet.model.Pet;
import com.hcl.pet.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepository;

	@Override
	public String savePet(Pet pet) throws ApplicationException {

		String saveStatus = null;

		if (pet != null) {

			petRepository.save(pet);

			saveStatus = "Pet Saved Sucessfully";

		} else {
			throw new ApplicationException("Pet Object Details For Add Operation");
		}

		return saveStatus;
	}

	@Override
	public List<Pet> getAllPets() throws ApplicationException {

		return petRepository.findAll();
	}

	@Override
	public Pet getPetById(long petId) throws ApplicationException {

		Pet pet = null;

		if (petId > 0) {

			Optional<Pet> optionalPet = petRepository.findById(petId);
			if (optionalPet.isPresent()) {
				pet = optionalPet.get();

			} else {
				throw new ApplicationException("Your Sending Id Not Present In Table");
			}

		} else {
			throw new ApplicationException("Pet id Not Negative Number");
		}

		return pet;
	}

	@Override
	public Pet updatePet(Pet pet) throws ApplicationException {
		Pet petTwo = null;
		if (pet != null && pet.getId() > 0) {
			Optional<Pet> optionalPet = petRepository.findById(pet.getId());
			if (optionalPet.isPresent()) {
				petTwo = petRepository.save(pet);

			} else {
				throw new ApplicationException("Your Passing Pet Id Not Present In Table");
			}

		} else {
			throw new ApplicationException("Pet Id And PetDetails Required");
		}
		return petTwo;
	}

	@Override
	public String deletePetById(long petId) throws ApplicationException {
		String deleteStatus = null;
		if (petId > 0) {
			Optional<Pet> optionalPet = petRepository.findById(petId);
			if (optionalPet.isPresent()) {
				petRepository.deleteById(petId);
				deleteStatus = "Deleted Sucessfully";

			} else {
				throw new ApplicationException("Your Passing Pet Id Not Present In Table");
			}

		} else {
			throw new ApplicationException("petId always Postive Number");
		}
		return deleteStatus;
	}

	@Override
	public int buyPet(long userId, long petId) throws ApplicationException {
		int numberofRowAfftected = 0;
		if (userId > 0 && petId > 0) {
			Optional<Pet> optional = petRepository.findById(petId);
			if (optional.isPresent()) {
				numberofRowAfftected = petRepository.updatePetByUserId(userId, petId);

			} else {
				throw new ApplicationException("Pet Details Not Found plz Check Pet Id");
			}

		} else {
			throw new ApplicationException("Pet id and UserId Required");
		}
		return numberofRowAfftected;
	}

	@Override
	public List<Pet> myPets(long userId) throws ApplicationException {
		List<Pet> pets = null;
		if (userId > 0) {
			pets = petRepository.findByUserId(userId);
		} else {
			throw new ApplicationException("User Id Is Required");
		}
		return pets;
	}

}
