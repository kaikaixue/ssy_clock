package com.soft.concurrent;

public class ThreadStateNewExample {
    private static final Object WAITER = new Object();

    public static void main(String[] args) {
        Runnable waiting = () -> {
            try {
                WAITER.wait();;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread whoWillWait = new Thread(waiting);
        System.out.println(whoWillWait.getState());
    }
}
