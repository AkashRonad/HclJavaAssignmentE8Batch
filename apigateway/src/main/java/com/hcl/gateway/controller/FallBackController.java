package com.hcl.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
	
	
	@GetMapping(value = "/userServiceFallBack")
	public String userServiceFallBack() {
		return "User Service Taking Longer Than Expected " + " "+ "Please Try Again";
	}
	
	@GetMapping(value = "/petServiceFallBack")
	public String petServiceFallBack() {
		return "Pet Service Taking Longer Than Expected " + " "+ "Please Try Again";
	}
	
	@GetMapping(value = "/consumerServiceFallBack")
	public String consumerServiceFallBack() {
		return "Consumer Service Taking Longer Than Expected " + " "+ "Please Try Again";
	}

}
