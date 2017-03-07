/**
 *  Use the invoke method of Method class
 */

package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;
import java.lang.reflect.*;

public class InvokeMethod{
    public int plus(int a, int b){return a+b;}
    public static void main(String[] args){
        Class<?> c=InvokeMethod.class;
        try{
            Object o=c.newInstance();
            Method m=c.getMethod("plus",int.class,int.class);
            System.out.println(m.invoke(o,2,3));
        }catch(Exception e){
            System.out.println(e);
        }
    }
}