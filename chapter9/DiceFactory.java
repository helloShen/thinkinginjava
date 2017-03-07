/**
 *  Chapter 9 - Exercise 19
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

/**
 *  Only package access
 */
 class DiceFactory implements RanderFactory {
    
    /**
     *  PUBLIC PROXY OF CONSTUCTOR
     */

    /**
     *  METHODS
     */
     public Rander getRander(){
         return Dice.createDice();
     }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    
    /**
     *  PRIVATE FIELDS
     */
     
    /**
     *  MAIN void
     */
    public static void main(String[] args){
        
    }
    
}