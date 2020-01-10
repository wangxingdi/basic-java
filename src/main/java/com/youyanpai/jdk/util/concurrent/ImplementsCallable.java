package com.youyanpai.jdk.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 1. 实现Callable接口,重写call();
 * 2. 作为参数传入FutureTask的构造函数中;
 * 3. 再作为参数传入Thread的构造函数中.
 * @author wangxd
 */
public class ImplementsCallable {

	public static void main(String[] args) throws Exception {
		Callable<Integer> c1 = new A(1, 100);
		FutureTask<Integer> f1 = new FutureTask<Integer>(c1);
		new Thread(f1).start();
		System.out.println(f1.get());
	}
}

class A implements Callable<Integer> {
	
	private int min;
	private int max;
	
	public A(int min, int max){
		this.min = min;
		this.max = max;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i=min;i<max;i++) {
			sum += i;
		}
		System.out.println(sum);
		return sum;
	}
	
}
