package com.daiyuma.designpattern.creational.factory.normal;

/**
 * 抽象工厂类
 * 1. 将主食和饮料两种产品分割,以免造成职责过于复杂;
 * 2. 如果需要创建一个新的产品类型:比如"衣服",则不需要修改抽象工厂类,只需要新增"衣服工厂类"并且继承抽象工厂类即可,
 *    符合开闭原则.
 * @author wangxd
 */
public abstract class Factory {
	
	/**
	 * 创建
	 */
	abstract void create();

}
