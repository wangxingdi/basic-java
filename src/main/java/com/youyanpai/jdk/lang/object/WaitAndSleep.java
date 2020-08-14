package com.youyanpai.jdk.lang.object;

import java.util.stream.Stream;

/**
 * wait方法和sleep方法的作用和不同
 * 相同：1.都可以暂停一个线程。
 * 不同：1.wait是Object中的方法；sleep是Thread中的方法。
 * 2.wait会释放锁；sleep方法不会释放锁。
 * 3.sleep必须指定休眠时间，并自动恢复；wait在不指定休眠时间的情况下，必须由其他线程唤醒。
 * 4.wait方法所在的线程，必须拥有调用对象的monitor(通过synchrozied获取)；sleep不是必需的。
 */
public class WaitAndSleep {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Stream.of("线程1","线程2").forEach(n -> {
            new Thread(n) {
                public void run(){
                    try {
                        waitWhetherReleaseLock();
                        sleepWhetherReleaseLock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        });
    }

    private static void sleepWhetherReleaseLock() throws InterruptedException {
        synchronized(lock){
            System.out.println(Thread.currentThread().getName()+"正在执行");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+"执行结束");
        }
    }

    private static void waitWhetherReleaseLock() throws InterruptedException {
        synchronized(lock){
            System.out.println(Thread.currentThread().getName()+"正在执行");
            lock.wait(3000);
            System.out.println(Thread.currentThread().getName()+"执行结束");
        }
    }



}
