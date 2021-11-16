package com.soft.ioex;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * IO流Demo练习1
 */
public class IoDemo1 {
    public static void main(String[] args) throws IOException {
//        readByte();
//        readByArray();
//        outputStreamDemo1();
//        inputStreamDemo1();
//        fileWriterDemo();
//        fileReaderDemo();
//        bufferWriterDemo();
//        bufferReaderDemo();
//        txtSort();
//        printWriterDemo();
//        writeObjectDemo();
        readObjectDemo();
    }

    /**
     * 读取字节
     */
    public static void readByte() {
        byte[] bytes = "你".getBytes();
        System.out.println(Arrays.toString(bytes));
    }

    /**
     * 读取字节数组
     * @throws UnsupportedEncodingException
     */
    public static void readByArray() throws UnsupportedEncodingException {
        byte[] bytes = "你".getBytes("UTF-8");
        System.out.println(Arrays.toString(bytes));

        bytes = "你".getBytes("GBK");
        System.out.println(Arrays.toString(bytes));

        bytes = "你".getBytes(StandardCharsets.UTF_16LE);
        System.out.println(Arrays.toString(bytes));

        bytes = "你".getBytes(StandardCharsets.UTF_16LE);
        System.out.println(Arrays.toString(bytes));
    }

    /**
     * 字节输出流： 写字节
     *
     * @throws IOException
     */
    public static void outputStreamDemo1() throws IOException {
        // 定义文件路径
        String fileName = "out.txt";
        // 创建流对象，默认UTF8编码
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fileName));
        // 写数据，保存为6个字节
        osw.write("你好");
        osw.flush();
        osw.close();

        // 定义文件路径
        String fileName2 = "out2.txt";
        // 创建流对象，指定GBK编码
        OutputStreamWriter osw2 = new OutputStreamWriter(new FileOutputStream(fileName2),"GBK");
        // 写数据，保存为4个字节
        osw2.write("你好");
        osw2.flush();
        osw2.close();
    }

    /**
     * 读字节
     * @throws IOException
     */
    public static void inputStreamDemo1() throws IOException {
        // 定义需要读取的文件路径，该文件采用了GBK编码
        String fileName = "info.txt";
        // 创建流对象,默认UTF8编码
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName));
        // 创建流对象，指定GBK编码
        InputStreamReader isr2 = new InputStreamReader(new FileInputStream(fileName),"GBK");
        // 定义常量，保存字符
        int read;
        System.out.println("\n******使用默认编码获取******\n");
        // 使用默认编码字符流读取，乱码
        while ((read = isr.read()) != -1) {
            System.out.print((char) read);
        }
        isr.close();
        System.out.println("\n******使用GBK编码读取******\n");
        // 使用指定编码字符流读取，正常解析
        while ((read = isr2.read()) != -1) {
            System.out.print((char) read);
        }
        isr2.close();
    }

    /**
     * 字符流： 写文件
     *
     * @throws IOException
     */
    public static void fileWriterDemo() throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("fw.txt");
        // 写入单个字符
        fw.write(97);
        fw.flush();
        // 写入字符数组
        char[] chs = "ABCDEF".toCharArray();
        fw.write(chs);
        fw.flush();

        // 写出字符数组的一部分，开始索引，写出个数
        fw.write(chs, 1, 3);
        fw.flush();

        // 写出字符串
        fw.write("Java工程师");
        fw.flush();
        fw.close();
    }

    /**
     * 字符流：读文件
     *
     * @throws IOException
     */
    public static void fileReaderDemo() throws IOException {
        // 使用文件名称创建流对象，读取的源文件read.txt在项目根目录下
        FileReader fr = new FileReader("read.txt");
        // 定义变量，保存有效字符个数
        int len;
        // 定义字符数组，作为装字符数据的容器
        char[] buf = new char[2];
        // 循环读取
        while ((len = fr.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }
        // 关闭资源
        fr.close();
    }

    /**
     * 字符缓冲流: 写文件，newLine()
     *
     * @throws IOException
     */
    public static void bufferWriterDemo() throws IOException {
        // 创建流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        // 写出数据
        bw.write("Java");
        // 写出换行
        bw.newLine();
        bw.write("程序");
        bw.newLine();
        bw.write("员");
        bw.newLine();
        // 释放资源
        bw.close();
    }

    /**
     * 字符缓冲流： 读文件，readLine()
     *
     * @throws IOException
     */
    public static void bufferReaderDemo() throws IOException {
        // 创建流对象
        BufferedReader br = new BufferedReader(new FileReader("read.txt"));
        // 定义字符串，保存读取的一行文字
        String line = null;
        // 循环读取，读取到最后返回null
        while ((line = br.readLine()) != null) {
            System.out.print(line);
            System.out.println("--------------------");
        }
        // 释放资源
        br.close();
    }

    /**
     * 文本练习
     *
     * @throws IOException
     */
    public static void txtSort() throws IOException {
        // 1.创建ArrayList集合，泛型使用String
        ArrayList<String> list = new ArrayList<>();
        // 2.创建BufferedReader对象，构造方法中传递FileReader对象
        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        // 3.创建BufferedWriter对象，构造方法中传递FileWriter对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        // 4.使用BufferedReader对象中的方法readLine,以行的方式读取文本
        String line = null;
        while ((line = br.readLine()) != null) {
            // 5.把读取导的文本存储到ArrayList集合中
            list.add(line);
        }
        // 6.使用Collections集合工具类中的方法sort，对集合中的元素按照自定义规则排序
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 依次比较集合中两个元素的首字母
                return o1.charAt(0) - o2.charAt(0);
            }
        });
        // 7.遍历ArrayList集合，获取每一个元素
        for (String s : list) {
            // 8.使用BufferedWriter对象中的方法write,把遍历得到的元素写入到文本中（内存缓冲区中）
            bw.write(s);
            // 写换行
            bw.newLine();
            bw.flush();
        }
        // 10.释放资源
        bw.flush();
        bw.close();
    }

    /**
     * 打印流
     *
     * @throws IOException
     */
    public static void printWriterDemo() throws IOException {
        // 创建打印流，输出目的是字节输出流
//        PrintWriter pw1 = new PrintWriter(new FileOutputStream("a.txt"),true);

        // 创建打印流，输出目的是字符
        PrintWriter pw = new PrintWriter(new FileWriter("a.txt"),true);
        pw.println(97);
        pw.println(98);
        pw.close();
    }

    /**
     * 序列化
     */
    public static void writeObjectDemo() {
        Employee e = new Employee();
        e.name = "zhangsan";
        e.address = "jiangsu";
        e.age = 20;
        try {
            FileOutputStream fileOut = new FileOutputStream("employee.txt");
            // 创建序列化流对象
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.txt"));
            // 写出对象
            out.writeObject(e);
            // 释放资源
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved");
            // 姓名，地址被序列化，年龄没有被序列化
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * 反序列化
     */
    public static void readObjectDemo() {
        Employee e;
        try {
            // 创建反序列化流
            FileInputStream fileIn = new FileInputStream("employee.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // 读取一个对象
            e = (Employee) in.readObject();
            // 释放资源
            in.close();
            fileIn.close();
        } catch (IOException i) {
            // 捕获其他异常
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            // 捕获类找不到异常
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        // 无异常，直接打印输出
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("age: " + e.age);
    }
}
