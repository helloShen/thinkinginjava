/**
 * Exercise 12
 */
package com.ciaoshen.thinkinjava.chapter12;
import java.io.*;

public class BestPractice {
    public static void openFile(String path) {
        try {
            BufferedReader stream = new BufferedReader(new FileReader(new File(path)));
            try {
                System.out.println(path + " alrady opend!");
                throw new IOException();
            } finally {
                stream.close();
                System.out.println("stream" + path + " closed correctly!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String wrongPath = "/Users/HelloKitty/abc.java";
        String rightPath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter12/BestPractice.java";
        openFile(wrongPath);
        openFile(rightPath);
    }
}
