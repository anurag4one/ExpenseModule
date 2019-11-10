package com.cg.ems.expense;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpenseModuleApplication {
	
	static Logger myLogger = Logger.getLogger(ExpenseModuleApplication.class);
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		myLogger.info(" Inside Main Method.");
		SpringApplication.run(ExpenseModuleApplication.class, args);
	}
}