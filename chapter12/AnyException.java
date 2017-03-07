/**
 *  Exercise 9 - Chapter 12
 */


package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;
//import java.util.logging.*;
//import java.io.*;

class AnyException {
    
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
    public void throwExceptions(int pointer) throws AnyException.ExceptionA,AnyException.ExceptionB,AnyException.ExceptionC{
        switch(pointer){
            case 1:
                throw AnyException.this.new ExceptionA();
            case 2:
                throw AnyException.this.new ExceptionB();
            case 3:
                throw AnyException.this.new ExceptionC();
        }
    }
    
    
    /**
     *  CONSTRUCTOR
     */
    
    /**
     *  PRIVATE FIELDS
     */
    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        AnyException ae=new AnyException();
        for(int i=1;i<4;i++){
            try{
                ae.throwExceptions(i);
            }catch(Exception e){
                e.printStackTrace(System.err);
            }
        }
    }
}
    