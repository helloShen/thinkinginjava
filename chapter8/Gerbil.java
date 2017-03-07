/**
 *  Exercise 9 - Polymophism
 *  Gerbil is a type of Rodent.
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter8;
import java.util.*;

class Gerbil extends Rodent {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static Rodent newRodent(){
        return new Gerbil();
    }
    
    /**
     *  PUBLIC METHODS
     */
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private Gerbil(){
        System.out.println("Gerbil constructor{}");
        super.name="gerbil";
        super.food="wheat";
        System.out.println(">>> A Gerbil join the rodent legion!!!");
        System.out.println("");
    }
    
    {
        System.out.println("Before Gerbil constructor{}: Initialize fields and methods.");
    }
    
    /**
     *  PRIVATE FIELDS
     */
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        System.out.println(Gerbil.newRodent().toString());
    }
    
}