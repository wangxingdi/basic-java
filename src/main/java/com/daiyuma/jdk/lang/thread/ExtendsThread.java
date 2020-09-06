package com.daiyuma.jdk.lang.thread;

/**
 * 1. 采用继承的方式实现线程,可以不重写run();
 * 2. 使用当前类的start()开启线程;
 * @author wangxd
 */
public class ExtendsThread extends Thread {
	
	public void run() {
		System.out.println("执行了线程中的run()");
	}

	public static void main(String[] args) {
		new ExtendsThread().start();
	}
}
