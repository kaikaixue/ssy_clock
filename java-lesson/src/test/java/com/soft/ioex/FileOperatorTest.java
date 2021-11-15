package com.soft.ioex;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class FileOperatorTest {
    @org.junit.jupiter.api.Test
    void createDir() {
        String path = "E:/code/aaa";
        boolean res = FileOperator.createDir(path);
        assertTrue(res);
    }

    @org.junit.jupiter.api.Test
    void createFile() {
        String path = "E:/code/aaa/hello.txt";
        boolean res = false;
        try {
            res = FileOperator.createFile(path);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        assertTrue(res);
    }

    @org.junit.jupiter.api.Test
    void getFileInfo() {
        File file = new File("E:/code/aaa/hello.txt");
        Properties fileProperties = FileOperator.getFileInfo(file);
        assertEquals(4, fileProperties.size());
    }

    @org.junit.jupiter.api.Test
    void deleteFile() {
        boolean res =
                FileOperator.deleteFile("E:/code/aaa/aaa.txt");
        assertTrue(res);
    }
}