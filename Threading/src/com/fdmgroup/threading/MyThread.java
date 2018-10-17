package com.fdmgroup.threading;

public class MyThread extends Thread {

	@Override
	public void run() {
		ThreadTest.printThread();
	}
}
