/**
 * Exercise 21
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.io.*;

public class MyReader {
    private static String spliter = "\n";
    public MyReader(){}
    public MyReader(String s) {
        spliter = s;
    }
    public String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line = "";
            try {
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line + spliter);
                }
            } finally {
                br.close();
            }
        } catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    private class TestUnit {
        private final String WRONGPATH = "/Users/HelloKitty/hello.java";
        private final String RIGHTPATH = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter11/MyReader.java";
        private void testReadFile() {
            System.out.println(readFile(RIGHTPATH));
            System.out.println(readFile(WRONGPATH));
        }
    }
    public static void main(String[] args) {
        TestUnit test = new MyReader().new TestUnit();
        test.testReadFile();
    }
}
