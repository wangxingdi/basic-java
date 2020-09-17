package com.daiyuma.tmp.year2020.month01.day21.factory_pattern;

public class DogFactory implements Factory {

	@Override
	public Animal getAnimal() {
		return new Dog();
	}

}
