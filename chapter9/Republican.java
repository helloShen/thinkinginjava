/**
 *  Chapter 9 - Interface - Strategy Pattern
 *  Implements the interface Party
 *  Republican hate illegal immigrations.
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;
import java.lang.Math;

class Republican extends PartyMember {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    
    /**
     *  PUBLIC METHODS
     */
    public int immigrantPolicy(int illegalImmigrant){
        return (int)(illegalImmigrant*0.95);
    }
    
    public int educationPolicy(int educationScore){
        return (Math.min(100,(educationScore+5)));
    }
    
    /**
     *  PACKAGE ACCESS CONSTRUCTOR
     */
    Republican(String inputName){
        super(inputName);
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