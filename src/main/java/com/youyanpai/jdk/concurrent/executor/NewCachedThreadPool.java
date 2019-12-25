package com.youyanpai.jdk.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPool {
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i=0;i<5;i++) {
			es.execute(new Thread4Pools());
		}
	}

}
