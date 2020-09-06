package com.daiyuma.tmp.day_20200121.factory_pattern;

public class Test {

	public static void main(String[] args) {
//		Factory f1 = new DogFactory();
//		Animal dog = f1.getAnimal();
//		dog.eat();
		
		Dog a = new Dog();
		a.setAge(12);
		Dog b = a;
		b.setAge(13);
		System.out.println(a.getAge());
		System.out.println(b.getAge());
	}

}
