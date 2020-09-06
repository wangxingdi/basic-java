package com.daiyuma.jdk.lang.reflect;

public class TargetObject implements ImplementsObject{

	public String id;
	
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void public_test() {
		System.out.println("一个public测试方式");
	}

	@Override
	public void implementMethod() {
		// TODO Auto-generated method stub
		
	}

}
