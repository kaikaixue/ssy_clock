package com.soft.ioex;

import java.io.File;

public class FileJudgeMethods {
    public static void main(String[] args) {
        File f = new File("E:/code/aaa/bbb.txt");
        File f2 = new File("E:/code/aaa/aaa");
        // 判断是否存在
        System.out.println("E:/code/aaa/bbb.txt 是否存在： " + f.exists());
        System.out.println("E:/code/aaa/aaa 是否存在： " + f2.exists());
        // 判断是文件还是目录
        System.out.println("E:/code/aaa/aaa 是文件：" + f2.isFile());
        System.out.println("E:/code/aaa/aaa 是目录：" + f2.isDirectory());
    }
}
