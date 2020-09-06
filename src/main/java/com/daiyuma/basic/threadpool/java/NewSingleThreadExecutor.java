package com.daiyuma.basic.threadpool.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程线程池
 * @author wangxd
 */
public class NewSingleThreadExecutor {

	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		//不管有多少循环,数字必定按照从小到大顺序输出
		for(int i=0;i<50;i++){
			final int index = i;
			service.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(index);
				}
			});
		}
		service.shutdown();
	}

}
