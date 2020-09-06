/**
 * from www.youyanpai.com
 */
package com.daiyuma.designpattern.creational.singleton;

/**
 * 单例模式
 * 1. 饿汉式
 * 2. 线程安全
 * 静态变量会随着类的加载而加载,只会加载一次.
 * @author wangxd
 */
public class HungrySingleton {

	private HungrySingleton(){}
	
	private static HungrySingleton instance = new HungrySingleton();
	
	public static void main(String[] args) {
		System.out.println(HungrySingleton.getInstance());
	}
	
	public static HungrySingleton getInstance(){
		return instance;
	}

}
