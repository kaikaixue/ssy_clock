package com.soft.generics;

public class GenericsDemo4 {
    public static void main(String[] args) {
        Generic<Integer> gInteger = new Generic<>(123);
        Generic<Number> gNumber = new Generic<>(123);
        getValueByT(gInteger);
        getValueByT(gNumber);
    }

    public static void getValueByT(Generic<?> obj) {
        System.out.println(obj.getKey());
    }
}
