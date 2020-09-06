package com.daiyuma.basic.threadpool.java;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定长线程池,支持定时和周期性任务
 * @author wangxd
 */
public class NewScheduledThreadPool {

	public static void main(String[] args) {
		System.out.println("程序开始---");
		ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
		//延迟:延迟5秒后执行
		service.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程执行完毕");
			}
		}, 5, TimeUnit.SECONDS);
		//周期:10秒后每3秒执行一次
		service.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程执行一次");
			}
		}, 10, 3, TimeUnit.SECONDS);
		
		service.shutdown();
	}

}
