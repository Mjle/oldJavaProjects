package com.fdmgroup.demos.aop;


public class User {

	private String	name;
	private String	message;

	public User(String name, String message) {
		
		setName(name);
		setMessage(message);
	}

	public User() {	}

	public void work() {
		System.out.println("[User.work()]");
	}

	public void play() {
		System.out.println("[User.play()]");
	}

	public User getInstance() {

		//if (new Random().nextBoolean()) {
			System.out.println("[User.getInstance()]");
			return new User();
		//}
		//else {
		//	System.out.println("[User throwing NullPointerException]");
		//	throw new NullPointerException();
		//}
	}

	public String toString() {
		return "User " + name + ": " + message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
