package com.daiyuma.tmp.year2020.month09.day12;

/**
 * Son继承Parent，同时两个类里面都有相同的方法
 * 如果在子类中调用父类或者子类的方法，最终都是调用子类的方法
 */
public class Son extends Parent {
    public Son(){
        System.out.println("Son构造函数");
        method();
    }

    public void method(){
        System.out.println("this is Son method");
    }

    public static void main(String[] args) {
        new Son();
    }
}
