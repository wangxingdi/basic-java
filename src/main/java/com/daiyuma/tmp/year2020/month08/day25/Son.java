package com.daiyuma.tmp.year2020.month08.day25;

public class Son {

    private static transient volatile Node head;

    private static transient volatile Node tail;

    public static void main(String[] args) {
        P p = new P();
        p.acquire(1);
        System.out.println(null==p);
        System.out.println(hasQueuedPredecessors());
    }

    public static final boolean hasQueuedPredecessors() {
        // The correctness of this depends on head being initialized
        // before tail and on head.next being accurate if the current
        // thread is first in queue.
        Node t = tail; // Read fields in reverse initialization order
        Node h = head;
        Node s;
        return (h != t);
    }

    private final P p;

    static class P extends Parent {
        protected final boolean tryAcquire(int acquires) {
            System.out.println("Son - tryAcquire");
            return true;
        }
    }

    public Son() {
        p = new P();
    }

    static final class Node {
        Node() {
        }
    }
}
