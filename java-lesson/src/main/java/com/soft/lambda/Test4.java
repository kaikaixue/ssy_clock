package com.soft.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 断言式接口测试
 */
public class Test4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "Java", "lambda");
        List<String> ret = filterStr(list, (str) -> str.length() > 4);
        System.out.println(ret);
    }

    public static List<String> filterStr(List<String> list, Predicate<String> pre) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
