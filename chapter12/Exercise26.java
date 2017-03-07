/**
 * Exercise 26
 */
package com.ciaoshen.thinkinjava.chapter12;
import java.io.*;

public class Exercise26 {
    // Pass all exceptions to the console:
    public static void main(String[] args) throws Exception {
        // Open the file:
        FileInputStream file = new FileInputStream("/Users/HelloKitty.MainException.java");
        // Use the file ...
        // Close the file:
        file.close();
    }
}
