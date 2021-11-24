package com.soft.lambda;

import java.util.Locale;
import java.util.function.Function;

/**
 * Function 函数式接口测试
 */
public class Test3 {
    public static void main(String[] args) {
    String newStr = strHandler("abc", (str) -> str.toUpperCase());
    System.out.println(newStr);
    newStr = strHandler(" abc ", (str) -> str.trim());
    System.out.println(newStr);
    }

    public static String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }
}
