/**
 *  Exercise 9 - Polymophism
 *  Humster is a type of Rodent.
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter8;
import java.util.*;

class Hamster extends Rodent {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static Rodent newRodent(){
        return new Hamster();
    }
    
    /**
     *  PUBLIC METHODS
     */
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private Hamster(){
        System.out.println("Hamster constructor{}");
        super.name="hamster";
        super.food="nut";
        System.out.println(">>> A Hamster join the rodent legion!!!");
        System.out.println("");
    }
    
    {
        System.out.println("Before Hamster constructor{}: Initialize fields and methods.");
    }
    
    /**
     *  PACKAGE ACCESS FIELDS
     */
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        System.out.println(Hamster.newRodent().toString());
    }
    
}