/**
 *  Exercise 25
 */
package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;
import java.lang.reflect.*;

class TestClass{
    public void publicMethod(){System.out.println("I am public method!");}
    void packageAccessMethod(){System.out.println("I am package access method!");}
    protected void protectedMethod(){System.out.println("I am protected method!");}
    private void privateMethod(){System.out.println("I am private method!");}
}

public class TestSetAccessibility{
    public static void main(String[] args){
        try{
            Class<?> c=TestClass.class;
            Object o=c.newInstance();
            Method[] ms=c.getDeclaredMethods();
            for(Method m:ms){
                m.setAccessible(true);
                m.invoke(o);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}