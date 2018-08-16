package com.sun.demo;

public class MyThread {

	public static void main(String[] args) {
		// thread，继承thread，重写run，然后调用start
		ThreadTest1 t = new ThreadTest1();
		//t.start();
		ThreadTest2 t2 = new ThreadTest2();
		//t2.start();
		// runnable,使用runnable接口
		Thread r1 = new Thread(new Runnable1());
		//r1.start();
		Thread c1 = new ShareData();
		c1.start();
		c1.start();
		c1.start();
	}

}

class ThreadTest1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.err.println("test1->" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadTest2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.err.println("test2->" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Runnable1 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.err.println("Runnabletest2->" + i);
				// 停止线程的方式
				if (i==5) {
					System.err.println("线程结束");
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//共享资源
class ShareData extends Thread{
	private int i = 3;
	@Override
	public void run() {
		i--;
		System.out.println(i);
	}
}
