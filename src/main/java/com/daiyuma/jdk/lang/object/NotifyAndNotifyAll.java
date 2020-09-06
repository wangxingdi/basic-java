package com.daiyuma.jdk.lang.object;

/**
 * 1.notify方法会随机唤醒一个等待当前对象锁的方法；
 * 2.notifyAll方法会唤醒全部等待当前对象锁的方法；
 * 3.不管是notify还是notifyAll，都需要在synchronzied中使用；
 * 4.不管是notify还是notifyAll，其作用都是唤醒处于等待状态的线程，但是被唤醒的线程并不会立即执行，而是进入到对象的锁池中。
 * 等待notify或者notifyAll方法释放对象锁之后，被唤醒的线程才能够真正的竞争对象锁然后执行；
 */
public class NotifyAndNotifyAll {

    static NotifyAndNotifyAll lock = new NotifyAndNotifyAll();

    public static void main(String[] args) throws InterruptedException {
        notifyAndNotifyAll();
    }

    private static void notifyAndNotifyAll() throws InterruptedException {
        Runnable waitTask = new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+"已经启动,即将wait");
                    try {
                        lock.wait();
                        System.out.println(Thread.currentThread().getName()+"已经被唤醒,1秒后将释放对象锁");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable notifyTask = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"已经启动,即将nofity");
                synchronized (lock){
                    lock.notify();
                }
            }
        };

        Runnable notifyAllTask = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"已经启动,即将nofityAll,此方法会在3秒后结束");
                synchronized (lock){
                    lock.notifyAll();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread w1 = new Thread(waitTask, "wait-1");
        Thread w2 = new Thread(waitTask, "wait-2");
        Thread w3 = new Thread(waitTask, "wait-3");
        Thread w4 = new Thread(waitTask, "wait-4");
        Thread w5 = new Thread(waitTask, "wait-5");
        Thread n1 = new Thread(notifyTask, "notify");
        Thread n2 = new Thread(notifyAllTask, "notifyAll");

        w1.start();
        w2.start();
        w3.start();
        w4.start();
        w5.start();
        Thread.sleep(1000);
        System.out.println("即将随机唤醒一个线程");
        n1.start();
        System.out.println("已经执行了notify方法,5秒后执行notifyAll方法,注意前后区别");
        Thread.sleep(5000);
        n2.start();
    }
}
