package com.daiyuma.jdk.concurrent.executor;

public class Thread4Pools implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(100);
			System.out.println("当前线程id："+this.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
