package com.soft.generics;

import java.util.Random;

public class FruitGenerator implements Generator<String> {
    String[] fruits = new String[]{"apple","banana","pear"};

    @Override
    public String next() {
        Random random = new Random();
        return fruits[random.nextInt(3)];
    }

    public static void main(String[] args) {
        FruitGenerator fg = new FruitGenerator();
        System.out.println(fg.next());
    }
}
