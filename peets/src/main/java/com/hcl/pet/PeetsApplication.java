package com.hcl.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableFeignClients
@EnableEurekaClient
public class PeetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeetsApplication.class, args);
		log.info("Main Method Start Pets");
	}

}