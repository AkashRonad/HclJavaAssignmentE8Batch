package com.app.methods;

import java.util.Scanner;

import com.app.module.Employee;

public class AllMethods {

	public static void fetchAllEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("How Many Employee You Want To Stored");
		int sizeOfEmployee = sc.nextInt();
		Employee employees[] = new Employee[sizeOfEmployee];

		for (int i = 0; i < employees.length; i++) {
			System.out.println("Enter" + " " + i + " " + "Employee Name" + ":");
			String name = sc.next();
			System.out.println("Enter" + " " + i + " " + "Employee id" + ":");
			int id = sc.nextInt();
			System.out.println("Enter" + " " + i + " " + "Employee Salary" + ":");
			float salary = sc.nextFloat();
			Employee employee = new Employee(id, name, salary);
			employees[i] = employee;

		}

		// Display the Details

		for (int i = 0; i < employees.length; i++) {
			Employee employees1 = employees[i];
			System.out.println(employees1);

		}

		if (sc != null) {
			sc.close();

		}

	}

}
