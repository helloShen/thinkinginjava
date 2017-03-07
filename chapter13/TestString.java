/**
 *  simple test - Chapter 13
 */

package com.ciaoshen.thinkinjava.chapter13;
import java.util.regex.*;
import java.util.*;


class TestString {

    public static void main(String[] args){
        //String字面量拼接
        long begin=System.nanoTime();
        String a="a";
        String b="";
        for(int i=0;i<10000;i++){
            b+=a;
        }
        long end=System.nanoTime();
        System.out.println(end-begin);
        
        //StringBuilder直接拼接
        begin=System.nanoTime();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10000;i++){
            sb.append("a");
        }
        end=System.nanoTime();
        System.out.println(end-begin);
        
        //String对象拼接
        begin=System.nanoTime();
        String s=new String("");
        for(int i=0;i<10000;i++){
            String x=new String("a");
            s+=x;
        }
        end=System.nanoTime();
        System.out.println(end-begin);
        
        //StringBuffer直接拼接
        begin=System.nanoTime();
        StringBuffer sbf=new StringBuffer();
        for(int i=0;i<10000;i++){
            sbf.append("a");
        }
        end=System.nanoTime();
        System.out.println(end-begin);
    }
}
