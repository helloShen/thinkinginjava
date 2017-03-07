/**
 * Exercise 22
 */
package com.ciaoshen.thinkinjava.chapter12;
import java.io.*;

public class Exercise23 {
    public static class FailingConstructor {
        private BufferedReader br1;
        private BufferedReader br2;
        public FailingConstructor(String path1, String path2) throws FileNotFoundException {
            br1 = new BufferedReader(new FileReader(new File(path1)));
            try {
                System.out.println(path1 + " opened!");
            } finally {
                try {
                    br1.close();
                } catch (IOException e) {
                    System.out.println(path1 + " cannot be closed!");
                }
            }
            br2 = new BufferedReader(new FileReader(new File(path2)));
            try {
                System.out.println(path2 + " opened!");
            } finally {
                try {
                    br2.close();
                } catch (IOException e) {
                    System.out.println(path1 + " cannot be closed!");
                }
            }
        }
    }
    public static void main(String[] args) {
        String correctPath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter12/Exercise22.java";
        String wrongPath = "/Users/HelloKitty/java/Chapter12.java";
        FailingConstructor fc;
        try {
            fc= new FailingConstructor(correctPath,wrongPath);
            System.out.println("Two files opened!! Working Working!!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
