/**
 *  Exercise 6
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public class Exercise6 implements Letters.Letter{
    public static void main(String[] args){
        Random rand=new Random();
        for(int j=0;j<10;j++){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<7;i++){
                Letters ls=Enums.random(Letters.class);
                Letter l=Enums.random(ls.getValues());
                sb.append(l.toString());
            }
            System.out.println(sb);
        }
    }
}