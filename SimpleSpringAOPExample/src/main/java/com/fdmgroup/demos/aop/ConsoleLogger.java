package com.fdmgroup.demos.aop;



// ADVICE
public class ConsoleLogger {
	
	public void logEntry()
	{
		System.out.println("LOG: Entering a method...");
	}
	
	public void logExitWork()
	{
		System.out.println("LOG: Exiting work()...");
	}
	
	public void logReturnUser(User returnedObject)
	{	
		System.out.println("LOG: User was returned: "+ returnedObject);
	}

	public void logThrowException(Exception thrownException)
	{
		System.out.println("LOG: An Exception was thrown: "+ 
					thrownException.getClass().getSimpleName());
	}
	
	
}
