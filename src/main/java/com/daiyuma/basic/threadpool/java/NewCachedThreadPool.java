package com.daiyuma.basic.threadpool.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可缓存线程池, 线程池长度超过需要就回收空闲线程, 若没有资源可回收, 则新建线程
 * @author wangxd
 */
public class NewCachedThreadPool {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 50; i++) {
	        final int index = i;
	        service.execute(new Runnable(){
				@Override
				public void run() {
					System.out.println(index);
//			        try {
//		        	Thread.sleep(index * 5);
//		        } catch (InterruptedException e) {
//		            e.printStackTrace();
//		        }
				}
			});
		}
		service.shutdown();
	}

}
