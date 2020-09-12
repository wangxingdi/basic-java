package com.daiyuma.tmp.year_2020.month_01.day_21.factory_pattern;

public class DogFactory implements Factory {

	@Override
	public Animal getAnimal() {
		return new Dog();
	}

}
