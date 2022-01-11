package com.hcl.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableFeignClients
@EnableEurekaClient
public class UserandpetconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserandpetconsumerApplication.class, args);
		log.info("Main Method Start Consumer");
	}
	
	  @Bean public RestTemplate getRestTemplate() { return new RestTemplate(); }
	 

}
