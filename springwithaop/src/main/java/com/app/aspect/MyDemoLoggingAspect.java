package com.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.app.model.Student;

@Component
@Aspect
public class MyDemoLoggingAspect {

	// Pointcut Expression Different Pattern

	// Particular Class Method Execution
	// @Before("execution(public void om.app.dao.AccountDAOImpl.addAccount())")
	// @Before("execution(public void addAccount())")
	// Match any methods starting with add in any class
	// @Before("execution(public void add*())")
	// @Before("execution(public * add*())")
	// @Before("execution(* add*())")
	// @Before("execution(* add*(*))")

	@Before("execution(* getStudentByIdValidation(*))")
	public void beforegetStudentByIdValidation(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Object[] objects = joinPoint.getArgs();
		for (Object object : objects) {
			Student student = (Student) object;
			student.setId(111111);
			student.setName("akashronad");
			student.setUsn("2go14cs001");

		}

		System.out.println("Before Service Layer Method Call" + methodSignature);

	}

	@AfterReturning("execution(* getStudentById(*))")
	public void aftergetStudentById(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Object[] objects = joinPoint.getArgs();
		for (Object object : objects) {
			Student student = (Student) object;
			String s1 = student.getName().substring(0, 1).toUpperCase();
			String nameCapitalized = s1 + student.getName().substring(1).toLowerCase();
			student.setName(nameCapitalized);

		}

		System.out.println("After DAO Method Called" + methodSignature);

	}
}
