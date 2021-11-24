package com.soft.lambda;

import java.util.function.Consumer;

/**
 * 消费性接口测试
 */
public class Test1 {
    public static void main(String[] args) {
        consumerTest();
    }

    public static void consumerTest() {
        Consumer<String> consumer = e -> System.out.println("Lambda 表达式， " + e);
        consumer.accept("传入参数");
    }
}
