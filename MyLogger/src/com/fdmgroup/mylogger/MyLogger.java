package com.fdmgroup.mylogger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.xml.DOMConfigurator;

public class MyLogger {

	static Logger myLogger = Logger.getLogger("programmerLogger");

	public static void main(String[] args) {

		BasicConfigurator.configure();
		PropertyConfigurator.configure("./mylog4j.properties");
		// DOMConfigurator.configure(".mylog4j.xml"); //if xml

		int num = 10, denum = 0;
		try {
			int result = num / denum;
			System.out.println("Result is: " + result);
		} catch (ArithmeticException e) {
			String msg = "Invalid Input";
//			System.out.println(msg);
			myLogger.error(msg);
		}
	}
}
