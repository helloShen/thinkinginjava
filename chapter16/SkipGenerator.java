/**
 *  Exercise 12
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;


public class SkipGenerator{
    private int size=1;
    
    public SkipGenerator(){}
    public SkipGenerator(int size){
        this.size=size;
    }
    
    //Boolean
    public class Boolean implements Generator<java.lang.Boolean>{
        private boolean b=false;
        public java.lang.Boolean next(){
            if(size%2==1){
                b=!b;
            }
            return b;
        }
    }
    //Integer
    public class Integer implements Generator<java.lang.Integer>{
        private int i=0;
        public java.lang.Integer next(){
            i+=size;
            return i;
        }
    }
    //Long
    public class Long implements Generator<java.lang.Long>{
        private long l=0l;
        public java.lang.Long next(){
            l+=(long)size;
            return l;
        }
    }
    //Short
    public class Short implements Generator<java.lang.Short>{
        private short s=0;
        public java.lang.Short next(){
            s+=(short)size;
            return s;
        }
    }
    //Float
    public class Float implements Generator<java.lang.Float>{
        private float f=0f;
        public java.lang.Float next(){
            f+=(float)size;
            return f;
        }
    }
    //Double
    public class Double implements Generator<java.lang.Double>{
        private double d=0.0;
        public java.lang.Double next(){
            d+=(double)size;
            return d;
        }
    }
    //Byte
    public class Byte implements Generator<java.lang.Byte>{
        private byte b=0;
        public java.lang.Byte next(){
            b+=size;
            return b;
        }
    }
    
    //Charactor
    private static final char[] CS=("abcdefghijklmnopqrstuvwxyz"+"ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    public class Character implements Generator<java.lang.Character>{
        private int index=0;
        public java.lang.Character next(){
            return CS[(index+size)%CS.length];
        }
    }
    
    
    //String
    public class String implements Generator<java.lang.String>{
        private int num=7;
        private Generator<java.lang.Character> c=new Character();
        public String(){}
        public String(int size){num=size;}
        public java.lang.String next(){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<num;i++){
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