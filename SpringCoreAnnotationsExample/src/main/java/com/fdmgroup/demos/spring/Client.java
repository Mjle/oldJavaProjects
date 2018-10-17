package com.fdmgroup.demos.spring;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client 
{
    public static void main( String[] args )
    {
    	BasicConfigurator.configure();
        ApplicationContext context = 
        		new ClassPathXmlApplicationContext("context.xml");
   
        User user = (User)context.getBean("user");
        System.out.println(user.getId());
        
        ((ConfigurableApplicationContext)context).close();
    }
}
