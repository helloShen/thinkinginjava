/**
 *  We have two class named DebugClass
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter6.debug;

import java.util.*;

public class DebugClass{


    //debug() method
    public static void debug(){
        System.out.println("I am com.ciaoshen.thinkinjava.chapter6.debug.DebugClass.debug()");
    }
    
    //debug() method
    protected static void protectedDebug(){
        System.out.println("I am protectedDebug() method in chapter6.debug.DebugClass");
    }
    
    /**
     *  main method
     *  @param args void
     */
    public static void main(String[] args){
        
    }
}


class ProtectedClass{
    //fields
    //public int publicI=1024;
    public static int staticI=2048;
    
    //methods
    //public void publicPrint(){System.out.println("I am publicPrint() method!");}
    public static void staticPrint(){System.out.println("I am staticPrint() method!");}
}