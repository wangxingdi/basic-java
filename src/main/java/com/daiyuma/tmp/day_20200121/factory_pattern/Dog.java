package com.daiyuma.tmp.day_20200121.factory_pattern;

public class Dog implements Animal {
	
	private int age;
	
    @Override
    public void eat() {
    	System.out.println("dog is eating");
    }

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
