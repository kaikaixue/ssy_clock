package com.soft.generics.dao;

import com.soft.generics.entity.Worker;

import java.lang.reflect.ParameterizedType;

public abstract class BaseDao<T> {
    private Class clazz;

    public BaseDao() {
        // 子类的类型
        clazz = this.getClass();
        // 获得子类传入的泛型
        ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();
        clazz = (Class) pt.getActualTypeArguments()[0];
    }

    public void add(T t) {
        System.out.println(t + "对象插入成功");
    }

    public Worker find(Integer id) {
        System.out.println("查找到id为: " + id + "的对象");
        return new Worker(id, "");
    }

    public void update(T t) {
        System.out.println("更新对象: " + t);
    }

    public void delete(Integer id) {
        System.out.println("删除id为: " + id + "的对象");
    }
}
