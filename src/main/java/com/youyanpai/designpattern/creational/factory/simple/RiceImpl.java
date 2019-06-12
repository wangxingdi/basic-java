package com.youyanpai.designpattern.creational.factory.simple;

/**
 * 大米实现类
 * @author wangxd
 */
public class RiceImpl implements IFood {

	@Override
	public void createFood() {
		System.out.println("大米饭已出炉");
	}

}
