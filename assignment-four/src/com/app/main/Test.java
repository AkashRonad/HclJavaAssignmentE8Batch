package com.app.main;

import com.app.module.Address;
import com.app.module.Deparment;
import com.app.module.Employee;

public class Test {

	public static void main(String[] args) {

		Deparment deparment = new Deparment(1, "CSE",
				new Employee(11111, "Akash", new Address("Near Sp", "903G", "Gadag", "Karnataka", 582101)));
		
		System.out.println(deparment);

	}

}
