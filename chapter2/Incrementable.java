/**
 *  Turn the Incrementable code fragments into a working program.
 *  @author Wei SHEN
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter2;

import java.util.*;


/**
 *  Test of static value.
 *  This method will call StaticTest class, which contain a static value.
 *
 */
class Incrementable {
    /**
     *  Increment the number in StaticTest one by one.
     *  @param no parameter here.
     */
    static void increment() { StaticTest.i++; }
    /**
     *  StaticTest add 1.
     *  @param args not used here.
     */
    static void excercise7 (){
        Incrementable.increment();
        System.out.println(StaticTest.i);
    }
    
    /**
     *  Test that static field has only one object in memory.
     */
    static void excercise8() {
        //create 3 StaticTest object
        StaticTest test1 = new StaticTest();
        StaticTest test2 = new StaticTest();
        StaticTest test3 = new StaticTest();
        //print them
        System.out.println(test1.i);
        System.out.println(test2.i);
        System.out.println(test3.i);
        //StaticTest add 1
        Incrementable.increment();
        //print three StaticTest objects again.
        System.out.println(test1.i);
        System.out.println(test2.i);
        System.out.println(test3.i);
    }
    public static void main (String args[]){
        Incrementable.excercise7();
        Incrementable.excercise8();
    }
}

