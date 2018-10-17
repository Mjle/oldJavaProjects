package com.fdmgroup.demos.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("example.xml");
		
		UserFactory userFactory = (UserFactory) ctx.getBean("factory");
		
		User user = (User) ctx.getBean("user");

		user.work();
		user.play();
		
		userFactory.work();
		
		((ConfigurableApplicationContext)ctx).close();
		
	}
}
