package com.youyanpai.jdk.lang._class;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeMethod {

	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = SampleClass.class.getMethods();
		SampleClass sampleObject = new SampleClass();
		methods[1].invoke(sampleObject, "data");
		System.out.println(methods[0].invoke(sampleObject));
	}
}

class SampleClass {
	private String sampleField;

	public String getSampleField() {
		return sampleField;
	}

	public void setSampleField(String sampleField) {
		System.out.println("main方法中的invoke()将会唤醒对应的方法,也就是此方法");
		this.sampleField = sampleField;
	}
}
