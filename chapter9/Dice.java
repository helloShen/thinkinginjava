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
class Dice implements Rander {
    
    /**
     *  PUBLIC PROXY OF CONSTUCTOR
     */
    public static Dice createDice(){return new Dice();}
    
    /**
     *  METHODS
     */
    public int tossing(){
        int num=(this.diceRander.nextInt(6))+1;
        System.out.println(num);
        return num;
    }

    /**
     *  PRIVATE CONSTRUCTOR
     */
    private Dice(){
        this.diceRander=new Random();
    }
    
    /**
     *  PRIVATE FIELDS
     */
    Random diceRander;
    /**
     *  MAIN void
     */
    public static void main(String[] args){
        
    }
    
}