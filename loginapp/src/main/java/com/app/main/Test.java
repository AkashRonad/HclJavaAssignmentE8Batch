package com.app.main;

import java.util.Scanner;

import com.app.exception.ApplicationException;
import com.app.module.Department;
import com.app.service.DepartmentService;
import com.app.service.DepartmentServiceImpl;

public class Test {

	public static void main(String[] args) {
		int userId = 0;
		String password = null;
		Scanner clientInput = new Scanner(System.in);
		System.out.println("Enter User Id:");

		if (clientInput.hasNextInt()) {
			userId = clientInput.nextInt();

		}

		System.out.println("Enter Your Password:");

		if (clientInput.hasNext()) {
			password = clientInput.next();
		}

		DepartmentService departmentService = new DepartmentServiceImpl();
		try {
			Department department = departmentService.authenticateValidation(userId, password);
			if (department != null) {

				System.out.println("Wellcome:" + department.getEmployee().getEmployeeName());
				System.out.println("Employee Id " + department.getEmployee().getEmployeeUserId());
				System.out.println("Department Name Of Employee:" + department.getDepartmentName());

			}
		} catch (ApplicationException e) {
			System.err.println(e.getMessage());
		} finally {

			clientInput.close();

		}

	}

}
