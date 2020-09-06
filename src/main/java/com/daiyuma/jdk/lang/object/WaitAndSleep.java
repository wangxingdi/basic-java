package com.daiyuma.jdk.lang.object;

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
                        //下面的方法建议一个一个的执行
                        waitWhetherReleaseLock();
                        sleepWhetherReleaseLock();
                        waitWithoutSync();
                        sleetWithoutSync();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        });
    }

    /**
     * 线程1休眠后,线程2无法进入同步方法,直到线程1执行完毕;
     * @throws InterruptedException
     */
    private static void sleepWhetherReleaseLock() throws InterruptedException {
        synchronized(lock){
            System.out.println(Thread.currentThread().getName()+"正在执行");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+"执行结束");
        }
    }

    /**
     * 线程1休眠后,线程2可以进入同步方法;
     * @throws InterruptedException
     */
    private static void waitWhetherReleaseLock() throws InterruptedException {
        synchronized(lock){
            System.out.println(Thread.currentThread().getName()+"正在执行");
            lock.wait(3000);
            System.out.println(Thread.currentThread().getName()+"执行结束");
        }
    }

    /**
     * 如果不使用synchronized,wait方法会出现IllegalMonitorStateException
     * @throws InterruptedException
     */
    private static void waitWithoutSync() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"正在执行");
        lock.wait(3000);
        System.out.println(Thread.currentThread().getName()+"执行结束");
    }

    /**
     * 如果不使用synchronzied,sleep方法仍旧可以执行,
     * 只不过在线程1和线程2不会再同步执行
     * @throws InterruptedException
     */
    private static void sleetWithoutSync() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"正在执行");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+"执行结束");
    }



}
