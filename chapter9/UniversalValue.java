/**
 *  Chapter 9 - Interface - State Parttern & Strategy Pattern
 *  Ideology is an interface.
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class UniversalValue implements Ideology {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    
    /**
     *  PUBLIC METHODS
     */
    public int offset(int immigrants){
        return immigrants*1.5;
    }
    
    /**
     *  PACKAGE ACCESS CONSTRUCTOR
     */
    UniversalValue(){System.out.println("We believe Universal Value!");}
    
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