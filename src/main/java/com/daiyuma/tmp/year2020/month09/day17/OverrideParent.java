package com.daiyuma.tmp.year2020.month09.day17;

import java.io.File;
import java.io.IOException;

public class OverrideParent {

    public void method(){
        System.out.println("Parent method is invoked");
    }

    public void noReturnMethod(){
        System.out.println("noReturnMethod is invoked");
    }

    public int returnIntMethod(int i){
        System.out.println("returnIntMethod is invoked");
        return i;
    }

    protected int protectedReturnIntMethod(int i){
        System.out.println("protectedReturnIntMethod is invoked");
        return i;
    }

    public void throwsIOExceptionMethod() throws IOException {
        System.out.println("throwsIOExceptionMethod is invoked");
    }

    public static void staticMethod(){
        System.out.println("parent staticMethod is invoked");
    }
}
