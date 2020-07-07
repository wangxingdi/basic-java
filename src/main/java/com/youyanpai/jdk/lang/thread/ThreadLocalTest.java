package com.youyanpai.jdk.lang.thread;

public class ThreadLocalTest {
	
	static ThreadLocal<String> local = new ThreadLocal<String>();

	public static void main(String[] args) throws InterruptedException {
		A a = new A();
		new Thread(a).start();
		local.set("main");
		System.out.println("main的get():"+local.get());
//		local.remove();
	}
	
	static class A implements Runnable{
		@Override
		public void run() {
			System.out.println("A先get():"+local.get());
			local.set("a");
			System.out.println("A再get():"+local.get());
		}
	}

}
