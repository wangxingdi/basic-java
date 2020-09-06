package com.daiyuma.basic.polymorphism.byinterface;

/**
 * 男人
 * @author wangxd
 */
public class Men implements People{

	@Override
	public void init() {
		System.out.println("初始化了一个男人");
	}
}
