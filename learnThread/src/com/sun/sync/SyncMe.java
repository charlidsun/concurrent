package com.sun.sync;

public class SyncMe {

	public static void main(String[] args) {
		MyFor my = new MyFor();
		Thread t1 = new Thread(()->my.add(),"a");
		Thread t2 = new Thread(()->my.sub(),"b");
		t1.start();
		t2.start();
	}
}

class MyFor {
	
	 void add() {
		synchronized (this) {
			for (int i=0;i<3;i++) {
				System.out.println(Thread.currentThread().getName() + i);
			}
		}
	}
	
	void sub() {
		for (int i=0;i<3;i++) {
			System.out.println(Thread.currentThread().getName() +i);
		}
	}
	
	
}
