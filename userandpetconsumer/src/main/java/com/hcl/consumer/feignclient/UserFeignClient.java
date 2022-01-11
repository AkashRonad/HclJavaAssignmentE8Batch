package com.hcl.consumer.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.consumer.model.User;

@FeignClient(name = "USER-SERVICE/usercon")
public interface UserFeignClient {

	@PostMapping(value = "/user/add")
	public abstract ResponseEntity<String> addUser(User user);
	
	@GetMapping(value ="/user/loginapp/{userName}/{userPassword}")
	public abstract ResponseEntity<String> loginApp(@PathVariable String userName, @PathVariable String userPassword);
	
	@DeleteMapping(value = "/delete/{userId}")
	public abstract ResponseEntity<String> deleteUser(@PathVariable long userId);
	
	@PutMapping(value = "/upadteUser")
	public abstract ResponseEntity<User> updateUser(User user);
	
	@GetMapping(value="/findByUserName/{userName}")
	public abstract ResponseEntity<User> findByUserName(@PathVariable String userName);
	
	@GetMapping(value = "/getUsers")
	public abstract ResponseEntity<List<User>> listUsers();
	
	@GetMapping(value = "/pets/buyPet/{userId}/{petId}")
	public abstract ResponseEntity<String> buyPet(@PathVariable long userId,@PathVariable long petId);
	
	

}
