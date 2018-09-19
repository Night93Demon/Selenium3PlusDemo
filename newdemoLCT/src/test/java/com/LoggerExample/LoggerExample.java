package com.LoggerExample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerExample {
	
	public static Logger mainLogger = LogManager.getLogger(LoggerExample.class.getName());
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	//	BasicConfigurator.configure();
 
		//Create a console appender and attach it to our mainLogger
		//ConsoleAppender appender = new ConsoleAppender();
		//mainLogger.addAppender(appender);
		mainLogger.info("This is just a logger");	
	}

}
