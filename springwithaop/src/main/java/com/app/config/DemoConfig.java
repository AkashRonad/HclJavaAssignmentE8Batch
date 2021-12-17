package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.app.service.StudentService;
import com.app.service.StudentServiceImpl;

import om.app.dao.StudentDAO;
import om.app.dao.StudentDAOImpl;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.app")
public class DemoConfig {

	@Bean
	public StudentService studentService() {
		return new StudentServiceImpl();
	}

	@Bean
	public StudentDAO studentDAO() {
		return new StudentDAOImpl();
	}

}
