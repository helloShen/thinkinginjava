/**
 *  Initialize Array
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter5;

import java.util.*;

/**
 *  our class
 */
public class ArrayIni {

    //for exercise 16
    //this form is only allowed in initializing block
    protected static String[] fiveStrArray = {"1","2","3","4","5"};
    
    //exercise 16
    public static void exercise16(){
        for(String ele : fiveStrArray){
            System.out.println(ele);
        }
        //the following line is wrong, we can not asign an array like that
        //Initialize.fiveStrArray = {"one","two","three","four","five"};
        fiveStrArray = new String[] {"one","two","three","four","five"};
        for(String ele : fiveStrArray){
            System.out.println(ele);
        }
    }

    //exercise 19: Variable arguments list
    public static void exercise19(Object[] args){
        for(Object ele : args){
            System.out.println(ele);
        }
    }
    
    public static void exercise20(Object[] args){
        for(Object ele : args){
            System.out.print(args+" | ");
        }
    }

    /**
     *  main method
     *  @param args void
     */
    public static void main(String[] args){
        //ArrayIni.exercise16();
        //ArrayIni.exercise19(new String[] {"one","two","three","four"});
        //String[] myStr = new String[] {"a","b","c","d"};
        //ArrayIni.exercise19(myStr);
        
        //exercise 20
        ArrayIni.exercise20(args);
    }
}