package com.youyanpai.basic.polymorphism.senior;

/**
 * 父亲类
 * @author wangxd
 */
public class Father {
	
	public void playWith(Father father){
		System.out.println("父亲自己玩游戏");
	}
	
	public void playWith(Son son){
		System.out.println("父亲和儿子一起玩游戏");
	}

}
