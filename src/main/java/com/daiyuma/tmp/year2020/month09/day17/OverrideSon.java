package com.daiyuma.tmp.year2020.month09.day17;

public class OverrideSon extends OverrideParent {
    public static void main(String[] args) {
        //父类引用指向子类对象
        OverrideParent son = new OverrideSon();
        //发生重写，调用子类方法
        son.method();
        //非重写，调用父类方法
        son.staticMethod();
    }
    public void method(){
        System.out.println("Son method is invoked");
    }
    //方法返回值不同，下面的重写方法会编译报错
//    public int noReturnMethod(){ }

    //缩小方法的访问范围，下面的重写方法会编译报错
//    private int protectedReturnIntMethod(int i){
//        return i;
//    }

    //扩大了抛出的异常，下面的重写方法会编译报错
//    public void throwsIOException() throws Exception{ }

    public static void staticMethod(){
        System.out.println("son staticMethod is invoked");
    }
}
