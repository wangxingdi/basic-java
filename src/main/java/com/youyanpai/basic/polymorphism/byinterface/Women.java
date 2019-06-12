package com.youyanpai.basic.polymorphism.byinterface;

/**
 * 女人
 * @author wangxd
 */
public class Women implements People{

	@Override
	public void init() {
		System.out.println("初始化了一个女人");
	}
}
