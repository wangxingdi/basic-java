package com.daiyuma.tmp.year2020.month01.day21.simple_factory_pattern;

public class Factory {
	public static Animal getAnimal(String type) {
        Animal a = null;
        switch (type) {
            case "dog":
            	a = new Dog();
            	break;
            case "cat":
                a = new Cat();
                break;
            default:
                a = null;
                break;
        }
        return a;
    }
}
