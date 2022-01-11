package com.hcl.user.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.user.customerror.ApplicationException;
import com.hcl.user.model.User;
import com.hcl.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public String addUser(User user) throws ApplicationException {

		String statusAdduser = null;
		if (user != null) {

			if (user.getUserPassword().equals(user.getUserConfirmPassword())) {

				User userTwo = userRepository.findByName(user.getUserName());
				if (userTwo == null) {
					User userThree = userRepository.save(user);

					if (userThree != null) {
						statusAdduser = "Your are successfully registerd please sign in";

					} else {

						throw new ApplicationException("Internal Server Error Plz Try After Some Times");

					}

				} else {

					throw new ApplicationException("User Alredy Registerd Plz Go To SignIn");

				}

			} else {
				throw new ApplicationException("UserPassword and ConfirmPassword Both are Matched");
			}

		} else {
			throw new ApplicationException("User Object Feilds Required To Perform Add Operation");
		}
		return statusAdduser;
	}

	@Override
	public User updateUser(User user) throws ApplicationException {
		User userTwo = null;
		if (user != null && user.getId() > 0) {
			Optional<User> optionalUser = userRepository.findById(user.getId());
			if (optionalUser.isPresent()) {
				userTwo = userRepository.save(user);
			} else {
				throw new ApplicationException("Passing User Id Not Present In Table");
			}

		} else {
			throw new ApplicationException("User Object Feilds and User Id Required To Perform Update Operation");
		}
		return userTwo;
	}

	@Override
	public List<User> listUsers() throws ApplicationException {
		List<User> users = null;

		users = userRepository.findAll();

		return users;
	}

	@Override
	public User getUserById(long userId) throws ApplicationException {

		User user = null;

		if (userId > 0) {
			Optional<User> optional = userRepository.findById(userId);

			if (optional.isPresent()) {
				user = optional.get();
			}

		} else {
			throw new ApplicationException("userId is Always greater than Zero");
		}

		return user;
	}

	@Override
	public String removeUser(long userId) throws ApplicationException {
		String removeUserStatus = null;
		if (userId > 0) {

			userRepository.deleteById(userId);
			removeUserStatus = "UserRecord deleted successfully";

		} else {
			throw new ApplicationException("User id is Required");
		}
		return removeUserStatus;
	}

	@Override
	public String loginApp(String userName, String password) throws ApplicationException {

		String loginStatus = null;

		if (userName.length() != 0 && password.length() != 0) {
			User user = userRepository.findByNameAndPassword(userName, password);
			if (user != null) {
				loginStatus = "Login successfully";
			}

		} else {
			throw new ApplicationException("UserName And Password Is Required");
		}

		return loginStatus;
	}

	@Override
	public User findByUserName(String username) throws ApplicationException {

		User user = null;
		if (username.length() != 0) {

			user = userRepository.findByName(username);

		} else {
			throw new ApplicationException("userName Is Required");
		}

		return user;
	}

	@Override
	public String buyPet(long userId, long petId) throws ApplicationException {

		String buyPetStatus = null;
		Optional<User> optionalUser = null;
		ResponseEntity<String> responseEntity = null;
		if (userId > 0 && petId > 0) {
			optionalUser = userRepository.findById(userId);
			if (optionalUser.isPresent()) {
				HttpHeaders httpHeaders = new HttpHeaders();
				httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				HttpEntity httpEntity = new HttpEntity(httpHeaders);
				responseEntity = restTemplate.exchange(
						"http://localhost:9098/petcon/pets/buyPet/" + userId + "/" + petId, HttpMethod.GET, httpEntity,
						String.class);

				if (responseEntity.getBody() != null) {
					buyPetStatus = responseEntity.getBody();

				} else {
					throw new ApplicationException("Internal Server Error");
				}
			} else {
				throw new ApplicationException("User Id Not present in table Check Your User Id");
			}

		} else {
			throw new ApplicationException("userId And petId Is Required");
		}

		return buyPetStatus;
	}

	@Override
	public String deleteUser(long userId) throws ApplicationException {
		String deleteStatus = null;
		if (userId > 0) {
			System.out.println(userId);
			Optional<User> optionalUser = userRepository.findById(userId);
			if (optionalUser.isPresent()) {
				userRepository.deleteById(userId);
				deleteStatus = "User record deleted successfully";
			} else {
				throw new ApplicationException("Your Passing User Id Not Present In Table");
			}

		} else {
			throw new ApplicationException("userId is required");
		}

		return deleteStatus;
	}

}
