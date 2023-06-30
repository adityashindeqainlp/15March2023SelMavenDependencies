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
		
		
		System.out.println(" Hello world..!");
        
		logger.trace("This is a trace test");
		logger.info("This is an inforamtion message");
		logger.warn("This ia a warning test");
		logger.error("This is a error test");
		logger.fatal("This is a fatal test");
		logger.debug("This is a debug test");
		
		System.out.println("completed");
	}
}
