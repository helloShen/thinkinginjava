/**
 *  Exercise 19
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

public class Exercise19  {
    public static void main(String[] args) throws IOException{
        byte[] bytes=BinaryFile.read("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/BinaryFile.java");
        Map<Byte,Integer> map=new HashMap<Byte,Integer>();
        for(int i=0;i<bytes.length;i++){
            byte b=bytes[i];
            if(map.containsKey(b)){
                map.put(b,map.get(b)+1);
            }else{
                map.put(b,1);
            }
        }
        System.out.println(map);
    }
}