package com.daiyuma.tmp.day_20200819;

/**
 * -XX:+PrintStringTableStatistics
 */
public class StringPool {
//    public static String ss = "gg";
    public static void main(String[] args) {
        final String str1 = "hello";
        String s = "aaa" + str1;
//        String s1 = new String("sss");
//        String s2 = new String("s") + new String("ss");
//        System.out.println(s1);
        System.out.println(s);
    }
}
