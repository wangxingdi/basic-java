/**
 * from www.youyanpai.com
 */
package com.daiyuma.designpattern.creational.singleton;

/**
 * 单例模式
 * 1. 懒汉式
 * 2. 非线程安全
 * 程序执行到getInstance()栈帧时(线程私有),静态变量instance存在于JVM中的方法区(线程共享);
 * 当多个线程同时执行null==instance时,那么多个线程会分别创建一个新的instance实例.
 * @author wangxd
 */
public class LazySingleton {
	
	public static void main(String[] args) {
		System.out.println(LazySingleton.getInstance());
	}
	
	private LazySingleton(){}
	
	private static LazySingleton instance = null;
	
	public static LazySingleton getInstance(){
		if(null==instance){
			instance = new LazySingleton();
		}
		return instance;
	}

}
