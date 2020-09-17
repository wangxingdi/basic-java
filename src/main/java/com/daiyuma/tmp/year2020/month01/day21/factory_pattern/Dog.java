package com.daiyuma.tmp.year2020.month01.day21.factory_pattern;

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
