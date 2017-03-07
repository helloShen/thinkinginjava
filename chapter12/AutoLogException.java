/**
 *  Exercise 6-7 - Chapter 12
 */


package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;
import java.util.logging.*;
import java.io.*;

class AutoLogException extends Exception{
    
    /**
     *  TEST UNIT (INNER CLASS)
     */
    private class Exercise{
        public void exercise6(){
            try{
                throw AutoLogException.this;
            }catch(AutoLogException ale){
                System.err.println("Caught "+ale);
                ale.printLogging();
            }
        }
        
        public void exercise7(int inNum){
            String[] strArray={"a","b","c"};
            try{
                for(int i=0;i<inNum;i++){
                    System.out.println(strArray[i]);
                }
            }catch(ArrayIndexOutOfBoundsException e){
                Logger log=Logger.getLogger("ArrayIndexOutOfBoundsException Logger");
                StringWriter trace=new StringWriter();
                e.printStackTrace(new PrintWriter(trace));
                log.severe(trace.toString());
            }
        }
    }

    /**
     *  PUBLIC METHOD
     */
    public void printInfo(){
        System.out.println(info);
    }
    
    public void printLogging(){
        StringWriter trace=new StringWriter();  //create a PrintStream
        printStackTrace(new PrintWriter(trace));    //add trace information to the PrintStream
        autoLogger.severe(trace.toString());    //convert the PrintStream to the String and add it into the Logger
    }
    
    
    /**
     *  CONSTRUCTOR
     */
    public AutoLogException(String str){
        info=str;
    }
    public AutoLogException(){}
    
    /**
     *  PRIVATE FIELDS
     */
    private String info="Auto Log Exception";
    private static final long serialVersionUID=0;
    
    private Logger autoLogger=Logger.getLogger("Auto Logger");
    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        AutoLogException ale=new AutoLogException();
        Exercise ex=ale.new Exercise();
        //ex.exercise6();
        ex.exercise7(5);
        
    }

}