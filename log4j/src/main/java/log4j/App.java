package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.method.Calculator;

public class App {

	private static final Logger LOGGER = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		System.out.println("Hello, user!");
		LOGGER.info("Main Method START");
		/*
		 * LOGGER.trace("We've just greeted the user!");
		 * LOGGER.debug("We've just greeted the user!");
		 * LOGGER.info("We've just greeted the user!");
		 * LOGGER.warn("We've just greeted the user!");
		 * LOGGER.error("We've just greeted the user!");
		 * LOGGER.fatal("We've just greeted the user!");
		 */

		Calculator calculator = new Calculator();
		LOGGER.info("Object HasCode" + calculator.hashCode());
		int res = calculator.add(4, 6);
		LOGGER.info("Method add() Resturn value" + res);
		LOGGER.info("Main Method END");

	}

}
