package com.youyanpai.tmp.day_20200121.factory_pattern;

public class Test {

	public static void main(String[] args) {
		Factory f1 = new DogFactory();
		Animal dog = f1.getAnimal();
		dog.eat();
	}

}
