package com.daiyuma.tmp.year2020.month08.day25;

public abstract class Parent {

    public final void acquire(int arg) {
        if (tryAcquire(arg))
            System.out.println("Parent - acquire");
    }

    protected boolean tryAcquire(int arg) {
        throw new UnsupportedOperationException();
    }

}
