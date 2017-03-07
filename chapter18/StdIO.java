/**
 *  Test standard input and output
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

public class StdIO{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null && s.length()!=0){
            System.out.println(s);
        }
    }
}