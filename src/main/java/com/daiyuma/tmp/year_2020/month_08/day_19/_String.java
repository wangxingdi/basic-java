package com.daiyuma.tmp.year_2020.month_08.day_19;

public class _String {

    public static void main(String[] args) {
        System.out.println("===01===");
        //形式1
        String s1 = "abc";
        //形式2
        String s2 = "a" + "b" + "c";
        System.out.println(s1 == s2);
        String s3 = new String("abc");

        System.out.println("===02===");
        String s4 = new String("1") + new String("1");
        s4.intern();
        String s5 = "11";
        System.out.println(s4 == s5);

        String s6 = new String("111");
        s6.intern();
        String s7 = "111";
        System.out.println(s6==s7);

        System.out.println("===03===");
        String s8 = "bc";
        String s9 = s8 + "d";
        String s10 = "bcd";
        System.out.println(s9==s10);

        System.out.println("===04===");
        String s11 = "m";
        String s12 = "n";
        String s13 = s11 + s12;
        String s14 = "mn";
        System.out.println(s13==s14);

        System.out.println("===05===");
        String s15 = new String("xyz");
        String s16 = "xyz";
        System.out.println(s15==s15.intern());
    }
}
