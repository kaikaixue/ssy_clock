package com.soft.reflection;

import lombok.extern.slf4j.Slf4j;

import javax.sound.midi.MetaEventListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射解决泛型问题
 */
@Slf4j
public class ReflectDemo3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");

        Class<?> clazz = list.getClass();
        Method method = clazz.getMethod("add", Object.class);
        method.invoke(list, 28);
        log.info("反射太强大了{}", list);
    }
}
