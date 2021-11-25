package com.soft.collection;

public class Teacher extends Employee {
    public Teacher() {

    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println("老师在上课");
    }
}
