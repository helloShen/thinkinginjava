/**
 *  Exercise 15
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;
import java.lang.reflect.*;

public class Generated{
    
    //给一个数组一个generator，我填充数组
    public static <T> T[] array(T[] ta, Generator<T> gen){
        for(int i=0;i<ta.length;i++){
            ta[i]=gen.next();
        }
        return ta;
    }
    
    
    //给我一个class文件，一个generator，我填充数组
    @SuppressWarnings("unchecked")
    public static <V> V[] array(Class<V> c, Generator<V> gen, int size){
        V[] v=(V[])Array.newInstance(c,size);
        for(int i=0;i<size;i++){
            v[i]=gen.next();
        }
        return v;
    }
    
    /**
     *  测试
     */
    public static void main(String[] args){
        String[] ss=new String[10];
        Generated.array(ss, new CountingGenerator.String());
        for(int i=0;i<ss.length;i++){
            System.out.println(ss[i]);
        }
        
        String[] sss=Generated.array(String.class,new CountingGenerator.String(),10);
        for(int i=0;i<sss.length;i++){
            System.out.println(sss[i]);
        }
    }
}