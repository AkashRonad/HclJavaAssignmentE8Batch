package com.app.methods;

import java.util.Scanner;

import com.app.module.Employee;

public class AllMethods {

	public static int[] storedData() {
		int data[] = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Elements you want to enter ?" + ":");
		int arraysize = sc.nextInt();

		if (arraysize > 0) {
			data = new int[arraysize];

		}

		for (int i = 0; i < arraysize; i++) {
			System.out.println("Enter your Array Elements : " + +i);
			data[i] = sc.nextInt();
		}

		if (sc != null) {
			sc.close();

		}

		return data;

	}

	public static void displayArrayNumbers(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public static int sumOfAllArrayElements(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}

		return sum;
	}

	public static void reverseArrayElements(int arr[]) {

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println("Reverse Order :" + arr[i]);
		}

	}

	public static float calculateTotalSalary(Employee employee[]) {
		float salary = 0L;
		for (int i = 0; i < employee.length; i++) {
			Employee employees = employee[i];
			salary = salary + employees.getSalary();

		}

		return salary;
	}

	public static int[] findEachEmployeeNameLength(Employee employee[]) {

		int lengthOfEmployeeName[] = new int[employee.length];
		for (int i = 0; i < employee.length; i++) {
			Employee employees = employee[i];
			lengthOfEmployeeName[i] = employees.getName().length();

		}

		return lengthOfEmployeeName;

	}

	public static Employee retriveEmployeeDetailsBasedOnId(int id, Employee employee[]) {
		Employee employee1 = null;

		for (int i = 0; i < employee.length; i++) {
			Employee employees = employee[i];
			if (employees.getId() == id) {
				employee1 = employees;
			}

		}

		return employee1;
	}

}
