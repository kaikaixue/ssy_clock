package com.soft.lambda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * Supplier供给型接口测试
 */
public class Test2 {
    public static void main(String[] args) {
        ArrayList<Integer> res = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(res);
    }

    public static ArrayList<Integer> getNumList(int num, Supplier<Integer> sup) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i ++) {
            Integer e = sup.get();
            list.add(e);
        }
        return list;
    }
}
