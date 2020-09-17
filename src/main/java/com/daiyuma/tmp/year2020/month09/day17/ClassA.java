package com.daiyuma.tmp.year2020.month09.day17;

public class ClassA {
    public static void main(String[] args) {
        ClassA a = new ClassA();
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
