/**
 *  证明子类可以重载父类方法。
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter7;
import java.util.*;


public class TestOverload {
    
    //public method
    public void overloadedMethod(){
        System.out.println("overloadedMethod(): No parameter");
    }
    public void overloadedMethod(int i){
        System.out.println("overloadedMethod(): int");
    }
    public void overloadedMethod(String s){
        System.out.println("overloadedMethod(): String");
    }
    
    
    /******************************************************
     *
     *  这样以不同的返回值，区分不同方法，编译器不接受。
     *
    public int overloadedMethod(int i){
        System.out.println("overloadedMethod(): int; return int");
        return i;
    }
     *
     ******************************************************/
    
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        
    }
}