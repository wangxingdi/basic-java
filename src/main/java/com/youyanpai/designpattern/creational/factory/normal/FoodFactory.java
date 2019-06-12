package com.youyanpai.designpattern.creational.factory.normal;

/**
 * 主食工厂类
 * @author wangxd
 */
public class FoodFactory extends Factory{

	@Override
	void create() {
		new Bread();
	}

}
