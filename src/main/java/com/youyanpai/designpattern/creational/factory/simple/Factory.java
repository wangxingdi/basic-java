package com.youyanpai.designpattern.creational.factory.simple;

/**
 * 简单工厂类
 * 缺点:
 * 	1. 创建逻辑集中于工厂类,容易造成此类职能过于复杂;
 * 	2. 违反开闭原则,对于新增一种产品无能为力.
 * @author wangxd
 */
public class Factory {
	
	public void getFood(String type){
		switch (type) {
		case "1":
			new BreadImpl().createFood();
			break;
		case "2":
			new RiceImpl().createFood();
			break;
		default:
			break;
		}
	}

}
