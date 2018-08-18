package com.sun.sync;

/**
 * sync 
 * @author Administrator
 *
 */
public class SyncVal {

	public static void main(String[] args) {
		GetVal g1 = new GetVal();
		Thread t1 = new Thread(g1,"t1");
		Thread t2 = new Thread(g1,"t2");
		t1.start();
		t2.start();
	}
}

class GetVal implements Runnable{
	
	int val = 1;
	@Override
	public void run() {
		synchronized (this) {
			for(int i=0;i<10;i++) {
				System.out.println(Thread.currentThread().getName() + i);
			}
		}
		
	}
	void add() {
		val++;
		System.out.println(Thread.currentThread().getName() + val);
	}
}
