package com.soft.concurrent;

import javax.swing.*;
import java.util.Random;

public class NumberThread implements Runnable{
    private final JLabel numberLabel;

    public NumberThread(JLabel numberLabel) {
        this.numberLabel = numberLabel;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            numberLabel.setText(String.valueOf(random.nextInt(100)));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
