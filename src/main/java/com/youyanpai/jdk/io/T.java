package com.youyanpai.jdk.io;

import java.util.Random;

public class T {

	public static void main(String[] args) {
		//jdk8的新特性尝试
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		//判断-0和0是否相等
		System.out.println(-0.0 == 0.0);
	}

}
