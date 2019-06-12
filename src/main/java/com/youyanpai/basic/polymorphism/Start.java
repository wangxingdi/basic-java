package com.youyanpai.basic.polymorphism;

import com.youyanpai.basic.polymorphism.byabstract.Animal;
import com.youyanpai.basic.polymorphism.byabstract.Cat;
import com.youyanpai.basic.polymorphism.byabstract.Dog;
import com.youyanpai.basic.polymorphism.byinterface.Men;
import com.youyanpai.basic.polymorphism.byinterface.People;
import com.youyanpai.basic.polymorphism.byinterface.Women;
import com.youyanpai.basic.polymorphism.senior.Father;
import com.youyanpai.basic.polymorphism.senior.Son;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 这个包主要是对于多态的总结
 * 一. 实现多态的条件
 *     1. 继承;  2.重载;  3.父类的引用指向子类对象(向上类型转换).
 * 二. 实现多态的形式
 *     1. 继承抽象类;  2.实现接口
 * 三. 方法优先级
 *     继承链中方法调用的优先级为：this.show(O),super.show(O),this.show((super)O),super.show((super)O).
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 多态形式的描述:
 * 1. 继承抽象类实现多态;
 * 2. 实现接口实现多态;
 * 3. 与方法执行优先级有关的多态;
 * @author wangxd
 */
public class Start {

	public static void main(String[] args) {
		//继承抽象类
		Animal d = new Dog();
		d.eat();
		Animal c = new Cat();
		c.eat();
		
		//实现接口
		People m = new Men();
		m.init();
		People w = new Women();
		w.init();
		
		//高级,这里我还存在疑问
		Father father = new Father();
		Father son = new Son();
		father.playWith(father);
		//注意这个方法的输出为什么不是"父亲和儿子一起玩游戏"
		father.playWith(son);
		son.playWith(father);
		//注意这个方法的输出为什么不是"儿子自己玩游戏"
		son.playWith(son);
	}

}
