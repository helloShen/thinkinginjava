/**
 *  Exercise 20
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

public class Exercise20 {
    public static void main(String[] args) throws IOException{
        Directory dir=new Directory("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18");
        List<File> files=dir.getFile();
        if(!files.isEmpty()){
            for(File file:files){
                if(file.getName().endsWith(".class")){
                    byte[] bytes=BinaryFile.read(file);
                    String one=Integer.toHexString(((Byte)bytes[0]).intValue());
                    String two=Integer.toHexString(((Byte)bytes[1]).intValue());
                    String three=Integer.toHexString(((Byte)bytes[2]).intValue());
                    String four=Integer.toHexString(((Byte)bytes[3]).intValue());
                    System.out.println(one+two+three+four);
                }
            }
        }
    }
}