package com.daiyuma.jdk.lang._class;

import java.lang.reflect.Method;

/**
 * 1. getMethods()获取的是全部的包含父类中的public类型方法;
 * 2. getMethods()和getDeclaredMethods()获取的方法顺序并不固定;
 * 3. getDeclaredMethods()获取的是所属类中声明的方法,不包含父类;
 * 4. 
 * @author wangxd
 */
public class InvokeMethod_2 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> c = Class.forName("com.daiyuma.jdk.lang._class.InvokeMethods");
		
		System.out.println("= = = = = = =获取所有public方法= = = = = = = =");
		Method[] methods = c.getMethods();
		for (int i=0;i<methods.length;i++) {
            System.out.println("公共方法"+i+":"+methods[i]);
        }
		
		System.out.println("= = = = = = =获取所有方法= = = = = = = =");
		Method[] declaredMethods = c.getDeclaredMethods();
		for (int i=0;i<declaredMethods.length;i++) {
            System.out.println("方法"+i+":"+declaredMethods[i]);
        }
		
		System.out.println("= = = = = = =获取特定带参的方法= = = = = = = =");
		Method methodWithParam = c.getMethod("method3", String.class);
		System.out.println(methodWithParam);
		
		System.out.println("= = = = = = =获取特定不带参的方法= = = = = = = =");
		Method methodWithoutParam = c.getMethod("method1");
		System.out.println(methodWithoutParam);
	}

}
