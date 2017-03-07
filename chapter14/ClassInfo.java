/**
 *  Exercise 19
 */

package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;
import java.lang.reflect.*;

class ClassInfo{
    public static void main(String[] args){
        try{
            Class<?> c=Class.forName(args[0]);
                
            //constructor
            Constructor<?>[] cons=c.getConstructors();
            if(cons.length>0){
                for(Constructor<?> con : cons){
                    System.out.println(con);
                }
            }
            //methods
            Method[] ms=c.getMethods();
            if(ms.length>0){
                for(Method m : ms){
                    System.out.println(m);
                }
            }
            //fields
            Field[] fs=c.getFields();
            if(fs.length>0){
                for(Field f : fs){
                    System.out.println(f);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}