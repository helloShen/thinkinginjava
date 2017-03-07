/**
 * Write a program that includes and calls the storage( ) method defined as a code fragment in this chapter.
 * @author Wei SHEN
 * @author wei.shen@iro.umontreal.ca
 * @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter2;

import java.util.*;

/**
 * Caculator class
 */
public class Calculator {
    /**
     * no parameters here
     */
    
    
    /**
     *  Static method
     *  Return the size of a string in memory.
     *  @param s need to pass the string.
     */
    public static int storage(String s){
        return s.length() * 2;
    }
    
    /**
     * main method
     * @param args useless
     */
    public static void main (String args[]){
        //here is the string
        String argS = "Hello World!";
        //calculate the storage of the string.
        System.out.println(Calculator.storage(argS));
    }
}