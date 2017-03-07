/**
 *  Create a class containing an int and a char that are not initialized, and print their values to verify that Java performs default initialization.
 *  @author Wei SHEN
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter2;


/**
 *  The class containing an int and a char that are not initialized
 */
public class DefaultValueTest {
    /**
     *  Give me int and char
     */
    
    public int i;
    public char c;
    
    
    
    /**
     *  The main method
     *  @param args is not used here.
     */
    public static void main(String args[]){
        DefaultValueTest myTest = new DefaultValueTest();
        
        //print the int and char
        System.out.println(myTest.i);
        System.out.println(myTest.c);
    }
    
}