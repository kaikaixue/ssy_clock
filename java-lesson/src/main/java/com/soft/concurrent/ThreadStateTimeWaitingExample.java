package com.soft.concurrent;

public class ThreadStateTimeWaitingExample {
    private static final Object LOCKER = new Object();

    public static void main(String[] args) {
        Runnable waiting = () -> {
            System.out.println("whoWillWait 开始等待 1秒钟");
            waiting();
            System.out.println("whoWillWait 等待结束");
        };
        // 创建一个线程调用waiter.wait()方法，让whoWillWait线程进入waiting状态
        Thread whoWillWait = new Thread(waiting);
        whoWillWait.start();
        // 主线程先休息1秒，让whoWillWait先执行
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("whoWillWait当前的线程状态=" + whoWillWait.getState());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("whoWillWait当前的线程状态=" + whoWillWait.getState());
        System.exit(1);
    }

    private static void waiting() {
        synchronized (LOCKER) {
            try {
                LOCKER.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
