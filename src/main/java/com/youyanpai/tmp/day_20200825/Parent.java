package com.youyanpai.tmp.day_20200825;

public abstract class Parent {

    public final void acquire(int arg) {
        if (tryAcquire(arg))
            System.out.println("Parent - acquire");
    }

    protected boolean tryAcquire(int arg) {
        throw new UnsupportedOperationException();
    }

}
