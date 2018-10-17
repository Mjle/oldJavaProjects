package com.fdmgroup.threading;

public class ThreadTest {

	public static synchronized void printThread (){
		for (int i = 0; i<= 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new MyThread();
//		t1.run();
		t1.start();
		
		//how does it know to run them simultaneously?
		
		MyRunnable r1 = new MyRunnable();
		Thread t2 = new Thread(r1);
		t2.start();
		
//		Thread t2 = new MyThread();
//		t2.start();
	}

}
