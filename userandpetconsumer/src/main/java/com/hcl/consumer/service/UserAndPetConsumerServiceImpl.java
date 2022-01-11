package com.hcl.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.consumer.customerror.ApplicationException;
import com.hcl.consumer.feignclient.PetFeignClient;
import com.hcl.consumer.feignclient.UserFeignClient;
import com.hcl.consumer.model.Pet;
import com.hcl.consumer.model.User;

@Service
public class UserAndPetConsumerServiceImpl implements UserAndPetConsumerService {

	@Autowired
	private UserFeignClient userFeignClient;

	@Autowired
	private PetFeignClient petFeignClient;

	@Override
	public ResponseEntity<String> addUser(User user) throws ApplicationException {
		ResponseEntity<String> responseEntity = null;
		if (user != null) {
			responseEntity = userFeignClient.addUser(user);

		} else {
			throw new ApplicationException("User Object Details Are Required");
		}

		return responseEntity;
	}

	@Override
	public ResponseEntity<String> loginApp(String userName, String password) throws ApplicationException {
		ResponseEntity<String> responseEntity = null;
		if (userName.length() > 0 && password.length() > 0 && userName != null && password != null) {
			responseEntity = userFeignClient.loginApp(userName, password);
		} else {
			throw new ApplicationException("User name And Password Is Required");
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<String> deleteUser(long userId) throws ApplicationException {
		ResponseEntity<String> responseEntity = null;
		if (userId > 0) {
			responseEntity = userFeignClient.deleteUser(userId);

		} else {
			throw new ApplicationException("UserId Not Negative Number is Required For Delete Operatin");
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<User> updateUser(User user) throws ApplicationException {
		ResponseEntity<User> responseEntity = null;
		if (user != null && user.getId() > 0) {
			responseEntity = userFeignClient.updateUser(user);

		} else {
			throw new ApplicationException("User Id and User Details are Required for Update Operation");
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<User> findByUserName(String username) throws ApplicationException {
		ResponseEntity<User> responseEntity = null;
		if (username != null && username.length() !=0) {
			responseEntity = userFeignClient.findByUserName(username);
		} else {
			throw new ApplicationException("UserName Is Required");
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<List<User>> listUsers() throws ApplicationException {
		ResponseEntity<List<User>> responseEntity = null;
		responseEntity = userFeignClient.listUsers();
		return responseEntity;
	}

	@Override
	public ResponseEntity<String> buyPet(long userId, long petId) throws ApplicationException {
		ResponseEntity<String> responseEntity = null;
		if (userId > 0 && petId > 0) {
			responseEntity = userFeignClient.buyPet(userId, petId);

		} else {
			throw new ApplicationException("Check UserId And PetId");
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<List<Pet>> myPets(long userId) throws ApplicationException {
		ResponseEntity<List<Pet>> responseEntity = null;
		if (userId > 0) {
			responseEntity = petFeignClient.myPets(userId);

		} else {
			throw new ApplicationException("User Id Is Required");
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<String> savePet(Pet pet) throws ApplicationException {
		ResponseEntity<String> responseEntity = null;
		if (pet != null) {
			responseEntity = petFeignClient.addPet(pet);

		} else {

			throw new ApplicationException("Pet Details Are Required");

		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<List<Pet>> getAllPets() throws ApplicationException {
		ResponseEntity<List<Pet>> responseEntity = null;
		responseEntity=petFeignClient.getAllPets();
		return responseEntity;
	}

	@Override
	public ResponseEntity<Pet> getPetById(long petId) throws ApplicationException {
		ResponseEntity<Pet> responseEntity=null;
		if(petId>0) {
			responseEntity=petFeignClient.getPetById(petId);
		}else {
			throw new ApplicationException("Pet Id is Required");
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<Pet> updatePet(Pet pet) throws ApplicationException {
		ResponseEntity<Pet> responseEntity= null;
		if(pet!=null && pet.getId()>0) {
			responseEntity=petFeignClient.updatePet(pet);
		}else {
			throw new ApplicationException("Pet Id and Pet Details Are Required");
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<String> deletePetById(long petId) throws ApplicationException {
		
		ResponseEntity<String> responseEntity = null;
		
		if(petId>0) {
			responseEntity=petFeignClient.deletePetById(petId);
			
		}else {
			throw new ApplicationException("Pet Id Is Required");
		}
		
		return responseEntity;
	}

}
