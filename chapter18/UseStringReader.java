/**
 *  Test the StringReader
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

public class UseStringReader{
    public static void main(String[] args){
        String s=new String("Hello World!");
        StringReader sr=new StringReader(s);
        try{
            for(int i=sr.read();i!=-1;i=sr.read()){
                System.out.println((char)i);
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
}