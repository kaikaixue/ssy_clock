package com.soft.generics;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class GenericsDemo5 {
    public static void main(String[] args) {
        Object obj = null;
        try {
            obj = genericMethod(Class.forName("com.soft.generics.City"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(obj);
        City city = (City) obj;
        Objects.requireNonNull(city).setName("南京");
        System.out.println(city);
    }

    private static <T> T genericMethod(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return clazz.getDeclaredConstructor().newInstance();
    }
}
