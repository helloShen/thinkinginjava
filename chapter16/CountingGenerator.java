/**
 *  Exercise 12
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;


public class CountingGenerator{
    
    //Boolean
    public static class Boolean implements Generator<java.lang.Boolean>{
        private boolean b=false;
        public java.lang.Boolean next(){
            b=!b;
            return b;
        }
    }
    //Integer
    public static class Integer implements Generator<java.lang.Integer>{
        private int i=0;
        public java.lang.Integer next(){
            i+=1;
            return i;
        }
    }
    //Long
    public static class Long implements Generator<java.lang.Long>{
        private long l=0l;
        public java.lang.Long next(){
            l+=1;
            return l;
        }
    }
    //Short
    public static class Short implements Generator<java.lang.Short>{
        private short s=0;
        public java.lang.Short next(){
            s+=1;
            return s;
        }
    }
    //Float
    public static class Float implements Generator<java.lang.Float>{
        private float f=0f;
        public java.lang.Float next(){
            f+=1;
            return f;
        }
    }
    //Double
    public static class Double implements Generator<java.lang.Double>{
        private double d=0.0;
        public java.lang.Double next(){
            d+=1;
            return d;
        }
    }
    //Byte
    public static class Byte implements Generator<java.lang.Byte>{
        private byte b=0;
        public java.lang.Byte next(){
            b+=1;
            return b;
        }
    }

    //Charactor
    private static final char[] CS=("abcdefghijklmnopqrstuvwxyz"+"ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    public static class Character implements Generator<java.lang.Character>{
        private int index=0;
        public java.lang.Character next(){
            return CS[(index++)%CS.length];
        }
    }


    //String
    public static class String implements Generator<java.lang.String>{
        private int size=7;
        private Generator<java.lang.Character> c=new Character();
        public String(){}
        public String(int size){this.size=size;}
        public java.lang.String next(){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<size;i++){
                sb.append(c.next());
            }
            return sb.toString();
        }
    }
 
    /**
     *  测试
     */
    public static void main(java.lang.String[] args){
        CountingGenerator.String s=new CountingGenerator.String();
        System.out.println(s.next());
    }
}