package com.daiyuma.tmp.year2020.month09.day17;

/**
 * 这个类会测试重载的一系列问题
 * 1. 重载必须发生在同一个类中的同一个方法；
 * 2. 重载方法参数类型，参数顺序，参数数量不同；
 * 3. 返回值是否相同不属于重载的范畴内，如果两个方法仅仅返回值不相同，会编译报错；
 * 4. 参数名是否相同也不在重载的考虑范畴内，如果两个方法仅仅参数名不相同，会编译报错；
 */
public class Overload {
    public static void main(String[] args) {
        Overload a = new Overload();
        int c = a.methoda(1);
        int d = a.methoda(1,2);
    }

    public int methoda(int a){
        System.out.println("methoda:"+a);
        return a;
    }

    public int methoda(int b, int c){
        System.out.println("methoda:"+b);
        return b;
    }

}
