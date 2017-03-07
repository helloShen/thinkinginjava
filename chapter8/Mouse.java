/**
 *  Exercise 9 - Polymophism
 *  Mouse is a type of Rodent.
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter8;
import java.util.*;

class Mouse extends Rodent {

    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static Rodent newRodent(){
        return new Mouse();
    }
    
    /**
     *  PUBLIC METHODS
     */

    /**
     *  PRIVATE CONSTRUCTOR
     */
    private Mouse(){
        System.out.println("Mouse constructor{}");
        super.name="mouse";
        super.food="rice";
        System.out.println(">>> A Mouse join the rodent legion!!!");
        System.out.println("");
    }
    
    {
        System.out.println("Before Mouse constructor{}: Initialize fields and methods.");
    }
    
    /**
     *  PRIVATE FIELDS
     */
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        System.out.println(Mouse.newRodent().toString());
    }
    
}