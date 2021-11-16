package com.soft.ioex;

import java.io.Serializable;

public class Employee implements Serializable {
    public String name;
    public String address;
    public transient int age;

    /**
     * transient瞬态修饰成员，不会被序列化
     */
    public void addressCheck() {
        System.out.println("Address check : " + name + " -- " + address);
    }
}
