package com.daiyuma.designpattern.creational.factory.normal;

/**
 * 饮料工厂类
 * @author wangxd
 */
public class DrinkFactory extends Factory{

	@Override
	void create() {
		new Juice();
	}

}
