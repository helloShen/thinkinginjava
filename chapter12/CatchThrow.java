/**
 *  chapter 12
 */

package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;
import java.io.*;

class CatchThrow {
    /**
     *  METHODS
     */
    public static void testException(int inNum) {
        List<String> a=new ArrayList<String>();
        String str="HelloWorld";
        a.addAll(Arrays.asList(str.split("")));
        try{
            for(int i=0;i<inNum;i++){
                System.out.println(a.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(">>>From printStackTrace:");
            e.printStackTrace(System.out);
            
            System.out.println(">>>From StackTraceElement:");
            for(StackTraceElement ste : e.getStackTrace()){
                System.out.println(ste.getMethodName());
            }
        }
    }

    public static void testLoggingException(int inNum) {
        int i=0;
        while(i<10){
            try{
                System.out.println("Before exception test, i="+i);
                if(i!=8){
                    throw new LoggingException();
                } else {
                    break;
                }
            } catch (LoggingException e) {
                System.out.println("    >>>Not 8 exception!");
                //System.out.println(">>>From printStackTrace:");
                //e.printStackTrace(System.out);
            
                //System.out.println(">>>From StackTraceElement:");
                //for(StackTraceElement ste : e.getStackTrace()){
                //    System.out.println(ste.getMethodName());
                //}
            } finally {
                System.out.println("Already tried "+(i-1)+" times! Try again?");
                System.out.println("Yeah, try again!");
            }
            i++;
            
        }
        System.out.println("Now i=? i="+i);
    }

    
    /**
     *  CONSTRUCTOR
     */
    
    /**
     *  FIELDS
     */
    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        //CatchThrow.testException(20);
        CatchThrow.testLoggingException(20);
    }


}