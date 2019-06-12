/**
 * from www.youyanpai.com
 */
package com.youyanpai.designpattern.creational.singleton;

/**
 * 单例模式
 * 1. 懒汉式
 * 2. 线程安全
 * 3. 执行效率较差
 * @author wangxd
 */
public class LazySingletonPlus {

	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getInstance());
	}
	
	private LazySingletonPlus(){}
	
	private static LazySingletonPlus instance = null;
	
	private static Object syncObj = new Object();
	
	public static LazySingletonPlus getInstance(){
		synchronized (syncObj) {
			if(null==instance){
				instance = new LazySingletonPlus();
			}
		}
		return instance;
	}

}
