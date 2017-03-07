/**
 *  Exercise 26
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class Exercise26{

    public static void jgrep(String regex, String path) throws IOException{
        Pattern p = Pattern.compile(regex);
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        FileChannel fc=new RandomAccessFile(path, "r").getChannel();
        CharBuffer cb=Charset.forName(System.getProperty("file.encoding")).decode(fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()));
        StringBuilder sb=new StringBuilder();
        Character c;
        while(cb.hasRemaining()){
            c=cb.get();
            sb.append(c);
            if(c.equals('\n')){
                m.reset(sb.toString());
                while(m.find()){
                    System.out.println(index++ + ": " + m.group() + ": " + m.start());
                }
                sb.delete(0,sb.length());
            }
        }
        fc.close();
    }
    
    public static void main(String[] args) throws IOException{
        jgrep("if","/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/Exercise26.java");
    }
}