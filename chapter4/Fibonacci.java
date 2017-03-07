/**
 *  Fibonacci
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter4;

import java.util.*;

/**
 *  This class contain different method to calculate Fibonacci number.
 */
public class Fibonacci {
    /**
     *  some initial fields of the Fibonacci class
     */
    //CONSTANT: fibonacci need two "1" at the beginning
    private static long HEADONE = 1L;
    private static long HEADTWO = 1L;
    //container of fibonacci result
    private static List<Long> fibonacciList = new ArrayList<Long>();
    //我犯的一个错，<T>泛型里必须是对象，不能是基本型
    //private static List<int> fibonacciList = new ArrayList<int>();

    //we can also put this section into the constructor.
    static{
        fibonacciList.add(HEADONE);
        fibonacciList.add(HEADTWO);
    }

    //default constructor
    public Fibonacci(){ }

    //print the fibonacci list
    public static void print(List<Long> inList){
        //for print comma
        boolean isFirstNum=true;
        for(long ele : inList){
            if(!isFirstNum){
                System.out.print(", ");
            } else {
                isFirstNum=false;
            }
            System.out.print(ele);
        }
        System.out.println("");
    }

    //the traditional iteration
    public static List<Long> iterFibo(int howMuch){
        //if not enough number, get the next one
        for(int i=2;i<howMuch;i++){
            //sum the last two number
            long newNum = fibonacciList.get(fibonacciList.size()-2)+fibonacciList.get(fibonacciList.size()-1);
            //insert into result list
            fibonacciList.add(newNum);
        }
        return fibonacciList;
    }
    
    //the traditional recuresion
    public static List<Long> recurFibo(int size){
        //base case
        if (size==1) {
            List<Long> oneFiboList = new ArrayList<Long>();
            oneFiboList.add(1L);
            return oneFiboList;
        } else if (size==2) {
            List<Long> twoFiboList = new ArrayList<Long>();
            twoFiboList.add(1L);
            twoFiboList.add(1L);
            return twoFiboList;
        } else {
            //go deeper: ask for last fibonacci list
            List<Long> lastFiboList = recurFibo(size-1);
            
            //go back: add the new number
            long number1 = lastFiboList.get(lastFiboList.size()-1);
            long number2 = lastFiboList.get(lastFiboList.size()-2);
            long newNum = number1+number2;
            lastFiboList.add(newNum);
            
            //return
            return lastFiboList;
        }
    }
    
    public static long fibo(int size){
        //base case
        if(size<=2){
            return 1;
        } else {
            return fibo(size-1)+fibo(size-2);
        }
    }

    /**
     *  main method
     *  @param args void
     */
    public static void main (String args[]){
        //List<Long> testList1 = Fibonacci.iterFibo(10);
        //Fibonacci.print(testList1);
        
        List<Long> testList2 = Fibonacci.recurFibo(200);
        Fibonacci.print(testList2);
        
        /*************************************
        //just give me the next fibo quickly
        for (int i=1;i<200;i++){
            System.out.print (fibo(i)+" ");
        }
         *************************************/
        
    }

}