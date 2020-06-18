/**
 * 
 */
package com.youyanpai.designpattern.creational.singleton;

/**
 * 单例模式
 * 1. 懒汉式
 * 2. 线程安全
 * 3. 执行效率尚可
 * @author wangxd
 */
public class LazySingletonPlusPlus {

	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getInstance());
	}
	
	private static LazySingletonPlusPlus instance = null;

	private static LazySingletonPlusPlus getInstance() {
		if(null==instance){
			synchronized (LazySingletonPlusPlus.class) {
				if(null==instance){
					instance = new LazySingletonPlusPlus();
				}
			}
		}
		return instance;
	}

}
