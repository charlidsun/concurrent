package com.sun.sync;

public class SyncThread {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Sync("t1-");
		Thread t2 = new Sync("t2-");
		t1.start();
		t2.start();
		//t2.start();
	}
}
class Sync extends Thread{
	
	public Sync(String name) {
		super(name);
	}
	
	static int i = 0;
	@Override
	public void run() {
		synchronized (this) {
			for(int i=0;i<10;i++) {
				System.out.println(Thread.currentThread().getName() + i);
			}
		}
		
	}
	
	synchronized  void add() {
		i++;
	}
}