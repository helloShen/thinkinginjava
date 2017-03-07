/**
 *  Exercise 13
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise13{
    public static void main(String[] args){
        CountingGenerator.Character genC=new CountingGenerator.Character();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10;i++){
            sb.append(genC.next());
        }
        String s=sb.toString();
        System.out.println(s);
    }
}