/**
 *  Exercise 1-5 Chapter 12
 */


package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;

class CustomException extends RuntimeException{private static final long serialVersionUID=0;}

public class TestException extends Exception{

    /**
     *  TEST UNIT (INNER CLASS)
     */
    private class Excecise{
        
        public void exercise1(){
            TestException te=TestException.this;
            try{
                throw te;
            }catch(TestException e){
                e.printInfo();
            }finally{
                System.out.println("Now I am in the finally block.");
            }
        }
        
        public void exercise2(){
            String strObj=null;
            try{
                System.out.println(strObj.contains(" "));
            }catch(NullPointerException npe){
                for(StackTraceElement ste : npe.getStackTrace()){
                    System.out.println(ste.getMethodName());
                }
            }
        }
        
        public boolean exercise3(int inNum){
            String[] strArray={"a","b","c"};
            try{
                for(int i=0;i<inNum;i++){
                    System.out.println(strArray[i]);
                }
                return true;
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("The length of strArray is "+strArray.length+". Please check your code!");
                return false;
            }
        }
        
        public void exercise4(){
            exercise1();
        }
        
        public void exercise5(int inNum){
            boolean finish=false;
            while(!finish){
                    finish=exercise3(inNum--);
            }
        }
        
        public void exercise8() throws TestException{
            throw new TestException();
        }
        
        public boolean exercise27(int inNum){
            String[] strArray={"a","b","c"};
            try{
                for(int i=0;i<inNum;i++){
                    System.out.println(strArray[i]);
                }
                return true;
            }catch(RuntimeException e){
                System.out.println("The length of strArray is "+strArray.length+". Please check your code!");
                return false;
            }
        }
        
        public void exercise28(){
            CustomException ce=new CustomException();
            try{
                throw ce;
            }catch(CustomException e){
                System.out.println(e);
            }finally{
                System.out.println("Now I am in the finally block.");
            }
            System.out.println("Now I am out of the try!");
        }
        
        
    }
    

    
    /**
     *  PUBLIC METHOD
     */
    public void printInfo(){
        System.out.println(info);
    }
    
    /**
     *  CONSTRUCTOR
     */
    public TestException(String str){
        info=str;
    }
    public TestException(){}
    
    /**
     *  PRIVATE FIELDS
     */
    private String info="Test Exception";
    private static final long serialVersionUID=0;
    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        TestException te=new TestException("I configure the info myself!");
        Excecise ex=te.new Excecise();
        //ex.exercise1();
        //ex.exercise2();
        //ex.exercise3(5);
        //ex.exercise4();
        //ex.exercise5(5);
        //try{
        //    ex.exercise8();
        //}catch(TestException e){}
        
        //ex.exercise27(5);
        ex.exercise28();
    }
}