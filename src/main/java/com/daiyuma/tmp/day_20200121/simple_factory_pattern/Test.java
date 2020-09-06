package com.daiyuma.tmp.day_20200121.simple_factory_pattern;

public class Test {

	public static void main(String[] args) {
		//狗吃东西
    	Animal dog = Factory.getAnimal("dog");
        dog.eat();
        //猫吃东西
        Animal cat = Factory.getAnimal("cat");
        cat.eat();
	}

}
