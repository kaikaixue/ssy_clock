package com.soft.generics;

public class GenericsArgs {
    /**
     * 静态方法中使用泛型，必须要将泛型定义在方法上
     *
     * @param args
     * @param <T>
     */
    public static <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println("泛型测试,it is " + t);
        }
    }

    public static void main(String[] args) {
        printMsg("1111",2222,"Java","0.00",55.55);
    }
}
