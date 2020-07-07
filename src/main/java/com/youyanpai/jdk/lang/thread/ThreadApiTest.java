package com.youyanpai.jdk.lang.thread;

public class ThreadApiTest {

	public static void main(String[] args) throws InterruptedException {
		
		A a = new A();
		a.start();
		a.join();
		A a1 = new A();
		a1.setDaemon(true);
		a1.start();
		System.out.println(Thread.activeCount());
		Thread.currentThread();
		Thread.currentThread().getContextClassLoader();
		Thread.currentThread().getId();
		a1.setName("嘿嘿");
		System.out.println(a1.getName());
		a1.setPriority(6);
		System.out.println(Thread.currentThread().getPriority());
		Thread.currentThread().getThreadGroup();
		Thread.currentThread().isAlive();
		a1.isDaemon();
		a1.isInterrupted();
		a1.isAlive();
		a1.join();
		a1.sleep(1000);
		a1.yield();
		System.out.println("程序结束");
	}
	
	static class A extends Thread{
		@Override
		public void run(){
			System.out.println("getThreadGroup:"+Thread.currentThread().getThreadGroup());
			Thread.currentThread().interrupt();
			System.out.println("第一次interrupted："+Thread.currentThread().interrupted());
			System.out.println("第二次interrupted："+Thread.currentThread().interrupted());
		}
	}
}
