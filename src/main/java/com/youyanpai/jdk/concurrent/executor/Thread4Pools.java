package com.youyanpai.jdk.concurrent.executor;

public class Thread4Pools implements Runnable {

	@Override
	public void run() {
		System.out.println("处理线程");
		try {
			Thread.sleep(100);
			System.out.println("当前线程id："+this.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
