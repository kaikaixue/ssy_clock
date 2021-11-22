package com.soft.concurrent;

public class ThreadStateRunnableExample {
    private static boolean flag = true;

    public static void main(String[] args) {
        Runnable waiting = () -> {
            // 让程序空转，保持线程是runnable状态
            do {

            } while (flag);
        };
        Thread thread = new Thread(waiting);
        thread.start();
        try {
            // 主线程先休眠1秒，让子线程先跑起来，然后输出线程状态
            Thread.sleep(1000);
            System.out.println(thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }
}
