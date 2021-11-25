package com.soft.collection;

public class Manager extends Employee {
    public Manager() {
    }

    public Manager(String name, int age) {
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println("班主任管理班级");
    }
}
