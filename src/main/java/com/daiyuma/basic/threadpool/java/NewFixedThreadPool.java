package com.daiyuma.basic.threadpool.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定长度线程池,超过长度的线程在队列中等待
 * @author wangxd
 */
public class NewFixedThreadPool {

	/**
	 * 线程池大小设置为3,每个线程一旦启动就休眠5秒,所以5秒内最多会有3个线程可以获得时间片
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(int i=0;i<10;i++){
			final int index = i;
			service.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(index);
					try {
			        	Thread.sleep(5000);
			        } catch (InterruptedException e) {
			        	e.printStackTrace();
			        }
				}
			});
		}
		service.shutdown();
	}
}
