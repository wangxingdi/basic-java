package com.daiyuma.jdk.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPool {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		for (int i=0;i<5;i++) {
			es.execute(new Thread4Pools());
		}
	}

}
