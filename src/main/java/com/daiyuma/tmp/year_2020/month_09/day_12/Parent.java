package com.daiyuma.tmp.year_2020.month_09.day_12;

/**
 * Son继承Parent，同时两个类里面都有相同的方法
 * 如果在父类中调用父类或者子类的方法，最终都是调用子类的方法
 */
public class Parent {

    public Parent(){
        method();
    }

    public void method(){
        System.out.println("this is Parent method");
    }

    public static void main(String[] args) {
        new Parent();
    }
}
