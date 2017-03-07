/**
 *  Exercise 13
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

public class Exercise13 {
    static String file = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/BasicFileOutput.txt";
    public static void main(String[] args) throws IOException {
        LineNumberReader in = new LineNumberReader(new FileReader(new File("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/Exercise13.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null ){
            out.println(in.getLineNumber() + ": " + s);
        }
        out.close();
    }
}