/**
 *  Chapter 9 - Interface - Strategy Pattern
 *  Implements the interface Party
 *  PartyMember is an abstract class.
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;
import java.lang.Math;

abstract class PartyMember implements Party {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    
    /**
     *  PUBLIC METHODS
     */
    //Interface Party required methods
    //dummy implement
    public int immigrantPolicy(int illegalImmigrant){return illegalImmigrant;}
    
    public int educationPolicy(int educationScore){
        return educationScore;
    }
    
    public String getName(){return this.name;}
    /**
     *  PACKAGE ACCESS CONSTRUCTOR
     */
    PartyMember(String inputName){
        this.name=inputName;
    }
    
    /**
     *  PRIVATE FIELDS
     */
    private String name;
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        
    }
    
}