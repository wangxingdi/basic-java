package com.daiyuma.jdk.lang.object;

/**
 *
 */
public class Clone {

    static Object object = new Object();
    static Clone clone = new Clone();

    public static void main(String[] args) {
        //不管是什么对象,都无法调用clone方法
//        object.clone();
//        clone.clone();
    }
}
