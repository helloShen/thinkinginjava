/**
 *  Exercise 26
 */
package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;
import java.lang.reflect.*;

class Declared{public void declaredMethod(){System.out.println("I am declaredMethod!");}}

public class TestRtti{
    public void rtti(){
        try{
            Class<?> c=Class.forName("com.ciaoshen.thinkinjava.chapter14.Apple");
        }catch(ClassNotFoundException cnfe){
            System.out.println("Class APPLE not found!");
        }
    }
    
    public void rttiExp(){
        try{
            Class<?> c=Class.forName("com.ciaoshen.thinkinjava.chapter14.Declared");
        }catch(ClassNotFoundException cnfe){
            System.out.println("Class Declared not found!");
        }
    }
    
    public void reflect(){
        try{
            Class<?> c=Class.forName("com.ciaoshen.thinkinjava.chapter14.Declared");
            Method m=c.getDeclaredMethod("declaredMethod");
            m.invoke(c.newInstance());
        }catch(ClassNotFoundException cnfe){
            System.out.println("Class Declared not found!");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void reflectExp(){
        try{
            Class<?> c=Class.forName("com.ciaoshen.thinkinjava.chapter14.Declared");
            Method m=c.getDeclaredMethod("declaredMethod");
            m.invoke(new TestRtti());
        }catch(ClassNotFoundException cnfe){
            System.out.println("Class Declared not found!");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args){

    }
}