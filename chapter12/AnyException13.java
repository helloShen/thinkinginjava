/**
 *  Exercise 13 - Chapter 12
 */


package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;
//import java.util.logging.*;
//import java.io.*;

class AnyException13 {
    
    /**
     *  INNER CLASS (EXCEPTIONS)
     */
    private class ExceptionA extends Exception{
        private static final long serialVersionUID=0;
    }
    
    private class ExceptionB extends Exception{
        private static final long serialVersionUID=0;
    }
    
    private class ExceptionC extends Exception{
        private static final long serialVersionUID=0;
    }
    
    /**
     *  PUBLIC METHOD
     */
    public void throwExceptions(int pointer) throws AnyException13.ExceptionA,AnyException13.ExceptionB,AnyException13.ExceptionC{
        intArray[pointer]=pointer;
        switch(pointer){
            case 1:
                throw AnyException13.this.new ExceptionA();
            case 2:
                throw AnyException13.this.new ExceptionB();
            case 3:
                throw AnyException13.this.new ExceptionC();
        }
    }
    
    
    /**
     *  CONSTRUCTOR
     */
    
    /**
     *  PRIVATE FIELDS
     */
    int[] intArray=new int[4];
    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        AnyException13 ae=new AnyException13();
        for(int i=1;i<5;i++){
            try{
                ae.throwExceptions(i);
            }catch(Exception e){
                e.printStackTrace(System.err);
            }finally{
                System.out.println(">>>"+i+"<<< Finish!");
            }
        }
    }
}
