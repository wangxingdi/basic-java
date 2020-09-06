package com.daiyuma.jdk.lang._class;

public class InvokeMethods {
	
	public void method1() {
		System.out.println("public类型,无参数,method1()");
	}
	
	private void method2() {
		System.out.println("private类型,无参数,method2()");
	}
	
	public void method3(String param) {
		System.out.println("public类型,一个参数,method3(String param)");
	}
	
	private void method4(String param) {
		System.out.println("private类型,一个参数,method4(String param)");
	}
	
	protected void method5() {
		System.out.println("protected类型,无参数,method5()");
	}
	
	void method6() {
		System.out.println("无修饰符, 无参数,method6()");
	}

}
