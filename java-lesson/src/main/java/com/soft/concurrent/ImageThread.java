package com.soft.concurrent;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageThread implements Runnable{
    private JLabel imgLabel;
    private static List<String> imgList = new ArrayList<>(
            Arrays.asList("https://train-homework.oss-cn-shanghai.aliyuncs.com/avatar/file105545079120120761215685104485087545550847450109102745574995351561128850.jpg",
                    "https://train-homework.oss-cn-shanghai.aliyuncs.com/avatar/file10586111578987107518467518467885055119858966120557311350681025452894851.jpg",
                    "https://train-homework.oss-cn-shanghai.aliyuncs.com/avatar/file5549102841171008210189521061151011045067574853501151021004910857106110491106949.jpg",
                    "https://train-homework.oss-cn-shanghai.aliyuncs.com/avatar/file566584113551044811911848107558655881165610211910299515552109527473561147878.jpg")
    );

    public ImageThread(JLabel imgLabel) {
        this.imgLabel = imgLabel;
    }

    @Override
    public void run() {
        for (int i = 0; i < imgList.size(); i++) {
            Icon icon = null;
            try {
                icon = new ImageIcon(new URL(imgList.get(i)));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            imgLabel.setIcon(icon);
            imgLabel.repaint();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
