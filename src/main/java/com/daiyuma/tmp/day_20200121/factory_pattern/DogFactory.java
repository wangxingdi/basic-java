package com.daiyuma.tmp.day_20200121.factory_pattern;

public class DogFactory implements Factory{

	@Override
	public Animal getAnimal() {
		return new Dog();
	}

}
