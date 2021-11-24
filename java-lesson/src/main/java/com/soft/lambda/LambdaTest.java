package com.soft.lambda;

import java.lang.reflect.Constructor;
import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("普通线程启动");
            }
        };
        runnable.run();
        test1();
        test2();
        test3();
        test4();
    }

    /**
     * 无参数，无返回值
     */
    public static void test1() {
        Runnable runnable = () -> System.out.println("Lambda表达式线程启动");
        runnable.run();
    }

    /**
     * 有一个参数，无返回值
     */
    public static void test2() {
        Consumer<String> consumer = e -> System.out.println("Lambda 表达式" + e);
        consumer.accept("传入参数");
    }

    /**
     * 有两个以上的参数，有返回值，并且Lambda体中有多条语句
     */
    public static void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        int compare = com.compare(100, 244);
        System.out.println("有两个以上的参数，有返回值," + compare);
    }

    /**
     * 只有一条语句， return 和 大括号 都可以不写
     */
    public static void test4() {
        System.out.println("若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写," + Integer.compare(100, 244));
    }
}
