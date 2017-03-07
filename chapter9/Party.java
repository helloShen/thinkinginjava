/**
 *  Chapter 9 - Interface - State Pattern & Strategy Pattern
 *  Party is an interface.
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

interface Party {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    
    /**
     *  PUBLIC METHODS
     */
    public int immigrantPolicy(int illegalImmigrant);
    public int educationPolicy(int educationScore);
    
    /**
     *  PACKAGE ACCESS CONSTRUCTOR
     */

    /**
     *  PRIVATE FIELDS
     */
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        
    }
    
}