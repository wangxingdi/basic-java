package com.daiyuma.jdk.io;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerT {

	public static void main(String[] args) {
		AtomicInteger a = new AtomicInteger();
		System.out.println(a.getAndSet(2));
		System.out.println(a.getAndSet(4));
	}

}
