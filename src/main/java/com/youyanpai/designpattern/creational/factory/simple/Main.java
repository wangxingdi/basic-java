package com.youyanpai.designpattern.creational.factory.simple;

public class Main {

	/**
	 * 主函数
	 * @param args
	 */
	public static void main(String[] args) {
		Factory factory = new Factory();
		factory.getFood("1");
		factory.getFood("2");
	}
}
