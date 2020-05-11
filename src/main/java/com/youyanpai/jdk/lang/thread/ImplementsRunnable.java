package com.youyanpai.jdk.lang.thread;

/**
 * 1. 采用实现接口的方式实现线程,必须要重写run();
 * 2. 使用new Thread(Runnable r).start()方式开启线程, r就是当前类;
 * @author wangxd
 */
public class ImplementsRunnable implements Runnable {
	
	@Override
	public void run() {
		System.out.println("执行了run()");
	}
	
	public static void main(String[] args) {
		new Thread(new ImplementsRunnable()).start();
	}

}
