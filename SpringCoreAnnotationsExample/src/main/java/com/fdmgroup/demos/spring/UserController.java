package com.fdmgroup.demos.spring;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

public class UserController {

	private Logger log = Logger.getLogger(UserController.class);
	
	@Resource
	private UserFactory userFactory;
	@Resource(name="users")
	private UserStorage userStorage;
	
	public void init(){
		userStorage.print();
		log.info(userFactory.getUser().getId());
	}
	
	
}
