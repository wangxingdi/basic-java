package com.daiyuma.tmp.year_2020.month_09.day_07;

public class _Object implements Cloneable{
    public static void main(String[] args) throws Exception {
        _Object o1 = new _Object();
        _Object o2 = new _Object();
        System.out.println(o1==o2);
        //Object的equals方法，当且仅当o1和o2指向同一个对象时，才返回true；否则返回false
        System.out.println(o1.equals(o2));
        Object o3 = o1.clone();
        System.out.println(o1==o3);
        System.out.println(o1.equals(o3));
        Integer a = 3;
    }
}
