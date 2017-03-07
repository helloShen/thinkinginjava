/**
 *  We have two class named DebugClass
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter6;

import java.util.*;

public class SameNameClass{
    //public method
    public static void publicDebug(){
        System.out.println("I am publicDebug() method in chapter6.SameNameClass");
    }
    
    //protected method
    protected static void protectedDebug(){
        System.out.println("I am protectedDebug() method in chapter6.SameNameClass");
    }
    
    //private method
    private static void privateDebug(){
        System.out.println("I am privateDebug() method in chapter6.SameNameClass");
    }
    /**
     *  main method
     *  @param args void
     */
    public static void main(String[] args){
        //DebugClass.debug();     //  - 1 -
        //com.ciaoshen.thinkinjava.chapter6.debug.DebugClass.debug();     //  - 2 -
    }
}