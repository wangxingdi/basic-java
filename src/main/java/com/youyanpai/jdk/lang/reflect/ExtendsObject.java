package com.youyanpai.jdk.lang.reflect;

public abstract class ExtendsObject {
	
	public String extendId;
	
	private String extendName;
	
	public abstract void extendMethod();
	
	public void test() {
		System.out.println(extendName);
	}

}
