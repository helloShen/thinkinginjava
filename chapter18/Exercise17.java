/**
 *  Exercise 17
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

public class Exercise17{
    public static void main(String[] args){
        TextFile tf=new TextFile("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/TextFile.java","");
        Map<Character, Integer> map=new HashMap<Character,Integer>();
        for(String s:tf){
            Character c=s.charAt(0);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        System.out.println(map);
    }
}