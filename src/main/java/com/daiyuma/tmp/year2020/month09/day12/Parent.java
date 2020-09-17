package com.daiyuma.tmp.year2020.month09.day12;

/**
 * Son继承Parent，同时两个类里面都有相同的方法
 * 如果在父类中调用父类或者子类的方法，最终都是调用子类的方法
 */
public class Parent {

    public Parent(){
        System.out.println("Parent构造函数");
        method();
    }

    public void method(){
        System.out.println("this is Parent method");
    }

    public static void main(String[] args) {
        System.out.println("===new Parent()===");
        /**
         * 1. 先执行Parent构造方法
         * 2. 然后再执行method()方法
         */
        new Parent();
        System.out.println("===new Son()===");
        /**
         * 1. 先执行Parent构造方法
         * 2. 然后再执行Son.method()
         * 3. 然后在执行Son构造方法
         * 4. 最后执行Son.method()
         */
        new Son();
    }
}
