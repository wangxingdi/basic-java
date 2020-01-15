package com.youyanpai.jdk.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectMain {

	public static void main(String[] args) {
		reflect(new TargetObject());
	}
	
	public static void reflect(TargetObject obj) {
		//返回调用类所声明的public字段,包括超类也包括超接口
		Field[] fields = obj.getClass().getFields();
		System.out.println(fields);
		//返回调用类所声明的所有字段,但不包括超类和超接口中继承的字段
		Field[] declaredField = obj.getClass().getDeclaredFields();
		System.out.println(declaredField);
		//
		Method[] methods = obj.getClass().getMethods();
		System.out.println(methods);
		//
		Method[] declaredMethods = obj.getClass().getDeclaredMethods();
		System.out.println(declaredMethods);
		//
		Constructor<?>[] constructors = obj.getClass().getConstructors();
		System.out.println(constructors);
		//
		Constructor<?>[] declaredConstructors = obj.getClass().getDeclaredConstructors();
		System.out.println(declaredConstructors);
	}

}
