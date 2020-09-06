package com.daiyuma.designpattern.creational.factory.simple;

/**
 * 面包实现类
 * @author wangxd
 */
public class BreadImpl implements IFood {

	@Override
	public void createFood() {
		System.out.println("烤面包已经出炉");
	}

}
