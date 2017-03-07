/**
 *  Exercise 8,9
 */
package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;
import java.lang.reflect.*;


class TestChar{
    public static void main(String[] args){
        char[] c={'a','b','c'};
        int[] i={1,2,3};
        long[] l={1l,2l,3l};
        float[] f={1f,2f,3f};
        String[] s={"aaa","bbb","ccc"};
        
        System.out.println(c instanceof char[]);
        System.out.println(c instanceof Object);
        System.out.println(c.getClass().getName());
        System.out.println(c.getClass().getSuperclass().getName());
        
        System.out.println(c.getClass().getName());
        System.out.println(i.getClass().getName());
        System.out.println(l.getClass().getName());
        System.out.println(f.getClass().getName());
        System.out.println(s.getClass().getName());
        
        try{
            Class<?> theClass = Class.forName("[I");
            System.out.println(theClass.getName());
        }catch(ClassNotFoundException cnfe){}
        
        //Array.setChar(i,1,'c');
        i[1]='b';
        System.out.println(i[1]);

    }
}