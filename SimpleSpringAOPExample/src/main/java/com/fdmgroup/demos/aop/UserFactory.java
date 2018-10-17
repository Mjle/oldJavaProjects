package com.fdmgroup.demos.aop;

public class UserFactory {

	public void work()
	{
		System.out.println("[UserFactory.work()]");
	}
	
	
	public int work(int x)
	{
		System.out.println("[UserFactory.work(int)]");		
		return 1;
	}
	

	public void startup(String x){
		System.out.println("[UserFactory.startup(String)]");
	}
	
	
	public User createUser()
	{
		System.out.println("[UserFactory.createUser()]");
		return new User();
	}


}
