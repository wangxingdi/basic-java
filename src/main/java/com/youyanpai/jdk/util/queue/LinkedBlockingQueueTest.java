package com.youyanpai.jdk.util.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 
 * ================================================
 * 1. 向队列中增加和删除有问题需要处理
 * ================================================
 * @author wangxd
 *
 */
public class LinkedBlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		test();
	}

	static class Basket {
		BlockingQueue<String> basket = new LinkedBlockingQueue<String>(3);

		public void add() {
			basket.offer("An Apple");
			System.out.println("add a apple");
		}

		public void remove() throws InterruptedException {
			basket.poll();
			System.out.println("remove a apple");
		};
	}

	public static void test() throws InterruptedException {
		System.out.println("start");
		Basket basket = new Basket();

		class Producer implements Runnable {
			boolean a = true;
			@Override
			public void run() {
				while (a) {
					basket.add();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		class Consumer implements Runnable {
			boolean a = true;
			@Override
			public void run() {
				while (a) {
					try {
						basket.remove();
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						System.out.println("Consumer异常");
						e.printStackTrace();
					}
				}
			}
		}
		ExecutorService service = Executors.newFixedThreadPool(2);
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		service.submit(producer);
		service.submit(consumer);
		service.shutdown();

		try {
			if (!service.awaitTermination(5, TimeUnit.SECONDS)) {
				producer.a = false;
				consumer.a = false;
				service.shutdownNow();
				System.out.println("end");
			}
		} catch (Exception e) {
			service.shutdownNow();
		}
	}

}
