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
interface Rander {
    
    /**
     *  PUBLIC PROXY OF CONSTUCTOR
     */
    
    /**
     *  METHODS
     */
    public int tossing();
    
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
        RanderFactory coinFac=new CoinFactory();
        Rander myCoin=coinFac.getRander();
        myCoin.tossing();
        
        RanderFactory diceFac=new DiceFactory();
        Rander myDice=diceFac.getRander();
        myDice.tossing();
    }
    
}