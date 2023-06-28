package Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
*@Author -- Aditya Shinde Java + Selenium 
* 28-Jun-2023
* 12:44:08 pm
**/
public class Log4jDemo {

	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] args) {
		
		
		System.out.println("\n Hello world..!  \n");
		
		logger.trace("This is trace message");
		logger.info("This is a information message");
		logger.warn("This is a warning message");
	    logger.error("This is an error message");
		logger.fatal("This is a fatal message");
		
		System.out.println("\n  completed");
	}
}
