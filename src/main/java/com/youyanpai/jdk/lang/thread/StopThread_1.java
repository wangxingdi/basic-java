package com.youyanpai.jdk.lang.thread;

public class StopThread_1 extends Thread {
	
	volatile boolean flag = true;
	
	public static void main(String[] args) throws InterruptedException {
		StopThread_1 s = new StopThread_1();
		System.out.println("线程开始启动......");
		s.start();
		s.sleep(5000);
		s.flag = false;
		System.out.println("main application已结束！");
	}
	
	public void run () {
		int i = 0;
		while(flag) {
			System.out.println(this.getName() + ": is running .......");
			try {
                Thread.sleep(1000); //设置休眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + "：count = " + i++);
		}
		System.out.println(this.getName() + "：线程已结束！");
	}
	

}
