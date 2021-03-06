package com.soft.concurrent;

public class GuessNumberTest {
    public static void main(String[] args) {
        System.out.println("1号竞猜机器启动");
        Thread thread1 = new GuessNumber(10);
        thread1.setName("1号竞猜机器");
        thread1.start();

        System.out.println("2号竞猜机器启动");
        Thread thread2 = new GuessNumber(7);
        thread2.setName("2号竞猜机器");
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束");
    }
}
