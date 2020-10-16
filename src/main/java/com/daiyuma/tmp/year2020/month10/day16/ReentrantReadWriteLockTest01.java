package com.daiyuma.tmp.year2020.month10.day16;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁互斥
 * 读读锁并发
 * 读锁不支持条件newCondition()
 * 读写锁支持降级重入
 */
public class ReentrantReadWriteLockTest01 {

    public static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    public static Lock rl = rwl.readLock();
    public static Lock wl = rwl.writeLock();

    public static void main(String[] args) throws InterruptedException {

        /**
         * 写锁
         */
        new Thread(()->{
            try {
                wl.lock();
                System.out.println("write_lock get");
                for(int i=0;i<5;i++){
                    method("write locking");
                }
                System.out.println("write_lock release");
            }catch (Exception e){

            }finally{
                wl.unlock();
            }
        }, "write_lock").start();

        /**
         * 读锁01
         */
        new Thread(()->{
            try {
                rl.lock();
                System.out.println("read_lock_01 get");
                for(int i=0;i<5;i++){
                    method(Thread.currentThread().getName());
                }
                System.out.println("read_lock_01 release");
            }catch (Exception e){

            }finally{
                rl.unlock();
            }
        },"read_lock_01").start();

        /**
         * 读锁02
         */
        new Thread(()->{
            try {
                rl.lock();
                System.out.println("read_lock_02 get");
                for(int i=0;i<5;i++){
                    method(Thread.currentThread().getName());
                }
                System.out.println("read_lock_02 release");
            }catch (Exception e){

            }finally{
                rl.unlock();
            }
        },"read_lock_02").start();

        TimeUnit.SECONDS.sleep(15);

        /**
         * 写锁内嵌读锁
         */
        new Thread(()->{
            wl.lock();
            System.out.println("write lock get, then read want get lock");
            rl.lock();
            System.out.println("read lock get");
            rl.unlock();
            wl.unlock();
        }).start();

        /**
         * 读锁内嵌写锁，程序卡死
         */
        new Thread(()->{
            rl.lock();
            System.out.println("read lock get, then write want get lock");
            wl.lock();
            System.out.println("write lock get");
            wl.unlock();
            rl.unlock();
        }).start();

    }

    public static void method(String s) throws InterruptedException {
        System.out.println("method: " + s);
        TimeUnit.SECONDS.sleep(1);
    }

}
