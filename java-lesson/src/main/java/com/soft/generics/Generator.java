package com.soft.generics;

public interface Generator<T> {
    /**
     * next方法生成类
     *
     * @return
     */
    T next();
}
