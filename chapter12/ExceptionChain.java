/**
 *  Exercise 10-11 - Chapter 12
 */


package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;
//import java.util.logging.*;
//import java.io.*;

class ExceptionChain {
    
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
    public void f() throws ExceptionChain.ExceptionA {
        throw this.new ExceptionA();
    }
    
    public void g() throws ExceptionChain.ExceptionB {
        try{
            f();
        }catch(ExceptionA eA){
            ExceptionChain.ExceptionB eB=this.new ExceptionB();
            eB.initCause(eA);
            throw eB;
        }
    }
    
    public void h() throws RuntimeException {
        try{
            g();
        }catch(ExceptionB eB){
            throw new RuntimeException(eB);
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
        ExceptionChain ec=new ExceptionChain();
        try{
            ec.g();
        }catch(ExceptionB eB){
            eB.printStackTrace(System.err);
        }
        
        ec.h();
    }
}
