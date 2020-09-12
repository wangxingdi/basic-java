package com.daiyuma.tmp.year_2020.month_08.day_25;

public abstract class Parent {

    public final void acquire(int arg) {
        if (tryAcquire(arg))
            System.out.println("Parent - acquire");
    }

    protected boolean tryAcquire(int arg) {
        throw new UnsupportedOperationException();
    }

}
