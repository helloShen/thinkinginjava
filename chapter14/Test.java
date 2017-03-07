package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;

class Test{

    public void change(int x){
        x=x*2;
    }
    public static String appendStr(String s){
        s+="bbb";
        return s;
    }
    public static StringBuilder appendSb(StringBuilder sb){
        sb=sb.append("bbb");
        return sb;
    }

    public static void main(String[] args){
        String s=new String("aaa");
        String ns=Test.appendStr(s);
        System.out.println("String: aaa >>> "+s.toString());
        
        StringBuilder sb=new StringBuilder("aaa");
        StringBuilder nsb=Test.appendSb(sb);
        System.out.println("StringBuilder: aaa >>> "+sb.toString());
        
        HashSet<StringBuilder> hs=new HashSet<StringBuilder>();
        StringBuilder sb1=new StringBuilder("aaa");
        StringBuilder sb2=new StringBuilder("aaabbb");
        StringBuilder sb3=sb1;
        hs.add(sb1);
        hs.add(sb2);    //这时候HashSet里是{"aaa","aaabbb"}
        
        sb3.append("bbb");  //这时候HashSet里是{"aaabbb","aaabbb"}
        System.out.println(hs);
    }
}