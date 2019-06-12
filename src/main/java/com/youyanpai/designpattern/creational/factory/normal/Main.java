package com.youyanpai.designpattern.creational.factory.normal;

/**
 * 主函数入口
 * @author wangxd
 */
public class Main {

	public static void main(String[] args) {
		Factory food = new FoodFactory();
		//创建主食
		food.create();
		Factory juice = new DrinkFactory();
		//创建饮料
		juice.create();
	}

}
