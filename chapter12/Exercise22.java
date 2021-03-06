/**
 * Exercise 22
 */
package com.ciaoshen.thinkinjava.chapter12;
import java.io.*;

public class Exercise22 {
    public static class FailingConstructor {
        private BufferedReader br;
        public FailingConstructor(String path) throws FileNotFoundException {
            try {
                br = new BufferedReader(new FileReader(new File(path)));
                System.out.println(path + " opened!");
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException(path);
            }
        }
        public void close() throws IOException {
            br.close();
        }
    }
    public static void main(String[] args) {
        String correctPath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter12/Exercise22.java";
        String wrongPath = "/Users/HelloKitty/java/Chapter12.java";
        FailingConstructor fcWrong;
        FailingConstructor fcRight;
        try {
            fcRight = new FailingConstructor(correctPath);
            try {
                System.out.println("Right file opened!! Working Working!!!");
            } finally {
                try {
                    fcRight.close();
                    System.out.println(correctPath + " closed!");
                } catch(IOException e) {
                    System.out.println("FATAL ERROR: ");
                    e.printStackTrace();
                }
            }
            fcWrong= new FailingConstructor(wrongPath);
            try {
                System.out.println("Wrong file opened!! Working Working!!!");
            } finally {
                try {
                    fcWrong.close();
                    System.out.println(wrongPath+ " closed!");
                } catch(IOException e) {
                    System.out.println("FATAL ERROR: ");
                    e.printStackTrace();
                }
            }
            System.out.println("All work finished! Go home now!");
        } catch (FileNotFoundException e) {
            System.out.println("File " + e.getMessage() + " not found!");
        }
    }
}
