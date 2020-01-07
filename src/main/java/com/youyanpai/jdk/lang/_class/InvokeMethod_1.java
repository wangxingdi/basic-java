package com.youyanpai.jdk.lang._class;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试invoke();
 * 低等级
 * @author wangxd
 */
public class InvokeMethod_1 {

	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		SampleClass c1 = new SampleClass();
		Method method = SampleClass.class.getMethod("setSampleField", String.class);
		method.invoke(c1, "gg");
		
		SampleClass c2 = new SampleClass();
		Method[] methods = SampleClass.class.getMethods();
		methods[0].invoke(c2, "data");
	}
}

class SampleClass {
	private String sampleField;

	public String getSampleField() {
		return sampleField;
	}

	public void setSampleField(String sampleField) {
		System.out.println("main方法中的invoke()将会唤醒对应的方法,也就是此方法");
		System.out.println("入参是："+sampleField);
		this.sampleField = sampleField;
	}
}
