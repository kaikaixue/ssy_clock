package com.soft.collection;

import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        //创建集合对象   该集合中存储 Student类型对象
        HashSet<Student> stuSet = new HashSet<Student>();
        //存储
        stuSet.add(new Student("于谦", 43));
        stuSet.add(new Student("郭德纲", 44));
        stuSet.add(new Student("于谦", 43));
        stuSet.add(new Student("郭麒麟", 23));
        for (Student stu2 : stuSet) {
            System.out.println(stu2);
        }
    }
}
