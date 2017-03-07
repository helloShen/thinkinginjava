/**
 *  知乎答题
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;

class Test2{
    //不可变的String
    public static String appendStr(String s){
        s+="bbb";
        return s;
    }
    
    //可变的StringBuilder
    public static StringBuilder appendSb(StringBuilder sb){
        return sb.append("bbb");
    }
    
    public static void main(String[] args){
        //String做参数
        String s=new String("aaa");
        String ns=Test2.appendStr(s);
        System.out.println("String aaa >>> "+s.toString());
        
        //StringBuilder做参数
        StringBuilder sb=new StringBuilder("aaa");
        StringBuilder nsb=Test2.appendSb(sb);
        System.out.println("StringBuilder aaa >>> "+sb.toString());
    }
}
