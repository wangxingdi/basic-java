package com.youyanpai.tmp.day_20200121.factory_pattern;

public class CatFactory implements Factory{

	@Override
	public Animal getAnimal() {
		return new Cat();
	}

}
