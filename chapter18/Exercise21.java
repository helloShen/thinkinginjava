/**
 *  Exercise 21
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

public class Exercise21{
    public static void main(String[] args) throws IOException{
        PrintStream console=System.out;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintStream ps=new PrintStream(new BufferedOutputStream(new FileOutputStream("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/Exercise21.txt")));
        System.setOut(ps);
        String s;
        while((s=br.readLine())!=null && s.length()!=0){
            s=s.toUpperCase();
            System.out.println(s.toUpperCase());
        }
        ps.close();
        System.setOut(console);
    }
}