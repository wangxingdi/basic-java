package com.youyanpai.jdk.util.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * ================================================
 * 1. 阻塞型队列,在队列满之后,会阻塞;
 * ================================================
 * @author wangxd
 *
 */
public class BlockingQueueTest {

	public static void main(String[] args) {
		test();
	}

	static class Basket {
		BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);

		public void add() {
			basket.add("An Apple");
			System.out.println("add了一个苹果");
		}

		public void remove() throws InterruptedException {
			basket.take();
			System.out.println("remove了一个苹果");
		};
	}

	public static void test() {
		Basket basket = new Basket();

		class Producer implements Runnable {
			@Override
			public void run() {
				while (true) {
					basket.add();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		class Consumer implements Runnable {
			@Override
			public void run() {
				try {
					while (true) {
//						basket.remove();
						Thread.sleep(300);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		ExecutorService service = Executors.newCachedThreadPool();
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		service.submit(producer);
		service.submit(consumer);
		// 程序运行10s后，所有任务停止
		try {
			System.out.println("开始");
			Thread.sleep(10000);
			System.out.println("结束");
		} catch (InterruptedException e) {
		}
		service.shutdownNow();
	}

}
