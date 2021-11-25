package com.soft.lambda;

import java.util.function.Supplier;

public class TestSupplier {

    public void test() {
        System.out.println("Java8新特性，Supplier");
    }

    TestSupplier() {
        System.out.println("调用构造方法");
    }

    public static void main(String[] args) {
        // 创建Supplier容器，声明为TestSupplier类型，此时并不会调用对象的构造方法，既不会创建对象
        Supplier<TestSupplier> sup = TestSupplier::new;
        sup.get().test();
        System.out.println("------------------");
        // 调用get方法，此时会调用对象的构造方法，即获得到真正对象
        sup.get();
        // 每次get都会调用构造方法，即获得的对象不同
        System.out.println(("是否是相同的对象实例" + sup.get()));
    }
}
