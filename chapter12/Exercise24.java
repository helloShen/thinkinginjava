/**
 * Exercise 24
 */
package com.ciaoshen.thinkinjava.chapter12;
import java.io.*;

public class Exercise24 {
    public static class FailingConstructor {
        private BufferedReader br1;
        private BufferedReader br2;
        public FailingConstructor(String path1, String path2) throws FileNotFoundException {
            br1 = new BufferedReader(new FileReader(new File(path1)));
            System.out.println(path1 + " opened!");
            br2 = new BufferedReader(new FileReader(new File(path2)));
            System.out.println(path2 + " opened!");
        }
        public void dispose() {
            try {
                br1.close();
                System.out.println("File 1 closed!");
                br2.close();
                System.out.println("File 2 closed!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        String correctPath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter12/Exercise22.java";
        String wrongPath = "/Users/HelloKitty/java/Chapter12.java";
        FailingConstructor fc;
        try {
            //fc= new FailingConstructor(correctPath,wrongPath);
            fc= new FailingConstructor(correctPath,correctPath);
            try {
                System.out.println("Two files opened!! Working Working!!!");
            } finally {
                fc.dispose();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
