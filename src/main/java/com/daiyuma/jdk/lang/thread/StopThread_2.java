package com.daiyuma.jdk.lang.thread;

public class StopThread_2 extends Thread {

	public static void main(String[] args) throws InterruptedException {
		StopThread_2 thread = new StopThread_2();
		thread.start();
		thread.sleep(100);
        thread.interrupt(); //打上标记
        System.out.println("main结束");
	}
	
	public void run() {
		for(int i =0 ;i<50000;i++){
			System.out.println(this.interrupted());
            if(this.interrupted()){
                System.out.println("run停止======================================");
                break;
            }
            System.out.println("i="+(i+1));
        }
	}

}
