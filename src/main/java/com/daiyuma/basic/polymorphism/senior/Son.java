package com.daiyuma.basic.polymorphism.senior;

/**
 * 儿子类
 * @author wangxd
 */
public class Son extends Father{

	@Override
	public void playWith(Son son) {
		System.out.println("儿子自己玩游戏");
	}
	
	@Override
	public void playWith(Father father){
		System.out.println("儿子和父亲一起玩游戏");
	}
}
