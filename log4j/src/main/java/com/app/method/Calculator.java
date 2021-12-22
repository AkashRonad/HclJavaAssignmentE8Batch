package com.app.method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

	private static final Logger LOGGER = LogManager.getLogger(Calculator.class);
	public int add(int num1, int num2) {
	  LOGGER.info("Method START");	
      LOGGER.info("Method Varibale Paramaters"+ num1 +" "+num2);
      LOGGER.info("Method END");
		return num1 + num2;
	}

}
