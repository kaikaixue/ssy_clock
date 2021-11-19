package com.soft.ioex;

import java.io.Serial;
import java.io.Serializable;

public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = -2129785458601500178L;
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
