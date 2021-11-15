package com.soft.ioex;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class FileOperator {
    /**
     * 判断文件是否存在
     *
     * @param pathname
     * @return
     */
    public static boolean isExist(String pathname) {
        File file = new File(pathname);
        return file.exists();
    }

    /**
     * 创建目录
     *
     * @param pathname
     * @return
     */
    public static boolean createDir(String pathname) {
        File file = new File(pathname);
        if (! file.exists()) {
            return  file.mkdirs();
        }
        return false;
    }

    /**
     * 创建文件
     *
     * @param pathname
     * @return
     * @throws IOException
     */
    public static boolean createFile(String pathname) throws IOException {
        File file = new File(pathname);
        if (!file.exists()) {
            return file.createNewFile();
        }
        return false;
    }

    /**
     * 获取文件信息
     *
     * @param file
     * @return
     */
    public static Properties getFileInfo(File file) {
        String fileName = file.getName();
        String filePath = file.getPath();
        String parentDir = file.getParent();
        long fileLength = file.length();
        Properties properties = new Properties();
        properties.setProperty("fileName", fileName);
        properties.setProperty("filePath", filePath);
        properties.setProperty("parentDir", parentDir);
        properties.setProperty("fileLength", String.valueOf(fileLength));
        return properties;
    }

    public static boolean deleteFile(String pathname) {
        File file = new File(pathname);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
}
