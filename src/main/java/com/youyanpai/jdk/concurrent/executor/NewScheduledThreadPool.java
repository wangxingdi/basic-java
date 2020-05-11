package com.youyanpai.jdk.concurrent.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPool {

	public static void main(String[] args) {
		ScheduledExecutorService es = Executors.newScheduledThreadPool(2);
		for (int i=0;i<5;i++) {
			es.schedule(new Thread4Pools(), 4, TimeUnit.SECONDS);
//			es.scheduleAtFixedRate(new Thread4Pools(), 3, 5, TimeUnit.SECONDS);
//			es.scheduleWithFixedDelay(new Thread4Pools(), 3, 5, TimeUnit.SECONDS);
		}
	}

}
